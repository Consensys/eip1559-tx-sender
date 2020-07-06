package tech.pegasys.net.core;

import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import tech.pegasys.net.api.service.AccountRepository;
import tech.pegasys.net.api.service.ContractRepository;
import tech.pegasys.net.api.service.CredentialsRepository;
import tech.pegasys.net.api.service.EIP1559TransactionCreator;
import tech.pegasys.net.api.service.LegacyTransactionCreator;
import tech.pegasys.net.api.service.Reporter;
import tech.pegasys.net.config.ChainFillerConfiguration;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ChainFillerService_Factory implements Factory<ChainFillerService> {
  private final Provider<ChainFillerConfiguration> configurationProvider;

  private final Provider<CredentialsRepository> credentialsRepositoryProvider;

  private final Provider<AccountRepository> accountRepositoryProvider;

  private final Provider<ContractRepository> contractRepositoryProvider;

  private final Provider<LegacyTransactionCreator> legacyTransactionCreatorProvider;

  private final Provider<EIP1559TransactionCreator> eip1559TransactionCreatorProvider;

  private final Provider<Reporter> reporterProvider;

  public ChainFillerService_Factory(Provider<ChainFillerConfiguration> configurationProvider,
      Provider<CredentialsRepository> credentialsRepositoryProvider,
      Provider<AccountRepository> accountRepositoryProvider,
      Provider<ContractRepository> contractRepositoryProvider,
      Provider<LegacyTransactionCreator> legacyTransactionCreatorProvider,
      Provider<EIP1559TransactionCreator> eip1559TransactionCreatorProvider,
      Provider<Reporter> reporterProvider) {
    this.configurationProvider = configurationProvider;
    this.credentialsRepositoryProvider = credentialsRepositoryProvider;
    this.accountRepositoryProvider = accountRepositoryProvider;
    this.contractRepositoryProvider = contractRepositoryProvider;
    this.legacyTransactionCreatorProvider = legacyTransactionCreatorProvider;
    this.eip1559TransactionCreatorProvider = eip1559TransactionCreatorProvider;
    this.reporterProvider = reporterProvider;
  }

  @Override
  public ChainFillerService get() {
    return newInstance(configurationProvider.get(), credentialsRepositoryProvider.get(), accountRepositoryProvider.get(), contractRepositoryProvider.get(), legacyTransactionCreatorProvider.get(), eip1559TransactionCreatorProvider.get(), reporterProvider.get());
  }

  public static ChainFillerService_Factory create(
      Provider<ChainFillerConfiguration> configurationProvider,
      Provider<CredentialsRepository> credentialsRepositoryProvider,
      Provider<AccountRepository> accountRepositoryProvider,
      Provider<ContractRepository> contractRepositoryProvider,
      Provider<LegacyTransactionCreator> legacyTransactionCreatorProvider,
      Provider<EIP1559TransactionCreator> eip1559TransactionCreatorProvider,
      Provider<Reporter> reporterProvider) {
    return new ChainFillerService_Factory(configurationProvider, credentialsRepositoryProvider, accountRepositoryProvider, contractRepositoryProvider, legacyTransactionCreatorProvider, eip1559TransactionCreatorProvider, reporterProvider);
  }

  public static ChainFillerService newInstance(ChainFillerConfiguration configuration,
      CredentialsRepository credentialsRepository, AccountRepository accountRepository,
      ContractRepository contractRepository, LegacyTransactionCreator legacyTransactionCreator,
      EIP1559TransactionCreator eip1559TransactionCreator, Reporter reporter) {
    return new ChainFillerService(configuration, credentialsRepository, accountRepository, contractRepository, legacyTransactionCreator, eip1559TransactionCreator, reporter);
  }
}
