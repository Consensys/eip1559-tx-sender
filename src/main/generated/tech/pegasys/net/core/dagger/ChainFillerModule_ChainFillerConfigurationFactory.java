package tech.pegasys.net.core.dagger;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import tech.pegasys.net.config.ChainFillerConfiguration;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ChainFillerModule_ChainFillerConfigurationFactory implements Factory<ChainFillerConfiguration> {
  @Override
  public ChainFillerConfiguration get() {
    return chainFillerConfiguration();
  }

  public static ChainFillerModule_ChainFillerConfigurationFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ChainFillerConfiguration chainFillerConfiguration() {
    return Preconditions.checkNotNull(ChainFillerModule.chainFillerConfiguration(), "Cannot return null from a non-@Nullable @Provides method");
  }

  private static final class InstanceHolder {
    private static final ChainFillerModule_ChainFillerConfigurationFactory INSTANCE = new ChainFillerModule_ChainFillerConfigurationFactory();
  }
}
