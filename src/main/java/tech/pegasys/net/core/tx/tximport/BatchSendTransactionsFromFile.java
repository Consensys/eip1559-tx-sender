package tech.pegasys.net.core.tx.tximport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.tinylog.Logger;
import tech.pegasys.net.api.service.rpc.RpcClient;
import tech.pegasys.net.client.RpcClientService;
import tech.pegasys.net.config.ChainFillerConfiguration;
import tech.pegasys.net.core.batch.TransactionQueue;
import tech.pegasys.net.util.RandomUtils;

public class BatchSendTransactionsFromFile {
  private static final int TX_PER_CALL = 100;
  private final ChainFillerConfiguration configuration;
  private final TransactionQueue transactionQueue;
  private final List<RpcClient> rpcClients;
  private final Path txSourcePath;

  public BatchSendTransactionsFromFile(
      final ChainFillerConfiguration configuration, final Path txSourcePath) {
    this.configuration = configuration;
    this.transactionQueue = new TransactionQueue(TX_PER_CALL, this::processTransactions);
    this.rpcClients =
        this.configuration.rpcEndpoints().stream()
            .map(RpcClientService::new)
            .collect(Collectors.toList());
    this.txSourcePath = txSourcePath;
  }

  public void send() {
    try (Stream<String> stream = Files.lines(txSourcePath)) {
      stream.forEach(transactionQueue::add);
    } catch (IOException e) {
      Logger.error(e, "cannot send batch transactionbs");
    }
  }

  private void processTransactions(final List<String> transactions) {
    try {
      Logger.debug("processing {} transactions", transactions.size());
      RandomUtils.pickRandom(rpcClients).ethBatchSendRawTransaction(transactions);
    } catch (final IOException e) {
      Logger.error(e, "error occurred while processing transactions");
    }
  }
}
