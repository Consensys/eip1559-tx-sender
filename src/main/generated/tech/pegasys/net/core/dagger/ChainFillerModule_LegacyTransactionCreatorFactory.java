package tech.pegasys.net.core.dagger;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import tech.pegasys.net.api.service.AccountRepository;
import tech.pegasys.net.api.service.LegacyTransactionCreator;
import tech.pegasys.net.api.service.TransactionFuzzer;
import tech.pegasys.net.config.ChainFillerConfiguration;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ChainFillerModule_LegacyTransactionCreatorFactory implements Factory<LegacyTransactionCreator> {
  private final Provider<ChainFillerConfiguration> configurationProvider;

  private final Provider<AccountRepository> accountRepositoryProvider;

  private final Provider<TransactionFuzzer> transactionFuzzerProvider;

  public ChainFillerModule_LegacyTransactionCreatorFactory(
      Provider<ChainFillerConfiguration> configurationProvider,
      Provider<AccountRepository> accountRepositoryProvider,
      Provider<TransactionFuzzer> transactionFuzzerProvider) {
    this.configurationProvider = configurationProvider;
    this.accountRepositoryProvider = accountRepositoryProvider;
    this.transactionFuzzerProvider = transactionFuzzerProvider;
  }

  @Override
  public LegacyTransactionCreator get() {
    return legacyTransactionCreator(configurationProvider.get(), accountRepositoryProvider.get(), transactionFuzzerProvider.get());
  }

  public static ChainFillerModule_LegacyTransactionCreatorFactory create(
      Provider<ChainFillerConfiguration> configurationProvider,
      Provider<AccountRepository> accountRepositoryProvider,
      Provider<TransactionFuzzer> transactionFuzzerProvider) {
    return new ChainFillerModule_LegacyTransactionCreatorFactory(configurationProvider, accountRepositoryProvider, transactionFuzzerProvider);
  }

  public static LegacyTransactionCreator legacyTransactionCreator(
      ChainFillerConfiguration configuration, AccountRepository accountRepository,
      TransactionFuzzer transactionFuzzer) {
    return Preconditions.checkNotNull(ChainFillerModule.legacyTransactionCreator(configuration, accountRepository, transactionFuzzer), "Cannot return null from a non-@Nullable @Provides method");
  }
}
