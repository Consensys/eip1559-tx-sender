package tech.pegasys.net.core;

import tech.pegasys.net.api.AccountRepository;
import tech.pegasys.net.api.ChainFiller;
import tech.pegasys.net.api.ContractRepository;
import tech.pegasys.net.api.CredentialsRepository;
import tech.pegasys.net.api.EIP1559TransactionCreator;
import tech.pegasys.net.api.LegacyTransactionCreator;
import tech.pegasys.net.api.Reporter;
import tech.pegasys.net.config.ChainFillerConfiguration;

import javax.inject.Inject;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
      System.out.printf("starting chain-filler with configuration: %s\n", configuration.toString());
      if (configuration.repeatEveryNSeconds() > 0) {
        System.out.printf(
            "scheduling chain-filler every %d seconds\n", configuration.repeatEveryNSeconds());
        final ScheduledFuture<?> scheduledFuture =
            Executors.newScheduledThreadPool(1)
                .scheduleAtFixedRate(
                    this::process, 0, configuration.repeatEveryNSeconds(), TimeUnit.SECONDS);
        scheduledFuture.get(1, TimeUnit.DAYS);
      } else {
        process();
      }
      System.out.println("chain-filler execution completed");
      System.out.println(reporter.report());
    } catch (final Exception e) {
      System.err.printf("chain-filler error occurred: %s\n", e.getMessage());
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
      System.err.printf("chain-filler error occurred: %s\n", e.getMessage());
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
