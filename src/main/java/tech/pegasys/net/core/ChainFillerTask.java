package tech.pegasys.net.core;

import org.web3j.crypto.Credentials;
import tech.pegasys.net.api.AccountRepository;
import tech.pegasys.net.api.ChainFiller;
import tech.pegasys.net.api.model.EIP1559Transaction;
import tech.pegasys.net.api.model.LegacyTransaction;
import tech.pegasys.net.util.EthereumUtils;

import java.util.stream.IntStream;

public class ChainFillerTask implements Runnable {
  private final ChainFiller chainFiller;
  private final String taskId;
  private final Credentials credentials;
  private final String rpcEndpoint;
  private final String accountPrivateKey;
  private final int numTransactionsLegacy;
  private final int numTransactionsEIP1559;

  public ChainFillerTask(
      final ChainFiller chainFiller,
      final String rpcEndpoint,
      final String accountPrivateKey,
      final int numTransactionsLegacy,
      final int numTransactionsEIP1559) {
    this.chainFiller = chainFiller;
    this.rpcEndpoint = rpcEndpoint;
    this.accountPrivateKey = accountPrivateKey;
    this.numTransactionsLegacy = numTransactionsLegacy;
    this.numTransactionsEIP1559 = numTransactionsEIP1559;
    this.taskId =
        String.format("[%s - %s]", rpcEndpoint, EthereumUtils.censorPrivateKey(accountPrivateKey));
    this.credentials =
        this.chainFiller.credentialsRepository().get(accountPrivateKey).orElseThrow();
  }

  @Override
  public void run() {
    System.out.printf("%s task started\n", taskId);
    IntStream.range(0, numTransactionsLegacy).forEach(__ -> sendLegacyTransaction());
    IntStream.range(0, numTransactionsEIP1559).forEach(__ -> sendEIP1559Transaction());
    System.out.printf("%s task completed\n", taskId);
  }

  private void sendLegacyTransaction() {
    final LegacyTransaction legacyTransaction = chainFiller.legacyTransactionCreator().create();
    System.out.printf("%s %s\n", taskId, legacyTransaction.toString());
    chainFiller.reporter().incLegacyTransactions();
  }

  private void sendEIP1559Transaction() {
    final EIP1559Transaction eip1559Transaction = chainFiller.eip1559TransactionCreator().create();
    System.out.printf("%s %s\n", taskId, eip1559Transaction.toString());
    chainFiller.reporter().incEIP1559Transactions();
  }
}
