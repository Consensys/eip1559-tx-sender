package tech.pegasys.net.api.service;

import tech.pegasys.net.api.model.Account;

import java.util.Optional;
import java.util.stream.Stream;

public interface AccountRepository {

  void put(String address, Account account);

  Optional<Account> get(String address);

  Account random();

  Stream<Account> all();
}
