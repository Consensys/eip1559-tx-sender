package tech.pegasys.net.core.tx.tximport;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.tinylog.Logger;
import tech.pegasys.net.config.ChainFillerConfiguration;

public class TxImportService {

  private final ChainFillerConfiguration configuration;
  private final Path txSourcePath;

  public TxImportService(final ChainFillerConfiguration configuration) {
    this.configuration = configuration;
    this.txSourcePath = Paths.get(configuration.transactionExportFile());
  }

  public void start() {
    try {
      new BatchSendTransactionsFromFile(configuration, txSourcePath).send();
    } catch (final Exception e) {
      Logger.error(e, "error occurred while processing transactions");
    }
  }
}
