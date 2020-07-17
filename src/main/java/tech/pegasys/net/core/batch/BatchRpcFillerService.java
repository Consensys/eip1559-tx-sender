package tech.pegasys.net.core.batch;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import org.tinylog.Logger;
import org.web3j.utils.Numeric;
import tech.pegasys.net.api.model.ActionableAccount;
import tech.pegasys.net.api.service.ChainFiller;
import tech.pegasys.net.api.service.rpc.RpcClient;
import tech.pegasys.net.api.service.transaction.TransactionSigner;
import tech.pegasys.net.client.RpcClientService;
import tech.pegasys.net.config.ChainFillerConfiguration;
import tech.pegasys.net.util.RandomUtils;
import tech.pegasys.net.util.TransactionTypeSelector;

public class BatchRpcFillerService {
  private final ChainFiller chainFiller;
  private final ChainFillerConfiguration configuration;
  private final List<ActionableAccount> accounts;
  private final AtomicBoolean started = new AtomicBoolean(false);
  private final TransactionQueue transactionQueue;
  private final TransactionTypeSelector transactionTypeSelector;
  private final ExecutorService executorService;
  private final List<RpcClient> rpcClients;

  public BatchRpcFillerService(
      final ChainFiller chainFiller,
      final ChainFillerConfiguration configuration,
      final List<ActionableAccount> accounts) {
    this.chainFiller = chainFiller;
    this.configuration = configuration;
    this.accounts = accounts;
    this.transactionQueue =
        new TransactionQueue(configuration.numTransactions(), this::processTransactions);
    this.transactionTypeSelector = new TransactionTypeSelector(configuration.eip1559TxWeight());
    this.executorService = Executors.newFixedThreadPool(configuration.numThreads());
    this.rpcClients =
        this.configuration.rpcEndpoints().stream()
            .map(RpcClientService::new)
            .collect(Collectors.toList());
  }

  public void start() {
    if (started.compareAndSet(false, true)) {
      doStart();
    } else {
      Logger.warn("attempt to start an already-started {}", getClass().getSimpleName());
    }
  }

  private void doStart() {
    Logger.info("starting {}", getClass().getSimpleName());
    while (started.get()) {
      generateTransaction();
    }
  }

  private void generateTransaction() {
    final ActionableAccount account = RandomUtils.pickRandom(accounts);
    final String transaction;
    switch (transactionTypeSelector.next()) {
      case EIP1559:
        transaction =
            Numeric.toHexString(
                TransactionSigner.sign(
                    chainFiller
                        .eip1559TransactionCreator()
                        .create(BigInteger.valueOf(account.getNonce().getAndIncrement())),
                    account.getCredentials()));
        break;
      case LEGACY:
      default:
        transaction =
            Numeric.toHexString(
                TransactionSigner.sign(
                    chainFiller
                        .legacyTransactionCreator()
                        .create(
                            BigInteger.valueOf(account.getNonce().getAndIncrement()),
                            account.getGasPrice()),
                    account.getCredentials()));
        break;
    }
    transactionQueue.add(transaction);
    executorService.submit(account::update);
  }

  private void processTransactions(final List<String> transactions) {
    try {
      Logger.debug("processing {} transactions", transactions.size());
      RandomUtils.pickRandom(rpcClients).ethBatchSendRawTransaction(transactions);
    } catch (final IOException e) {
      Logger.error(e, "error occurred while processing transactions");
    }
  }

  public void stop() {
    if (started.compareAndSet(true, false)) {
      doStop();
    } else {
      Logger.warn("attempt to stop an already-stopped {}", getClass().getSimpleName());
    }
  }

  private void doStop() {
    Logger.info("shutdown {}", getClass().getSimpleName());
  }
}
