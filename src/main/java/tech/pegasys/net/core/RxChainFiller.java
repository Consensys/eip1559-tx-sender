package tech.pegasys.net.core;

import io.reactivex.schedulers.Schedulers;
import org.immutables.value.Value;
import org.tinylog.Logger;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import tech.pegasys.net.api.ChainFiller;
import tech.pegasys.net.config.ChainFillerConfiguration;
import tech.pegasys.net.core.rx.TransactionConsumer;
import tech.pegasys.net.core.rx.TransactionProducer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Value.Immutable
public abstract class RxChainFiller {

  public abstract ChainFiller chainFiller();

  public abstract ChainFillerConfiguration configuration();

  public void start() {
    try {
      Logger.info("starting rx chain filler (continuous mode)");
      final AtomicInteger producerId = new AtomicInteger(0);
      final AtomicInteger consumerId = new AtomicInteger(0);
      final ExecutorService executorService =
          Executors.newFixedThreadPool(configuration().numThreads());
      configuration().rpcEndpoints().stream()
          .map(HttpService::new)
          .map(Web3j::build)
          .forEach(
              web3 ->
                  configuration().accountPrivateKeys().stream()
                      .map(Credentials::create)
                      .map(
                          credentials ->
                              new TransactionProducer(
                                  producerId.getAndIncrement(), chainFiller(), web3, credentials))
                      .forEach(
                          transactionProducer ->
                              executorService.submit(
                                  () ->
                                      transactionProducer
                                          .subscribeOn(Schedulers.computation())
                                          .observeOn(Schedulers.single())
                                          .blockingSubscribe(
                                              new TransactionConsumer(
                                                  consumerId.getAndIncrement())))));
      executorService.shutdown();
      executorService.awaitTermination(1, TimeUnit.DAYS);
    } catch (final Exception e) {
      Logger.error(e);
      throw new RuntimeException(e);
    }
  }
}
