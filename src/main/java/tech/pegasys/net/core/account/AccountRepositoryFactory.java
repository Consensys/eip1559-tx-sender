package tech.pegasys.net.core.account;

import tech.pegasys.net.api.model.Account;
import tech.pegasys.net.api.model.ImmutableAccount;
import tech.pegasys.net.api.service.AccountRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class AccountRepositoryFactory {

  public static AccountRepository inMemoryAccountRepository(final List<String> accountAddresses) {
    final Map<String, Account> accounts =
        accountAddresses.stream()
            .collect(
                Collectors.toMap(
                    accountAddress -> accountAddress,
                    accountAddress -> ImmutableAccount.builder().address(accountAddress).build(),
                    (a, b) -> b,
                    ConcurrentHashMap::new));
    return ImmutableInMemoryAccountRepository.builder().accounts(accounts).build();
  }
}
