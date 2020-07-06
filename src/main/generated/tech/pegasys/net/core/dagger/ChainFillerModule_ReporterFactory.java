package tech.pegasys.net.core.dagger;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import tech.pegasys.net.api.service.Reporter;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ChainFillerModule_ReporterFactory implements Factory<Reporter> {
  @Override
  public Reporter get() {
    return reporter();
  }

  public static ChainFillerModule_ReporterFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Reporter reporter() {
    return Preconditions.checkNotNull(ChainFillerModule.reporter(), "Cannot return null from a non-@Nullable @Provides method");
  }

  private static final class InstanceHolder {
    private static final ChainFillerModule_ReporterFactory INSTANCE = new ChainFillerModule_ReporterFactory();
  }
}
