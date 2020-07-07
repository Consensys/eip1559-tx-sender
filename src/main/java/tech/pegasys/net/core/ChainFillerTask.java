package tech.pegasys.net.core;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

import org.tinylog.Logger;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Numeric;
import tech.pegasys.net.api.model.EIP1559Transaction;
import tech.pegasys.net.api.model.LegacyTransaction;
import tech.pegasys.net.api.service.ChainFiller;
import tech.pegasys.net.api.service.transaction.TransactionSigner;
import tech.pegasys.net.util.EthereumUtils;

public class ChainFillerTask implements Runnable {
  private final ChainFiller chainFiller;
  private final String taskId;
  private final Credentials credentials;
  private final String rpcEndpoint;
  private final String accountPrivateKey;
  private final int numTransactionsLegacy;
  private final int numTransactionsEIP1559;
  private final int numSmartContracts;
  private final Web3j web3;
  private AtomicLong nonce;
  private BigInteger initialGasPrice;

  public ChainFillerTask(
      final ChainFiller chainFiller,
      final String rpcEndpoint,
      final String accountPrivateKey,
      final int numTransactionsLegacy,
      final int numTransactionsEIP1559,
      final int numSmartContracts) {
    this.chainFiller = chainFiller;
    this.rpcEndpoint = rpcEndpoint;
    this.accountPrivateKey = accountPrivateKey;
    this.numTransactionsLegacy = numTransactionsLegacy;
    this.numTransactionsEIP1559 = numTransactionsEIP1559;
    this.numSmartContracts = numSmartContracts;
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
      Logger.error(e, "error setting initial parameters (nonce, gasPrice)");
      this.initialGasPrice = BigInteger.ZERO;
      this.nonce = new AtomicLong(0);
    }
  }

  @Override
  public void run() {
    Logger.debug(
        "sending {} legacy transactions on node {} with account {}",
        numTransactionsLegacy,
        rpcEndpoint,
        credentials.getAddress());
    IntStream.range(0, numTransactionsLegacy).forEach(__ -> sendLegacyTransaction());
    Logger.debug(
        "sending {} eip-1559 transactions on node {} with account {}",
        numTransactionsEIP1559,
        rpcEndpoint,
        credentials.getAddress());
    IntStream.range(0, numTransactionsEIP1559).forEach(__ -> sendEIP1559Transaction());
    Logger.debug(
        "deploying {} contracts on node {} with account {}",
        numSmartContracts,
        rpcEndpoint,
        credentials.getAddress());
    IntStream.range(0, numSmartContracts).forEach(__ -> deploySmartContract());
  }

  private void sendLegacyTransaction() {
    try {
      final LegacyTransaction legacyTransaction =
          chainFiller
              .legacyTransactionCreator()
              .create(BigInteger.valueOf(nonce.getAndIncrement()), initialGasPrice);
      final byte[] signedMessage = TransactionSigner.sign(legacyTransaction, credentials);
      web3.ethSendRawTransaction(Numeric.toHexString(signedMessage)).send();
      chainFiller.reporter().incLegacyTransactions();
    } catch (final Exception e) {
      Logger.error(e, "error sending legacy transaction");
      chainFiller.reporter().incLegacyTransactionsError();
    }
  }

  private void sendEIP1559Transaction() {
    try {
      final EIP1559Transaction eip1559Transaction =
          chainFiller
              .eip1559TransactionCreator()
              .create(BigInteger.valueOf(nonce.getAndIncrement()));
      final byte[] signedMessage = TransactionSigner.sign(eip1559Transaction, credentials);
      web3.ethSendRawTransaction(Numeric.toHexString(signedMessage)).send();
      chainFiller.reporter().incEIP1559Transactions();
    } catch (final Exception e) {
      Logger.error(e, "error sending eip1559 transaction");
      chainFiller.reporter().incEIP1559TransactionsError();
    }
  }

  private void deploySmartContract() {
    try {
      final LegacyTransaction contractDeploymentTransaction =
          chainFiller
              .legacyTransactionCreator()
              .create(
                  BigInteger.valueOf(nonce.getAndIncrement()),
                  BigInteger.valueOf(2000001529),
                  chainFiller.contractRepository().random().code());
      final byte[] signedMessage =
          TransactionSigner.sign(contractDeploymentTransaction, credentials);
      web3.ethSendRawTransaction(Numeric.toHexString(signedMessage)).send();
      chainFiller.reporter().incTotalContractsDeployed();
    } catch (final Exception e) {
      Logger.error(e, "error deploying contract transaction");
      chainFiller.reporter().incTotalContractsDeploymentsError();
    }
  }
}
