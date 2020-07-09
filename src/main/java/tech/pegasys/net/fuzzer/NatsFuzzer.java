package tech.pegasys.net.fuzzer;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import io.nats.client.Connection;
import io.nats.client.ConnectionListener;
import io.nats.client.Dispatcher;
import io.nats.client.Message;
import io.nats.client.Nats;
import io.nats.client.Options;
import org.tinylog.Logger;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Numeric;
import tech.pegasys.net.api.model.payload.TransactionPayload;
import tech.pegasys.net.api.service.ChainFiller;
import tech.pegasys.net.api.service.transaction.TransactionSigner;
import tech.pegasys.net.config.ChainFillerConfiguration;
import tech.pegasys.net.util.RandomUtils;

public class NatsFuzzer {
  private final ChainFiller chainFiller;
  private final ChainFillerConfiguration configuration;;
  private final ExecutorService executor;
  private final List<Credentials> credentialsStore;
  private final List<Web3j> web3s;
  private Connection nc;
  private boolean done = false;

  public NatsFuzzer(final ChainFiller chainFiller, final ChainFillerConfiguration configuration) {
    this.chainFiller = chainFiller;
    this.configuration = configuration;
    try {
      executor = Executors.newFixedThreadPool(configuration.numThreads());
      this.credentialsStore =
          chainFiller.credentialsRepository().all().collect(Collectors.toUnmodifiableList());
      this.web3s =
          configuration.rpcEndpoints().stream()
              .map(HttpService::new)
              .map(Web3j::build)
              .collect(Collectors.toUnmodifiableList());
      if (configuration.natsAsyncConnection()) {
        Nats.connectAsynchronously(
            new Options.Builder()
                .server(configuration.natsURL())
                .connectionListener(this::handleConnection)
                .build(),
            true);
      } else {
        nc = Nats.connect(configuration.natsURL());
        onConnected();
      }
    } catch (final Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {
    try {
      /*final Connection nc = Nats.connect("nats://3.22.223.170:4222");
      final String message = "{\"nonce\":1,\"value\":10,\"gasPrice\":21000}";
      nc.publish("fuzz.transactions", message.getBytes(StandardCharsets.UTF_8));*/
      List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
      List<List<Integer>> subSets = Lists.partition(intList, 5);

      List<Integer> lastPartition = subSets.get(2);

    } catch (final Exception e) {
      System.err.println(e.getMessage());
    }
  }

  public void handleConnection(final Connection nc, final ConnectionListener.Events type) {
    switch (type) {
      case CLOSED:
        Logger.error("cannot connect to nats: closed");
        break;
      case DISCONNECTED:
        Logger.error("cannot connect to nats: disconnected");
        break;
      case CONNECTED:
        onConnected();
        break;
    }
  }

  private void onConnected() {
    Logger.debug("connected to nats.");
    final Dispatcher transactionDispatcher = nc.createDispatcher(this::onTransactionsMessage);
    transactionDispatcher.subscribe(configuration.natsFuzzerTopicTransactions());
  }

  public Future<Boolean> start() {
    return Executors.newSingleThreadExecutor()
        .submit(
            () -> {
              while (!done) {
                // Logger.trace("Waiting for incoming messages...");
                Thread.sleep(1000);
              }
              return true;
            });
  }

  private void onTransactionsMessage(final Message msg) {
    final String messageString = new String(msg.getData(), StandardCharsets.UTF_8);
    executor.submit(
        () ->
            processTransactionPayload(
                TransactionPayload.from(messageString), RandomUtils.pickRandom(credentialsStore)));
  }

  private void processTransactionPayload(
      final TransactionPayload transactionPayload, final Credentials credentials) {
    final byte[] signedMessage;
    final Runnable successAction;
    final Runnable errorAction;
    switch (transactionPayload.type()) {
      case EIP1559:
        signedMessage =
            TransactionSigner.sign(
                chainFiller.eip1559TransactionCreator().create(transactionPayload), credentials);
        successAction = chainFiller.reporter()::incEIP1559Transactions;
        errorAction = chainFiller.reporter()::incEIP1559TransactionsError;
        break;
      case LEGACY:
      default:
        signedMessage =
            TransactionSigner.sign(
                chainFiller.legacyTransactionCreator().create(transactionPayload), credentials);
        successAction = chainFiller.reporter()::incLegacyTransactions;
        errorAction = chainFiller.reporter()::incLegacyTransactionsError;
        break;
    }
    try {
      final EthSendTransaction ethSendTransaction =
          RandomUtils.pickRandom(web3s)
              .ethSendRawTransaction(Numeric.toHexString(signedMessage))
              .send();
      System.out.println(ethSendTransaction.getTransactionHash());
      successAction.run();
    } catch (final Exception e) {
      Logger.error(e, "error sending transaction");
      errorAction.run();
    }
  }
}
