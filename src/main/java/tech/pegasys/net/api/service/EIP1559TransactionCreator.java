package tech.pegasys.net.api.service;

import tech.pegasys.net.api.model.EIP1559Transaction;

import java.math.BigInteger;

public interface EIP1559TransactionCreator {

  EIP1559Transaction create(BigInteger nonce);
}
