package tech.pegasys.net.core.rx;

import io.reactivex.subscribers.DefaultSubscriber;
import org.tinylog.Logger;
import org.web3j.utils.Numeric;
import tech.pegasys.net.api.model.SignedTransaction;

public class TransactionConsumer extends DefaultSubscriber<SignedTransaction> {

  private final Integer id;

  public TransactionConsumer(final Integer id) {
    this.id = id;
  }

  @Override
  protected void onStart() {
    request(10);
  }

  @Override
  public void onNext(final SignedTransaction signedTransaction) {
    Logger.info(
        "consumer [{}] received tx: {}",
        id,
        Numeric.toHexString(signedTransaction.signedMessage()));
    request(1);
  }

  @Override
  public void onError(final Throwable error) {
    Logger.error(error, "error occurred while consuming transactions");
  }

  @Override
  public void onComplete() {
    Logger.info("transaction consumer completed");
  }
}
