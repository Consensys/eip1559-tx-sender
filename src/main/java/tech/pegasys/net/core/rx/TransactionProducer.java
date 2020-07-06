package tech.pegasys.net.core.rx;

import io.reactivex.Flowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.tinylog.Logger;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import tech.pegasys.net.api.service.ChainFiller;
import tech.pegasys.net.api.service.TransactionSigner;
import tech.pegasys.net.api.model.ImmutableSignedTransaction;
import tech.pegasys.net.api.model.SignedTransaction;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TransactionProducer extends Flowable<SignedTransaction> {
  private final ChainFiller chainFiller;
  private final Web3j web3;
  private final Credentials credentials;
  private AtomicLong nonce;
  private BigInteger initialGasPrice;

  public TransactionProducer(
      final ChainFiller chainFiller, final Web3j web3, final Credentials credentials) {
    this.chainFiller = chainFiller;
    this.web3 = web3;
    this.credentials = credentials;
    try {
      this.nonce =
          new AtomicLong(
              web3.ethGetTransactionCount(
                      credentials.getAddress(), DefaultBlockParameterName.LATEST)
                  .send()
                  .getTransactionCount()
                  .longValue());
      this.initialGasPrice = web3.ethGasPrice().send().getGasPrice();
    } catch (Exception e) {
      Logger.error(e, "error setting initial parameters (nonce, gasPrice)");
      this.initialGasPrice = BigInteger.ZERO;
      this.nonce = new AtomicLong(0);
    }
  }

  @Override
  protected void subscribeActual(final Subscriber<? super SignedTransaction> subscriber) {
    subscriber.onSubscribe(
        new Subscription() {
          private final AtomicLong outStandingRequests = new AtomicLong(0);
          /** cancellation flag. */
          private volatile boolean cancelled = false;

          private volatile boolean isProducing = false;

          @Override
          public void request(long n) {
            if (!cancelled) {
              outStandingRequests.addAndGet(n);
              // check if already fulfilling request to prevent call  between request() an
              // subscriber .onNext()
              if (isProducing) {
                return;
              }
              // start producing
              isProducing = true;
              while (outStandingRequests.get() > 0) {
                final SignedTransaction next = generateSignedTransaction();
                subscriber.onNext(next);
                outStandingRequests.decrementAndGet();
              }
              isProducing = false;
            }
          }

          @Override
          public void cancel() {
            cancelled = true;
          }
        });
  }

  private SignedTransaction generateSignedTransaction() {
    return ImmutableSignedTransaction.builder()
        .signedMessage(
            TransactionSigner.sign(
                chainFiller
                    .legacyTransactionCreator()
                    .create(BigInteger.valueOf(nonce.getAndIncrement()), initialGasPrice),
                credentials))
        .build();
  }
}
