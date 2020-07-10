package tech.pegasys.net.core;

import com.google.common.collect.Lists;
import org.tinylog.Logger;
import org.web3j.crypto.Credentials;
import tech.pegasys.net.api.model.ActionableAccount;
import tech.pegasys.net.api.repository.AccountRepository;
import tech.pegasys.net.api.repository.ContractRepository;
import tech.pegasys.net.api.repository.CredentialsRepository;
import tech.pegasys.net.api.service.ChainFiller;
import tech.pegasys.net.api.service.metrics.Reporter;
import tech.pegasys.net.api.service.transaction.EIP1559TransactionCreator;
import tech.pegasys.net.api.service.transaction.LegacyTransactionCreator;
import tech.pegasys.net.config.ChainFillerConfiguration;
import tech.pegasys.net.core.account.AccountProcessorService;
import tech.pegasys.net.fuzzer.NatsFuzzer;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ChainFillerService implements ChainFiller {
  private final ChainFillerConfiguration configuration;
  private final CredentialsRepository credentialsRepository;
  private final AccountRepository accountRepository;
  private final ContractRepository contractRepository;
  private final LegacyTransactionCreator legacyTransactionCreator;
  private final EIP1559TransactionCreator eip1559TransactionCreator;
  private final Reporter reporter;
  final ExecutorService executor;
  private List<ActionableAccount> accounts;

  @Inject
  public ChainFillerService(
      final ChainFillerConfiguration configuration,
      final CredentialsRepository credentialsRepository,
      final AccountRepository accountRepository,
      final ContractRepository contractRepository,
      final LegacyTransactionCreator legacyTransactionCreator,
      final EIP1559TransactionCreator eip1559TransactionCreator,
      final Reporter reporter) {
    this.configuration = configuration;
    this.credentialsRepository = credentialsRepository;
    this.accountRepository = accountRepository;
    this.contractRepository = contractRepository;
    this.legacyTransactionCreator = legacyTransactionCreator;
    this.eip1559TransactionCreator = eip1559TransactionCreator;
    this.reporter = reporter;
    executor = Executors.newFixedThreadPool(configuration.numThreads());
    accounts = new ArrayList<>();
  }

  @Override
  public void fill() {
    try {
      Logger.info("starting chain-filler");
      prepareAccounts();
      switch (configuration.fillerMode()) {
        case SCHEDULER:
          Logger.info(
              "scheduling chain-filler every {} seconds\n", configuration.repeatEveryNSeconds());
          final ScheduledFuture<?> scheduledFuture =
              Executors.newScheduledThreadPool(configuration.numThreads())
                  .scheduleAtFixedRate(
                      this::process, 0, configuration.repeatEveryNSeconds(), TimeUnit.SECONDS);
          scheduledFuture.get(1, TimeUnit.DAYS);
          break;
        case CONTINUOUS:
          ImmutableRxChainFiller.builder()
              .chainFiller(this)
              .configuration(configuration)
              .build()
              .start();
          break;
        case EXTERNAL_FUZZER_NATS:
          final Future<Boolean> natsFuzzerJob = new NatsFuzzer(this, configuration).start();
          while (!natsFuzzerJob.isDone()) {
            Thread.sleep(1000);
          }
          Logger.info("nats fuzzer job completed with status: {}", natsFuzzerJob.get());
          break;
        case ONESHOT:
        default:
          process();
          break;
      }
      Logger.info("chain-filler execution completed");
      // System.out.println(reporter.report());
    } catch (final Exception e) {
      Logger.error(e, "chain-filler error occurred");
    }
  }

  private void prepareAccounts() throws InterruptedException {
    Logger.debug("preparing accounts");
    final List<String> rpcEndpoints = configuration.rpcEndpoints();
    final ExecutorService accountsPreparationExecutor =
        Executors.newFixedThreadPool(rpcEndpoints.size());
    final List<List<String>> privateKeysPartitions =
        Lists.partition(
            configuration.accountPrivateKeys(),
            configuration.accountPrivateKeys().size() / rpcEndpoints.size());
    for (int i = 0; i < rpcEndpoints.size(); i++) {
      final int index = i;
      accountsPreparationExecutor.submit(
          () -> {
            final String rpcEndpoint = rpcEndpoints.get(index);
            Logger.debug("loading accounts parameters from node {}", rpcEndpoint);
            final List<String> privateKeysPartition = privateKeysPartitions.get(index);
            accounts.addAll(
                privateKeysPartition.stream()
                    .map(
                        privateKey ->
                            new ActionableAccount(Credentials.create(privateKey), rpcEndpoint)
                                .updated())
                    .collect(Collectors.toList()));
            Logger.debug(
                "{} accounts parameters successfully loaded from node {}",
                privateKeysPartition.size(),
                rpcEndpoint);
          });
    }
    accountsPreparationExecutor.shutdown();
    accountsPreparationExecutor.awaitTermination(10, TimeUnit.MINUTES);
    accounts.forEach(System.out::println);
    Logger.debug("accounts prepared");
  }

  private void process() {
    try {
      final ExecutorService executorService =
          Executors.newFixedThreadPool(configuration.numThreads());
      final int eip1559Txs =
          (int) Math.ceil(configuration.numTransactions() * configuration.eip1559TxWeight());
      final int legacyTxs = configuration.numTransactions() - eip1559Txs;
      final ChainFiller chainFiller = this;
      accounts
          .parallelStream()
          .forEach(
              actionableAccount ->
                  executorService.submit(
                      () ->
                          AccountProcessorService.process(
                              chainFiller,
                              actionableAccount,
                              legacyTxs,
                              eip1559Txs,
                              configuration.numSmartContracts())));
      executorService.shutdown();
      executorService.awaitTermination(1, TimeUnit.DAYS);
      System.out.println(chainFiller.reporter().report());
    } catch (final Exception e) {
      Logger.error(e, "chain-filler error occurred");
    }
  }

  @Override
  public AccountRepository accountRepository() {
    return accountRepository;
  }

  @Override
  public CredentialsRepository credentialsRepository() {
    return credentialsRepository;
  }

  @Override
  public ContractRepository contractRepository() {
    return contractRepository;
  }

  @Override
  public LegacyTransactionCreator legacyTransactionCreator() {
    return legacyTransactionCreator;
  }

  @Override
  public EIP1559TransactionCreator eip1559TransactionCreator() {
    return eip1559TransactionCreator;
  }

  @Override
  public Reporter reporter() {
    return reporter;
  }
}
