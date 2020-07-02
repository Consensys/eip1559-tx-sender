package tech.pegasys.net.api;

import tech.pegasys.net.api.model.EIP1559Transaction;

public interface EIP1559TransactionCreator {

  EIP1559Transaction create();
}
