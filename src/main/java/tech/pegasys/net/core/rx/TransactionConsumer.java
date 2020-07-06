package tech.pegasys.net.core.rx;

import io.reactivex.subscribers.DefaultSubscriber;
import org.tinylog.Logger;
import org.web3j.protocol.Web3j;
import org.web3j.utils.Numeric;
import tech.pegasys.net.api.model.SignedTransaction;

public class TransactionConsumer extends DefaultSubscriber<SignedTransaction> {
  private final Web3j web3;

  public TransactionConsumer(final Web3j web3) {
    this.web3 = web3;
  }

  @Override
  protected void onStart() {
    request(10);
  }

  @Override
  public void onNext(final SignedTransaction signedTransaction) {
    submit(signedTransaction);
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

  private void submit(final SignedTransaction signedTransaction) {
    try {
      web3.ethSendRawTransaction(Numeric.toHexString(signedTransaction.signedMessage())).send();
    } catch (final Exception e) {
      Logger.error(e, "error occurred while submitting transaction");
    }
  }
}
