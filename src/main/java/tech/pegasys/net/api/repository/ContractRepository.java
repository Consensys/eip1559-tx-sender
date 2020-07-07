package tech.pegasys.net.api.repository;

import java.util.stream.Stream;

import tech.pegasys.net.api.model.Contract;
import tech.pegasys.net.api.model.ImmutableContract;

public interface ContractRepository {

  void add(Contract contract);

  default void add(String contractCode) {
    add(ImmutableContract.builder().code(contractCode).build());
  }

  Contract random();

  Stream<Contract> all();
}
