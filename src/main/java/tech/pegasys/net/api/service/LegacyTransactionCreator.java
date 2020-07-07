package tech.pegasys.net.api.service;

import tech.pegasys.net.api.model.LegacyTransaction;
import tech.pegasys.net.api.model.payload.TransactionPayload;

import java.math.BigInteger;

public interface LegacyTransactionCreator {

  LegacyTransaction create(TransactionPayload transactionPayload);

  LegacyTransaction create(BigInteger nonce, BigInteger gasPrice);

  LegacyTransaction create(BigInteger nonce, BigInteger gasPrice, String bytecode);
}
