package tech.pegasys.net.api;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.utils.Convert;
import tech.pegasys.net.api.model.EIP1559Transaction;
import tech.pegasys.net.api.model.LegacyTransaction;

import java.math.BigInteger;

public class TransactionSigner {
  private static final BigInteger DEFAULT_GAS_LIMIT = BigInteger.valueOf(30000);

  public static byte[] sign(
      final LegacyTransaction legacyTransaction, final Credentials credentials) {
    return sign(
        RawTransaction.createEtherTransaction(
            legacyTransaction.nonce(),
            legacyTransaction.gasPrice(),
            DEFAULT_GAS_LIMIT,
            legacyTransaction.recipientAddress(),
            Convert.toWei(legacyTransaction.value(), Convert.Unit.ETHER).toBigInteger()),
        credentials);
  }

  public static byte[] sign(
      final EIP1559Transaction eip1559Transaction, final Credentials credentials) {
    return sign(
        RawTransaction.createEtherTransaction(
            eip1559Transaction.nonce(),
            DEFAULT_GAS_LIMIT,
            eip1559Transaction.recipientAddress(),
            Convert.toWei(eip1559Transaction.value(), Convert.Unit.ETHER).toBigInteger(),
            eip1559Transaction.gasPremium(),
            eip1559Transaction.feeCap()),
        credentials);
  }

  public static byte[] sign(final RawTransaction rawTransaction, final Credentials credentials) {
    return TransactionEncoder.signMessage(rawTransaction, credentials);
  }
}
