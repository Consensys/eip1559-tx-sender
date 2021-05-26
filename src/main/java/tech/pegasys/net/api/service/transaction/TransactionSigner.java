package tech.pegasys.net.api.service.transaction;

import java.math.BigInteger;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.utils.Convert;
import tech.pegasys.net.api.model.EIP1559Transaction;
import tech.pegasys.net.api.model.LegacyTransaction;

public class TransactionSigner {
  private static final BigInteger DEFAULT_GAS_LIMIT = BigInteger.valueOf(21000);
  private static final BigInteger DEFAULT_CONTRACT_GAS_LIMIT = BigInteger.valueOf(8000000);

  public static byte[] sign(
      final LegacyTransaction legacyTransaction, final Credentials credentials) {
    final RawTransaction rawTransaction;
    if (legacyTransaction.bytecode().isPresent()) {
      rawTransaction =
          RawTransaction.createContractTransaction(
              legacyTransaction.nonce(),
              legacyTransaction.gasPrice(),
              DEFAULT_CONTRACT_GAS_LIMIT,
              Convert.toWei(legacyTransaction.value(), Convert.Unit.ETHER).toBigInteger(),
              legacyTransaction.bytecode().get());
    } else {
      rawTransaction =
          RawTransaction.createEtherTransaction(
              legacyTransaction.nonce(),
              legacyTransaction.gasPrice(),
              DEFAULT_GAS_LIMIT,
              legacyTransaction.recipientAddress(),
              Convert.toWei(legacyTransaction.value(), Convert.Unit.ETHER).toBigInteger());
    }
    return sign(rawTransaction, credentials);
  }

  public static byte[] sign(
      final EIP1559Transaction eip1559Transaction, final Credentials credentials) {
    return sign(
        RawTransaction.createEtherTransaction(
            eip1559Transaction.chainId(),
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
