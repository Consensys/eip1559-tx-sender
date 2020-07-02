package tech.pegasys.net.api;

import tech.pegasys.net.api.model.LegacyTransaction;

import java.math.BigInteger;

public interface LegacyTransactionCreator {

  LegacyTransaction create(BigInteger nonce, BigInteger gasPrice);

  LegacyTransaction create(BigInteger nonce, BigInteger gasPrice, String bytecode);
}
