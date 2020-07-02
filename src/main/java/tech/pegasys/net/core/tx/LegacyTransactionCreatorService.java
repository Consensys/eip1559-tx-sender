package tech.pegasys.net.core.tx;

import tech.pegasys.net.api.AccountRepository;
import tech.pegasys.net.api.LegacyTransactionCreator;
import tech.pegasys.net.api.model.Account;
import tech.pegasys.net.api.model.ImmutableLegacyTransaction;
import tech.pegasys.net.api.model.LegacyTransaction;

import java.math.BigDecimal;

public class LegacyTransactionCreatorService implements LegacyTransactionCreator {
  private final AccountRepository accountRepository;

  public LegacyTransactionCreatorService(final AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  public LegacyTransaction create() {
    final Account recipient = accountRepository.random();
    return ImmutableLegacyTransaction.builder()
            .recipientAddress(recipient.address())
            .value(BigDecimal.valueOf(123))
            .build();
  }
}
