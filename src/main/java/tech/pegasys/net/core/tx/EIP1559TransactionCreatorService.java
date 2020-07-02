package tech.pegasys.net.core.tx;

import tech.pegasys.net.api.AccountRepository;
import tech.pegasys.net.api.EIP1559TransactionCreator;
import tech.pegasys.net.api.model.Account;
import tech.pegasys.net.api.model.EIP1559Transaction;
import tech.pegasys.net.api.model.ImmutableEIP1559Transaction;

import java.math.BigDecimal;
import java.math.BigInteger;

public class EIP1559TransactionCreatorService implements EIP1559TransactionCreator {
  private final AccountRepository accountRepository;

  public EIP1559TransactionCreatorService(final AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  public EIP1559Transaction create() {
    final Account recipient = accountRepository.random();
    return ImmutableEIP1559Transaction.builder()
        .recipientAddress(recipient.address())
        .value(BigDecimal.valueOf(123))
        .gasPremium(BigInteger.valueOf(5678))
        .feeCap(BigInteger.valueOf(999999999))
        .build();
  }
}
