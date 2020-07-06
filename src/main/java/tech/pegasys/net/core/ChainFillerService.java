package tech.pegasys.net.core;

import org.tinylog.Logger;
import tech.pegasys.net.api.service.AccountRepository;
import tech.pegasys.net.api.service.ChainFiller;
import tech.pegasys.net.api.service.ContractRepository;
import tech.pegasys.net.api.service.CredentialsRepository;
import tech.pegasys.net.api.service.EIP1559TransactionCreator;
import tech.pegasys.net.api.service.LegacyTransactionCreator;
import tech.pegasys.net.api.service.Reporter;
import tech.pegasys.net.config.ChainFillerConfiguration;
import tech.pegasys.net.fuzzer.NatsFuzzer;

import javax.inject.Inject;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ChainFillerService implements ChainFiller {
  private final ChainFillerConfiguration configuration;
  private final CredentialsRepository credentialsRepository;
  private final AccountRepository accountRepository;
  private final ContractRepository contractRepository;
  private final LegacyTransactionCreator legacyTransactionCreator;
  private final EIP1559TransactionCreator eip1559TransactionCreator;
  private final Reporter reporter;

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
  }

  @Override
  public void fill() {
    try {
      Logger.info("starting chain-filler");
      switch (configuration.fillerMode()) {
        case SCHEDULER:
          Logger.info(
              "scheduling chain-filler every {} seconds\n", configuration.repeatEveryNSeconds());
          final ScheduledFuture<?> scheduledFuture =
              Executors.newScheduledThreadPool(1)
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
          final Future<Boolean> natsFuzzerJob =
              new NatsFuzzer(
                      Executors.newSingleThreadExecutor(),
                      this,
                      configuration.natsURL(),
                      configuration.natsAsyncConnection(),
                      configuration.natsFuzzerTopicTransactions())
                  .start();
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

  private void process() {
    try {
      final ExecutorService executorService =
          Executors.newFixedThreadPool(configuration.numThreads());
      final int eip1559Txs =
          (int) Math.ceil(configuration.numTransactions() * configuration.eip1559TxWeight());
      final int legacyTxs = configuration.numTransactions() - eip1559Txs;
      configuration
          .rpcEndpoints()
          .forEach(
              rpcEndpoint ->
                  configuration
                      .accountPrivateKeys()
                      .forEach(
                          accountPrivateKey ->
                              executorService.submit(
                                  new ChainFillerTask(
                                      this,
                                      rpcEndpoint,
                                      accountPrivateKey,
                                      legacyTxs,
                                      eip1559Txs,
                                      configuration.numSmartContracts()))));
      executorService.shutdown();
      executorService.awaitTermination(1, TimeUnit.DAYS);
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
