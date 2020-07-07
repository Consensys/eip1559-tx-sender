package tech.pegasys.net.core.dagger;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import tech.pegasys.net.api.repository.CredentialsRepository;
import tech.pegasys.net.config.ChainFillerConfiguration;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ChainFillerModule_CredentialsRepositoryFactory implements Factory<CredentialsRepository> {
  private final Provider<ChainFillerConfiguration> configurationProvider;

  public ChainFillerModule_CredentialsRepositoryFactory(
      Provider<ChainFillerConfiguration> configurationProvider) {
    this.configurationProvider = configurationProvider;
  }

  @Override
  public CredentialsRepository get() {
    return credentialsRepository(configurationProvider.get());
  }

  public static ChainFillerModule_CredentialsRepositoryFactory create(
      Provider<ChainFillerConfiguration> configurationProvider) {
    return new ChainFillerModule_CredentialsRepositoryFactory(configurationProvider);
  }

  public static CredentialsRepository credentialsRepository(
      ChainFillerConfiguration configuration) {
    return Preconditions.checkNotNull(ChainFillerModule.credentialsRepository(configuration), "Cannot return null from a non-@Nullable @Provides method");
  }
}
