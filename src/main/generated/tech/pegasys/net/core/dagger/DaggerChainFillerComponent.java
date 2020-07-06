package tech.pegasys.net.core.dagger;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import tech.pegasys.net.api.service.AccountRepository;
import tech.pegasys.net.api.service.ContractRepository;
import tech.pegasys.net.api.service.CredentialsRepository;
import tech.pegasys.net.api.service.EIP1559TransactionCreator;
import tech.pegasys.net.api.service.LegacyTransactionCreator;
import tech.pegasys.net.api.service.Reporter;
import tech.pegasys.net.api.service.TransactionFuzzer;
import tech.pegasys.net.config.ChainFillerConfiguration;
import tech.pegasys.net.core.ChainFillerService;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerChainFillerComponent implements ChainFillerComponent {
  private Provider<ChainFillerConfiguration> chainFillerConfigurationProvider;

  private Provider<CredentialsRepository> credentialsRepositoryProvider;

  private Provider<AccountRepository> accountRepositoryProvider;

  private Provider<ContractRepository> contractRepositoryProvider;

  private Provider<TransactionFuzzer> transactionFuzzerProvider;

  private Provider<LegacyTransactionCreator> legacyTransactionCreatorProvider;

  private Provider<EIP1559TransactionCreator> eip1559TransactionCreatorProvider;

  private Provider<Reporter> reporterProvider;

  private DaggerChainFillerComponent() {

    initialize();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static ChainFillerComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize() {
    this.chainFillerConfigurationProvider = DoubleCheck.provider(ChainFillerModule_ChainFillerConfigurationFactory.create());
    this.credentialsRepositoryProvider = DoubleCheck.provider(ChainFillerModule_CredentialsRepositoryFactory.create(chainFillerConfigurationProvider));
    this.accountRepositoryProvider = DoubleCheck.provider(ChainFillerModule_AccountRepositoryFactory.create(chainFillerConfigurationProvider));
    this.contractRepositoryProvider = DoubleCheck.provider(ChainFillerModule_ContractRepositoryFactory.create(chainFillerConfigurationProvider));
    this.transactionFuzzerProvider = DoubleCheck.provider(ChainFillerModule_TransactionFuzzerFactory.create());
    this.legacyTransactionCreatorProvider = DoubleCheck.provider(ChainFillerModule_LegacyTransactionCreatorFactory.create(chainFillerConfigurationProvider, accountRepositoryProvider, transactionFuzzerProvider));
    this.eip1559TransactionCreatorProvider = DoubleCheck.provider(ChainFillerModule_Eip1559TransactionCreatorFactory.create(chainFillerConfigurationProvider, accountRepositoryProvider, transactionFuzzerProvider));
    this.reporterProvider = DoubleCheck.provider(ChainFillerModule_ReporterFactory.create());
  }

  @Override
  public ChainFillerService chainFiller() {
    return new ChainFillerService(chainFillerConfigurationProvider.get(), credentialsRepositoryProvider.get(), accountRepositoryProvider.get(), contractRepositoryProvider.get(), legacyTransactionCreatorProvider.get(), eip1559TransactionCreatorProvider.get(), reporterProvider.get());}

  public static final class Builder {
    private Builder() {
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder chainFillerModule(ChainFillerModule chainFillerModule) {
      Preconditions.checkNotNull(chainFillerModule);
      return this;
    }

    public ChainFillerComponent build() {
      return new DaggerChainFillerComponent();
    }
  }
}
