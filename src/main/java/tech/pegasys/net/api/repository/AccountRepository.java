package tech.pegasys.net.api.repository;

import java.util.Optional;
import java.util.stream.Stream;

import tech.pegasys.net.api.model.Account;

public interface AccountRepository {

  void put(String address, Account account);

  Optional<Account> get(String address);

  Account random();

  Stream<Account> all();
}
