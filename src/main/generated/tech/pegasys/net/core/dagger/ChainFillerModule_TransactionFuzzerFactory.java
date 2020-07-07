package tech.pegasys.net.core.dagger;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import tech.pegasys.net.api.service.transaction.TransactionFuzzer;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ChainFillerModule_TransactionFuzzerFactory implements Factory<TransactionFuzzer> {
  @Override
  public TransactionFuzzer get() {
    return transactionFuzzer();
  }

  public static ChainFillerModule_TransactionFuzzerFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static TransactionFuzzer transactionFuzzer() {
    return Preconditions.checkNotNull(ChainFillerModule.transactionFuzzer(), "Cannot return null from a non-@Nullable @Provides method");
  }

  private static final class InstanceHolder {
    private static final ChainFillerModule_TransactionFuzzerFactory INSTANCE = new ChainFillerModule_TransactionFuzzerFactory();
  }
}
