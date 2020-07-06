package tech.pegasys.net.core.dagger;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import tech.pegasys.net.api.service.AccountRepository;
import tech.pegasys.net.config.ChainFillerConfiguration;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ChainFillerModule_AccountRepositoryFactory implements Factory<AccountRepository> {
  private final Provider<ChainFillerConfiguration> configurationProvider;

  public ChainFillerModule_AccountRepositoryFactory(
      Provider<ChainFillerConfiguration> configurationProvider) {
    this.configurationProvider = configurationProvider;
  }

  @Override
  public AccountRepository get() {
    return accountRepository(configurationProvider.get());
  }

  public static ChainFillerModule_AccountRepositoryFactory create(
      Provider<ChainFillerConfiguration> configurationProvider) {
    return new ChainFillerModule_AccountRepositoryFactory(configurationProvider);
  }

  public static AccountRepository accountRepository(ChainFillerConfiguration configuration) {
    return Preconditions.checkNotNull(ChainFillerModule.accountRepository(configuration), "Cannot return null from a non-@Nullable @Provides method");
  }
}
