package tech.pegasys.net.core.dagger;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import tech.pegasys.net.api.repository.ContractRepository;
import tech.pegasys.net.config.ChainFillerConfiguration;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ChainFillerModule_ContractRepositoryFactory implements Factory<ContractRepository> {
  private final Provider<ChainFillerConfiguration> configurationProvider;

  public ChainFillerModule_ContractRepositoryFactory(
      Provider<ChainFillerConfiguration> configurationProvider) {
    this.configurationProvider = configurationProvider;
  }

  @Override
  public ContractRepository get() {
    return contractRepository(configurationProvider.get());
  }

  public static ChainFillerModule_ContractRepositoryFactory create(
      Provider<ChainFillerConfiguration> configurationProvider) {
    return new ChainFillerModule_ContractRepositoryFactory(configurationProvider);
  }

  public static ContractRepository contractRepository(ChainFillerConfiguration configuration) {
    return Preconditions.checkNotNull(ChainFillerModule.contractRepository(configuration), "Cannot return null from a non-@Nullable @Provides method");
  }
}
