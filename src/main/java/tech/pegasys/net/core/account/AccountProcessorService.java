package tech.pegasys.net.core.account;

import java.math.BigInteger;
import java.util.stream.IntStream;

import org.tinylog.Logger;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.utils.Numeric;
import tech.pegasys.net.api.model.ActionableAccount;
import tech.pegasys.net.api.model.EIP1559Transaction;
import tech.pegasys.net.api.model.LegacyTransaction;
import tech.pegasys.net.api.service.ChainFiller;
import tech.pegasys.net.api.service.transaction.TransactionSigner;

public class AccountProcessorService {

  public static void process(
      final ChainFiller chainFiller,
      final ActionableAccount actionableAccount,
      final int legacyTx,
      final int eip1559Tx,
      final int smartContracts) {
    // Logger.debug("start processing account: {}", actionableAccount.updated().toString());
    IntStream.range(0, legacyTx)
        .forEach(__ -> sendLegacyTransaction(chainFiller, actionableAccount));
    IntStream.range(0, eip1559Tx)
        .forEach(__ -> sendEIP1559Transaction(chainFiller, actionableAccount));
    IntStream.range(0, smartContracts)
        .forEach(__ -> deploySmartContract(chainFiller, actionableAccount));
    // Logger.debug("completed processing account: {}", actionableAccount.updated().toString());
  }

  private static void sendLegacyTransaction(
      final ChainFiller chainFiller, final ActionableAccount account) {
    try {
      Logger.debug("sending legacy transaction");
      final LegacyTransaction legacyTransaction =
          chainFiller
              .legacyTransactionCreator()
              .create(
                  BigInteger.valueOf(account.getNonce().getAndIncrement()), account.getGasPrice());
      final byte[] signedMessage =
          TransactionSigner.sign(legacyTransaction, account.getCredentials());
      final EthSendTransaction ethSendTransactionResponse =
          account.getWeb3().ethSendRawTransaction(Numeric.toHexString(signedMessage)).send();
      Logger.debug("transaction sent: {}", ethSendTransactionResponse.getTransactionHash());
      chainFiller.reporter().incLegacyTransactions();
    } catch (final Exception e) {
      Logger.error(e, "error sending legacy transaction");
      chainFiller.reporter().incLegacyTransactionsError();
    }
  }

  private static void sendEIP1559Transaction(
      final ChainFiller chainFiller, final ActionableAccount account) {
    try {
      Logger.debug("sending eip1559 transaction");

      final EIP1559Transaction eip1559Transaction =
          chainFiller
              .eip1559TransactionCreator()
              .create(BigInteger.valueOf(account.getNonce().getAndIncrement()));
      final byte[] signedMessage =
          TransactionSigner.sign(eip1559Transaction, account.getCredentials());
      final EthSendTransaction ethSendTransactionResponse =
          account.getWeb3().ethSendRawTransaction(Numeric.toHexString(signedMessage)).send();
      Logger.debug("transaction sent: {}", ethSendTransactionResponse.getTransactionHash());

      chainFiller.reporter().incEIP1559Transactions();
    } catch (final Exception e) {
      Logger.error(e, "error sending eip1559 transaction");
      chainFiller.reporter().incEIP1559TransactionsError();
    }
  }

  private static void deploySmartContract(
      final ChainFiller chainFiller, final ActionableAccount account) {
    try {
      final LegacyTransaction contractDeploymentTransaction =
          chainFiller
              .legacyTransactionCreator()
              .create(
                  BigInteger.valueOf(account.getNonce().getAndIncrement()),
                  BigInteger.valueOf(2000001529),
                  chainFiller.contractRepository().random().code());
      final byte[] signedMessage =
          TransactionSigner.sign(contractDeploymentTransaction, account.getCredentials());
      account.getWeb3().ethSendRawTransaction(Numeric.toHexString(signedMessage)).send();
      chainFiller.reporter().incTotalContractsDeployed();
    } catch (final Exception e) {
      Logger.error(e, "error deploying contract transaction");
      chainFiller.reporter().incTotalContractsDeploymentsError();
    }
  }
}
