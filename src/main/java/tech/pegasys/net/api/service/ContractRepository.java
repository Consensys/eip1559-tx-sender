package tech.pegasys.net.api.service;

import tech.pegasys.net.api.model.Contract;
import tech.pegasys.net.api.model.ImmutableContract;

import java.util.stream.Stream;

public interface ContractRepository {

  void add(Contract contract);

  default void add(String contractCode) {
    add(ImmutableContract.builder().code(contractCode).build());
  }

  Contract random();

  Stream<Contract> all();
}
