package tech.pegasys.net.api.service;

import tech.pegasys.net.api.model.EIP1559Transaction;
import tech.pegasys.net.api.model.payload.TransactionPayload;

import java.math.BigInteger;

public interface EIP1559TransactionCreator {

  EIP1559Transaction create(TransactionPayload transactionPayload);

  EIP1559Transaction create(BigInteger nonce, BigInteger gasPremium, BigInteger feeCap);

  default EIP1559Transaction create(BigInteger nonce) {
    return create(nonce, BigInteger.valueOf(2000001529), BigInteger.valueOf(999999999));
  }
}
