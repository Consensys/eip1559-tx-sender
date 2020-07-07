package tech.pegasys.net.core.account;

import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import org.immutables.value.Value;
import tech.pegasys.net.api.model.Account;
import tech.pegasys.net.api.repository.AccountRepository;

@Value.Immutable
public abstract class InMemoryAccountRepository implements AccountRepository {

  public abstract Map<String, Account> accounts();

  @Override
  public void put(final String address, final Account account) {
    accounts().put(address, account);
  }

  @Override
  public Optional<Account> get(final String address) {
    return Optional.ofNullable(accounts().get(address));
  }

  @Override
  public Account random() {
    final int index = ThreadLocalRandom.current().nextInt(accounts().size());
    final Iterator<Account> accountIterator = accounts().values().iterator();
    for (int i = 0; i < index; i++) {
      accountIterator.next();
    }
    return accountIterator.next();
  }

  @Override
  public Stream<Account> all() {
    return accounts().values().stream();
  }
}
