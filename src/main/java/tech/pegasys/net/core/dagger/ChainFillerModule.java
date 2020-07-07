package tech.pegasys.net.core.dagger;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import tech.pegasys.net.api.repository.AccountRepository;
import tech.pegasys.net.api.repository.ContractRepository;
import tech.pegasys.net.api.repository.CredentialsRepository;
import tech.pegasys.net.api.service.metrics.Reporter;
import tech.pegasys.net.api.service.transaction.EIP1559TransactionCreator;
import tech.pegasys.net.api.service.transaction.LegacyTransactionCreator;
import tech.pegasys.net.api.service.transaction.TransactionFuzzer;
import tech.pegasys.net.cli.Options;
import tech.pegasys.net.config.ChainFillerConfiguration;
import tech.pegasys.net.core.account.AccountRepositoryFactory;
import tech.pegasys.net.core.contracts.ContractRepositoryFactory;
import tech.pegasys.net.core.credentials.CredentialsRepositoryFactory;
import tech.pegasys.net.core.report.ReporterService;
import tech.pegasys.net.core.tx.EIP1559TransactionCreatorService;
import tech.pegasys.net.core.tx.LegacyTransactionCreatorService;
import tech.pegasys.net.core.tx.TransactionFuzzerService;

@Module
public class ChainFillerModule {

  @Provides
  @Singleton
  public static ChainFillerConfiguration chainFillerConfiguration() {
    return Options.getInstance().toChainFillerConfiguration();
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
    final Optional<Path> contractsPath;
    if (configuration.contractDir() == null
        || configuration.contractDir().isEmpty()
        || configuration.contractDir().isBlank()) {
      contractsPath = Optional.empty();
    } else {
      contractsPath = Optional.of(Paths.get(configuration.contractDir()));
    }
    return ContractRepositoryFactory.inMemoryContractRepository(contractsPath);
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
