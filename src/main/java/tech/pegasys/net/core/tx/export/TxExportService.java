package tech.pegasys.net.core.tx.export;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.tinylog.Logger;
import org.web3j.utils.Numeric;
import tech.pegasys.net.api.model.ActionableAccount;
import tech.pegasys.net.api.model.EIP1559Transaction;
import tech.pegasys.net.api.model.LegacyTransaction;
import tech.pegasys.net.api.service.ChainFiller;
import tech.pegasys.net.api.service.transaction.TransactionSigner;
import tech.pegasys.net.config.ChainFillerConfiguration;

public class TxExportService {

  private final ChainFiller chainFiller;
  private final ChainFillerConfiguration configuration;
  private final List<ActionableAccount> accounts;
  private final Path outputPath;

  public TxExportService(
      final ChainFiller chainFiller,
      final ChainFillerConfiguration configuration,
      final List<ActionableAccount> accounts) {
    this.chainFiller = chainFiller;
    this.configuration = configuration;
    this.accounts = accounts;
    this.outputPath = Paths.get(configuration.transactionExportFile());
    try {
      Files.createFile(outputPath);
    } catch (final FileAlreadyExistsException e) {
      Logger.warn("export file exists and will be deleted");
      try {
        Files.delete(outputPath);
        Files.createFile(outputPath);
      } catch (final IOException ioe) {
        Logger.error(e, "cannot create export file");
        throw new RuntimeException(e);
      }
    } catch (final IOException e) {
      Logger.error(e, "cannot create export file");
      throw new RuntimeException(e);
    }
  }

  public void start() {
    try {
      final ExecutorService executorService =
          Executors.newFixedThreadPool(configuration.numThreads());
      final int eip1559Txs =
          (int) Math.ceil(configuration.numTransactions() * configuration.eip1559TxWeight());
      final int legacyTxs = configuration.numTransactions() - eip1559Txs;
      accounts.forEach(
          actionableAccount -> {
            executorService.submit(
                () ->
                    IntStream.range(0, legacyTxs)
                        .forEach(
                            __ -> {
                              appendTx(generateLegacyTransaction(chainFiller, actionableAccount));
                              chainFiller.reporter().incLegacyTransactions();
                            }));
            executorService.submit(
                () ->
                    IntStream.range(0, eip1559Txs)
                        .forEach(
                            __ -> {
                              appendTx(generateEIP1559Transaction(chainFiller, actionableAccount));
                              chainFiller.reporter().incEIP1559Transactions();
                            }));
          });

      executorService.shutdown();
      executorService.awaitTermination(1, TimeUnit.DAYS);
      Logger.debug("completed export: {}", chainFiller.reporter().report());
    } catch (final Exception e) {
      Logger.error(e, "error occurred while processing transactions");
    }
  }

  private void appendTx(final byte[] tx) {
    if (tx == null) {
      return;
    }
    try {
      Files.write(
          outputPath,
          Numeric.toHexString(tx).concat(System.lineSeparator()).getBytes(StandardCharsets.UTF_8),
          StandardOpenOption.APPEND);
    } catch (final IOException e) {
      Logger.error(e, "cannot append transaction to export file");
    }
  }

  private static byte[] generateLegacyTransaction(
      final ChainFiller chainFiller, final ActionableAccount account) {
    try {
      // Logger.debug("generating legacy transaction");
      final LegacyTransaction legacyTransaction =
          chainFiller
              .legacyTransactionCreator()
              .create(
                  BigInteger.valueOf(account.getNonce().getAndIncrement()), account.getGasPrice());
      return TransactionSigner.sign(legacyTransaction, account.getCredentials());
    } catch (final Exception e) {
      Logger.error(e, "error sending legacy transaction");
      chainFiller.reporter().incLegacyTransactionsError();
      return null;
    }
  }

  private static byte[] generateEIP1559Transaction(
      final ChainFiller chainFiller, final ActionableAccount account) {
    try {
      // Logger.debug("generating eip1559 transaction");

      final EIP1559Transaction eip1559Transaction =
          chainFiller
              .eip1559TransactionCreator()
              .create(BigInteger.valueOf(account.getNonce().getAndIncrement()));
      return TransactionSigner.sign(eip1559Transaction, account.getCredentials());
    } catch (final Exception e) {
      Logger.error(e, "error sending eip1559 transaction");
      chainFiller.reporter().incEIP1559TransactionsError();
      return null;
    }
  }
}
