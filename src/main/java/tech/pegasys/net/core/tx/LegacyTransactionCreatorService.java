package tech.pegasys.net.core.tx;

import tech.pegasys.net.api.AccountRepository;
import tech.pegasys.net.api.LegacyTransactionCreator;
import tech.pegasys.net.api.TransactionFuzzer;
import tech.pegasys.net.api.model.Account;
import tech.pegasys.net.api.model.ImmutableLegacyTransaction;
import tech.pegasys.net.api.model.LegacyTransaction;
import tech.pegasys.net.config.ChainFillerConfiguration;

import java.math.BigInteger;
import java.util.Optional;

public class LegacyTransactionCreatorService implements LegacyTransactionCreator {
  private final ChainFillerConfiguration configuration;
  private final AccountRepository accountRepository;
  private final TransactionFuzzer transactionFuzzer;

  public LegacyTransactionCreatorService(
      final ChainFillerConfiguration configuration,
      final AccountRepository accountRepository,
      final TransactionFuzzer transactionFuzzer) {
    this.configuration = configuration;
    this.accountRepository = accountRepository;
    this.transactionFuzzer = transactionFuzzer;
  }

  @Override
  public LegacyTransaction create(final BigInteger nonce, final BigInteger gasPrice) {
    final Account recipient = accountRepository.random();
    return ImmutableLegacyTransaction.builder()
        .nonce(nonce)
        .gasPrice(gasPrice)
        .recipientAddress(recipient.address())
        .value(
            transactionFuzzer.value(
                configuration.fuzzTransferValueLowerBoundEth(),
                configuration.fuzzTransferValueUpperBoundEth()))
        .bytecode(Optional.empty())
        .build();
  }

  @Override
  public LegacyTransaction create(
      final BigInteger nonce, final BigInteger gasPrice, final String bytecode) {
    return ImmutableLegacyTransaction.builder()
        .nonce(nonce)
        .gasPrice(gasPrice)
        .recipientAddress("")
        .value(
            transactionFuzzer.value(
                configuration.fuzzTransferValueLowerBoundEth(),
                configuration.fuzzTransferValueUpperBoundEth()))
        .bytecode(Optional.ofNullable(bytecode))
        .build();
  }
}
