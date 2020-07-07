package tech.pegasys.net.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import io.reactivex.schedulers.Schedulers;
import org.immutables.value.Value;
import org.tinylog.Logger;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import tech.pegasys.net.api.service.ChainFiller;
import tech.pegasys.net.config.ChainFillerConfiguration;
import tech.pegasys.net.core.rx.TransactionConsumer;
import tech.pegasys.net.core.rx.TransactionProducer;

@Value.Immutable
public abstract class RxChainFiller {

  public abstract ChainFiller chainFiller();

  public abstract ChainFillerConfiguration configuration();

  public void start() {
    try {
      Logger.info("starting rx chain filler (continuous mode)");
      final ExecutorService executorService =
          Executors.newFixedThreadPool(configuration().numThreads());
      configuration().rpcEndpoints().stream()
          .map(HttpService::new)
          .map(Web3j::build)
          .forEach(
              web3 ->
                  configuration().accountPrivateKeys().stream()
                      .map(Credentials::create)
                      .map(credentials -> new TransactionProducer(chainFiller(), web3, credentials))
                      .forEach(
                          transactionProducer ->
                              executorService.submit(
                                  () ->
                                      transactionProducer
                                          .subscribeOn(Schedulers.computation())
                                          .observeOn(Schedulers.single())
                                          .blockingSubscribe(new TransactionConsumer(web3)))));
      executorService.shutdown();
      executorService.awaitTermination(1, TimeUnit.DAYS);
    } catch (final Exception e) {
      Logger.error(e);
      throw new RuntimeException(e);
    }
  }
}
