package tech.pegasys.net.api.model;

import java.math.BigInteger;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;

import org.tinylog.Logger;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.http.HttpService;
import tech.pegasys.net.client.RpcClientService;

public class ActionableAccount {

  private static final long ACCOUNT_PARAMS_VALIDITY_MS = Duration.ofMinutes(1).toMillis();

  private final Credentials credentials;
  private final String rpcEndpoint;
  private final Web3j web3;
  private final RpcClientService rpcClient;
  private AtomicLong nonce;
  private BigInteger gasPrice;
  private long lastUpdated = 0;

  public ActionableAccount(final Credentials credentials, final String rpcEndpoint) {
    this.credentials = credentials;
    this.rpcEndpoint = rpcEndpoint;
    this.web3 = Web3j.build(new HttpService(rpcEndpoint));
    this.rpcClient = new RpcClientService(rpcEndpoint);
  }

  private void refreshAccountParams() {
    try {
      this.nonce =
          new AtomicLong(
              web3.ethGetTransactionCount(
                      credentials.getAddress(), DefaultBlockParameterName.LATEST)
                  .send()
                  .getTransactionCount()
                  .longValue());
      this.gasPrice = web3.ethGasPrice().send().getGasPrice();
    } catch (Exception e) {
      Logger.error(e, "error setting account parameters (nonce, gasPrice)");
      this.gasPrice = BigInteger.ZERO;
      this.nonce = new AtomicLong(0);
    }
    lastUpdated = System.currentTimeMillis();
  }

  private boolean needRefresh() {
    return lastUpdated == 0
        || (System.currentTimeMillis() - lastUpdated) >= ACCOUNT_PARAMS_VALIDITY_MS;
  }

  public ActionableAccount updated() {
    update();
    return this;
  }

  public void update() {
    if (needRefresh()) {
      refreshAccountParams();
    }
  }

  public AtomicLong getNonce() {
    return updated().nonce;
  }

  public BigInteger getGasPrice() {
    return updated().gasPrice;
  }

  public Credentials getCredentials() {
    return credentials;
  }

  public Web3j getWeb3() {
    return web3;
  }

  public RpcClientService getRpcClient() {
    return rpcClient;
  }

  @Override
  public String toString() {
    return String.format("%s - %s - %s", rpcEndpoint, credentials.getAddress(), getNonce().get());
  }
}
