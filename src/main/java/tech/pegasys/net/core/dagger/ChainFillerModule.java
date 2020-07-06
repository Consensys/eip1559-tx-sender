package tech.pegasys.net.core.dagger;

import dagger.Module;
import dagger.Provides;
import tech.pegasys.net.api.service.AccountRepository;
import tech.pegasys.net.api.service.ContractRepository;
import tech.pegasys.net.api.service.CredentialsRepository;
import tech.pegasys.net.api.service.EIP1559TransactionCreator;
import tech.pegasys.net.api.service.LegacyTransactionCreator;
import tech.pegasys.net.api.service.Reporter;
import tech.pegasys.net.api.service.TransactionFuzzer;
import tech.pegasys.net.cli.Options;
import tech.pegasys.net.config.ChainFillerConfiguration;
import tech.pegasys.net.core.account.AccountRepositoryFactory;
import tech.pegasys.net.core.contracts.ContractRepositoryFactory;
import tech.pegasys.net.core.credentials.CredentialsRepositoryFactory;
import tech.pegasys.net.core.report.ReporterService;
import tech.pegasys.net.core.tx.EIP1559TransactionCreatorService;
import tech.pegasys.net.core.tx.LegacyTransactionCreatorService;
import tech.pegasys.net.core.tx.TransactionFuzzerService;

import javax.inject.Singleton;
import java.nio.file.Paths;

@Module
public class ChainFillerModule {

  @Provides
  @Singleton
  public static ChainFillerConfiguration chainFillerConfiguration() {
    return Options.getInstance().toTxSenderConfiguration();
  }

  @Provides
  @Singleton
  public static CredentialsRepository credentialsRepository(
      final ChainFillerConfiguration configuration) {
    return CredentialsRepositoryFactory.inMemoryCredentialsRepository(
        configuration.accountPrivateKeys());
  }

  @Provides
  @Singleton
  public static AccountRepository accountRepository(final ChainFillerConfiguration configuration) {
    return AccountRepositoryFactory.inMemoryAccountRepository(configuration.recipientAddresses());
  }

  @Provides
  @Singleton
  public static ContractRepository contractRepository(
      final ChainFillerConfiguration configuration) {
    return ContractRepositoryFactory.inMemoryContractRepository(
        Paths.get(configuration.contractDir()));
  }

  @Provides
  @Singleton
  public static LegacyTransactionCreator legacyTransactionCreator(
      final ChainFillerConfiguration configuration,
      final AccountRepository accountRepository,
      final TransactionFuzzer transactionFuzzer) {
    return new LegacyTransactionCreatorService(configuration, accountRepository, transactionFuzzer);
  }

  @Provides
  @Singleton
  public static EIP1559TransactionCreator eip1559TransactionCreator(
      final ChainFillerConfiguration configuration,
      final AccountRepository accountRepository,
      final TransactionFuzzer transactionFuzzer) {
    return new EIP1559TransactionCreatorService(
        configuration, accountRepository, transactionFuzzer);
  }

  @Provides
  @Singleton
  public static Reporter reporter() {
    return new ReporterService();
  }

  @Provides
  @Singleton
  public static TransactionFuzzer transactionFuzzer() {
    return new TransactionFuzzerService();
  }
}
