package tech.pegasys.net.core;

import tech.pegasys.net.util.EthereumUtils;

import java.util.stream.IntStream;

public class TxSenderTask implements Runnable {
  private final String taskId;
  private final String rpcEndpoint;
  private final String accountPrivateKey;
  private final int numTransactionsLegacy;
  private final int numTransactionsEIP1559;

  public TxSenderTask(
      final String rpcEndpoint,
      final String accountPrivateKey,
      final int numTransactionsLegacy,
      final int numTransactionsEIP1559) {
    this.rpcEndpoint = rpcEndpoint;
    this.accountPrivateKey = accountPrivateKey;
    this.numTransactionsLegacy = numTransactionsLegacy;
    this.numTransactionsEIP1559 = numTransactionsEIP1559;
    this.taskId =
        String.format("[%s - %s]", rpcEndpoint, EthereumUtils.censorPrivateKey(accountPrivateKey));
  }

  @Override
  public void run() {
    System.out.printf("%s task started\n", taskId);
    IntStream.range(0, numTransactionsLegacy).forEach(__ -> sendLegacyTransaction());
    IntStream.range(0, numTransactionsEIP1559).forEach(__ -> sendEIP1559Transaction());
    System.out.printf("%s task completed\n", taskId);
  }

  private void sendLegacyTransaction() {}

  private void sendEIP1559Transaction() {}
}
