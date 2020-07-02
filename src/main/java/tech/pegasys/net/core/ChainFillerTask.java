package tech.pegasys.net.core;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Numeric;
import tech.pegasys.net.api.ChainFiller;
import tech.pegasys.net.api.TransactionSigner;
import tech.pegasys.net.api.model.EIP1559Transaction;
import tech.pegasys.net.api.model.LegacyTransaction;
import tech.pegasys.net.util.EthereumUtils;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class ChainFillerTask implements Runnable {
  private final ChainFiller chainFiller;
  private final String taskId;
  private final Credentials credentials;
  private final String rpcEndpoint;
  private final String accountPrivateKey;
  private final int numTransactionsLegacy;
  private final int numTransactionsEIP1559;
  private final Web3j web3;
  private AtomicLong nonce;
  private BigInteger initialGasPrice;

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
    this.web3 = Web3j.build(new HttpService(rpcEndpoint));
    try {
      this.nonce =
          new AtomicLong(
              web3.ethGetTransactionCount(
                      credentials.getAddress(), DefaultBlockParameterName.LATEST)
                  .send()
                  .getTransactionCount()
                  .longValue());
      this.initialGasPrice = web3.ethGasPrice().send().getGasPrice();
    } catch (Exception e) {
      System.err.printf(
          "%s error setting initial parameters (nonce, gasPrice) : %s\n", taskId, e.getMessage());
      this.initialGasPrice = BigInteger.ZERO;
    }
  }

  @Override
  public void run() {
    System.out.printf("%s task started\n", taskId);
    IntStream.range(0, numTransactionsLegacy).forEach(__ -> sendLegacyTransaction());
    IntStream.range(0, numTransactionsEIP1559).forEach(__ -> sendEIP1559Transaction());
    System.out.printf("%s task completed\n", taskId);
  }

  private void sendLegacyTransaction() {
    try {
      final LegacyTransaction legacyTransaction =
          chainFiller
              .legacyTransactionCreator()
              .create(BigInteger.valueOf(nonce.getAndIncrement()), initialGasPrice);
      System.out.printf("%s %s\n", taskId, legacyTransaction.toString());
      final byte[] signedMessage = TransactionSigner.sign(legacyTransaction, credentials);
      web3.ethSendRawTransaction(Numeric.toHexString(signedMessage)).send();
      chainFiller.reporter().incLegacyTransactions();
    } catch (final Exception e) {
      System.err.printf("%s error sending legacy transaction: %s\n", taskId, e.getMessage());
      chainFiller.reporter().incLegacyTransactionsError();
    }
  }

  private void sendEIP1559Transaction() {
    try {
      final EIP1559Transaction eip1559Transaction =
          chainFiller
              .eip1559TransactionCreator()
              .create(BigInteger.valueOf(nonce.getAndIncrement()));
      System.out.printf("%s %s\n", taskId, eip1559Transaction.toString());
      final byte[] signedMessage = TransactionSigner.sign(eip1559Transaction, credentials);
      web3.ethSendRawTransaction(Numeric.toHexString(signedMessage)).send();
      chainFiller.reporter().incEIP1559Transactions();
    } catch (final Exception e) {
      System.err.printf("%s error sending eip1559 transaction: %s\n", taskId, e.getMessage());
      chainFiller.reporter().incEIP1559TransactionsError();
    }
  }
}
