package tech.pegasys.net.core;

import tech.pegasys.net.api.TxSender;
import tech.pegasys.net.config.TxSenderConfiguration;

import javax.inject.Inject;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TxSenderService implements TxSender {
  private final TxSenderConfiguration configuration;

  @Inject
  public TxSenderService(final TxSenderConfiguration configuration) {
    this.configuration = configuration;
  }

  @Override
  public void run() {
    try {
      System.out.printf("starting tx-sender with configuration: %s\n", configuration.toString());
      if (configuration.repeatEveryNSeconds() > 0) {
        System.out.printf(
            "scheduling tx-sender every %d seconds\n", configuration.repeatEveryNSeconds());
        final ScheduledFuture<?> scheduledFuture = Executors.newScheduledThreadPool(1)
                .scheduleAtFixedRate(
                        this::process, 0, configuration.repeatEveryNSeconds(), TimeUnit.SECONDS);
        scheduledFuture.get(1, TimeUnit.DAYS);
      } else {
        process();
      }
      System.out.println("tx-sender execution completed");
    } catch (final Exception e) {
      System.err.printf("tx-sender error occurred: %s\n", e.getMessage());
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
                                  new TxSenderTask(
                                      rpcEndpoint, accountPrivateKey, legacyTxs, eip1559Txs))));
      executorService.shutdown();
      executorService.awaitTermination(1, TimeUnit.DAYS);
    } catch (final Exception e) {
      System.err.printf("tx-sender error occurred: %s\n", e.getMessage());
    }
  }
}
