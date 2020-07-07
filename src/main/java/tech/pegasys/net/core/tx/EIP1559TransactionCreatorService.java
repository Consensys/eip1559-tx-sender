package tech.pegasys.net.core.tx;

import java.math.BigDecimal;
import java.math.BigInteger;

import tech.pegasys.net.api.model.Account;
import tech.pegasys.net.api.model.EIP1559Transaction;
import tech.pegasys.net.api.model.ImmutableEIP1559Transaction;
import tech.pegasys.net.api.model.payload.TransactionPayload;
import tech.pegasys.net.api.repository.AccountRepository;
import tech.pegasys.net.api.service.transaction.EIP1559TransactionCreator;
import tech.pegasys.net.api.service.transaction.TransactionFuzzer;
import tech.pegasys.net.config.ChainFillerConfiguration;

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
  public EIP1559Transaction create(final TransactionPayload transactionPayload) {
    final Account recipient = accountRepository.random();
    return ImmutableEIP1559Transaction.builder()
        .nonce(BigInteger.valueOf(transactionPayload.getNonce()))
        .recipientAddress(recipient.address())
        .value(new BigDecimal(transactionPayload.getValue()))
        .gasPremium(transactionPayload.getGasPremium())
        .feeCap(transactionPayload.getFeeCap())
        .build();
  }

  @Override
  public EIP1559Transaction create(
      final BigInteger nonce, final BigInteger gasPremium, final BigInteger feeCap) {
    final Account recipient = accountRepository.random();
    return ImmutableEIP1559Transaction.builder()
        .nonce(nonce)
        .recipientAddress(recipient.address())
        .value(
            transactionFuzzer.value(
                configuration.fuzzTransferValueLowerBoundEth(),
                configuration.fuzzTransferValueUpperBoundEth()))
        .gasPremium(gasPremium)
        .feeCap(feeCap)
        .build();
  }
}
