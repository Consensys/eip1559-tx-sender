package tech.pegasys.net.api.service.transaction;

import java.math.BigInteger;

import tech.pegasys.net.api.model.LegacyTransaction;
import tech.pegasys.net.api.model.payload.TransactionPayload;

public interface LegacyTransactionCreator {

  LegacyTransaction create(TransactionPayload transactionPayload);

  LegacyTransaction create(BigInteger nonce, BigInteger gasPrice);

  LegacyTransaction create(BigInteger nonce, BigInteger gasPrice, String bytecode);
}
