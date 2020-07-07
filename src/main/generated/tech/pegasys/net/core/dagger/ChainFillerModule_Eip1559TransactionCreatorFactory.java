package tech.pegasys.net.core.dagger;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import tech.pegasys.net.api.repository.AccountRepository;
import tech.pegasys.net.api.service.transaction.EIP1559TransactionCreator;
import tech.pegasys.net.api.service.transaction.TransactionFuzzer;
import tech.pegasys.net.config.ChainFillerConfiguration;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ChainFillerModule_Eip1559TransactionCreatorFactory implements Factory<EIP1559TransactionCreator> {
  private final Provider<ChainFillerConfiguration> configurationProvider;

  private final Provider<AccountRepository> accountRepositoryProvider;

  private final Provider<TransactionFuzzer> transactionFuzzerProvider;

  public ChainFillerModule_Eip1559TransactionCreatorFactory(
      Provider<ChainFillerConfiguration> configurationProvider,
      Provider<AccountRepository> accountRepositoryProvider,
      Provider<TransactionFuzzer> transactionFuzzerProvider) {
    this.configurationProvider = configurationProvider;
    this.accountRepositoryProvider = accountRepositoryProvider;
    this.transactionFuzzerProvider = transactionFuzzerProvider;
  }

  @Override
  public EIP1559TransactionCreator get() {
    return eip1559TransactionCreator(configurationProvider.get(), accountRepositoryProvider.get(), transactionFuzzerProvider.get());
  }

  public static ChainFillerModule_Eip1559TransactionCreatorFactory create(
      Provider<ChainFillerConfiguration> configurationProvider,
      Provider<AccountRepository> accountRepositoryProvider,
      Provider<TransactionFuzzer> transactionFuzzerProvider) {
    return new ChainFillerModule_Eip1559TransactionCreatorFactory(configurationProvider, accountRepositoryProvider, transactionFuzzerProvider);
  }

  public static EIP1559TransactionCreator eip1559TransactionCreator(
      ChainFillerConfiguration configuration, AccountRepository accountRepository,
      TransactionFuzzer transactionFuzzer) {
    return Preconditions.checkNotNull(ChainFillerModule.eip1559TransactionCreator(configuration, accountRepository, transactionFuzzer), "Cannot return null from a non-@Nullable @Provides method");
  }
}
