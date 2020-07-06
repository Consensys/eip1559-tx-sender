package tech.pegasys.net.fuzzer;

import io.nats.client.Connection;
import io.nats.client.ConnectionListener;
import io.nats.client.Dispatcher;
import io.nats.client.Message;
import io.nats.client.Nats;
import io.nats.client.Options;
import org.tinylog.Logger;
import tech.pegasys.net.api.service.ChainFiller;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class NatsFuzzer {

  private final ExecutorService executor;
  private final ChainFiller chainFiller;
  private final String url;
  private final boolean asyncConnection;
  private final String transactionsTopic;
  private Connection nc;
  private boolean done = false;

  public NatsFuzzer(
      final ExecutorService executor,
      final ChainFiller chainFiller,
      final String url,
      final boolean asyncConnection,
      final String transactionsTopic) {
    this.executor = executor;
    this.chainFiller = chainFiller;
    this.asyncConnection = asyncConnection;
    this.transactionsTopic = transactionsTopic;
    try {
      this.url = url;
      if (asyncConnection) {
        Nats.connectAsynchronously(
            new Options.Builder().server(url).connectionListener(this::handleConnection).build(),
            true);
      } else {
        nc = Nats.connect(url);
        onConnected();
      }
    } catch (final Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {
    try {
      final Connection nc = Nats.connect("nats://127.0.0.1:4222");
      final String message = "{\"nonce\":2,\"value\":1000000000000000000,\"gasPrice\":21000}";
      nc.publish("fuzz.transactions", message.getBytes(StandardCharsets.UTF_8));
    } catch (final Exception e) {
      System.err.println(e.getMessage());
    }
  }

  public void handleConnection(final Connection nc, final ConnectionListener.Events type) {
    switch (type) {
      case CLOSED:
        Logger.error("cannot connect to NATS: closed");
        break;
      case DISCONNECTED:
        Logger.error("cannot connect to NATS: disconnected");
        break;
      case CONNECTED:
        onConnected();
        break;
    }
  }

  private void onConnected() {
    Logger.debug("connected to NATS.");
    final Dispatcher transactionDispatcher = nc.createDispatcher(this::onTransactionsMessage);
    transactionDispatcher.subscribe(transactionsTopic);
  }

  public Future<Boolean> start() {
    return executor.submit(
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
    Logger.debug("received message on transactions topic: {}", messageString);
  }
}
