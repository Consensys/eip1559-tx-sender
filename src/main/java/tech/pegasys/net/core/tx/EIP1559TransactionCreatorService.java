package tech.pegasys.net.core.tx;

import tech.pegasys.net.api.AccountRepository;
import tech.pegasys.net.api.EIP1559TransactionCreator;
import tech.pegasys.net.api.TransactionFuzzer;
import tech.pegasys.net.api.model.Account;
import tech.pegasys.net.api.model.EIP1559Transaction;
import tech.pegasys.net.api.model.ImmutableEIP1559Transaction;
import tech.pegasys.net.config.ChainFillerConfiguration;

import java.math.BigInteger;

public class EIP1559TransactionCreatorService implements EIP1559TransactionCreator {
  private final ChainFillerConfiguration configuration;
  private final AccountRepository accountRepository;
  private final TransactionFuzzer transactionFuzzer;

  public EIP1559TransactionCreatorService(
      final ChainFillerConfiguration configuration,
      final AccountRepository accountRepository,
      final TransactionFuzzer transactionFuzzer) {
    this.configuration = configuration;
    this.accountRepository = accountRepository;
    this.transactionFuzzer = transactionFuzzer;
  }

  @Override
  public EIP1559Transaction create(final BigInteger nonce) {
    final Account recipient = accountRepository.random();
    return ImmutableEIP1559Transaction.builder()
        .nonce(nonce)
        .recipientAddress(recipient.address())
        .value(
            transactionFuzzer.value(
                configuration.fuzzTransferValueLowerBoundEth(),
                configuration.fuzzTransferValueUpperBoundEth()))
        .gasPremium(BigInteger.valueOf(2000001529))
        .feeCap(BigInteger.valueOf(999999999))
        .build();
  }
}
