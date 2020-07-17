package tech.pegasys.net.core.oracle;

import java.time.Instant;

import com.jayway.jsonpath.JsonPath;
import org.tinylog.Logger;
import tech.pegasys.net.api.model.rpc.RpcMethodTemplate;
import tech.pegasys.net.api.service.BaseFeeOracle;
import tech.pegasys.net.api.service.rpc.RpcClient;
import tech.pegasys.net.client.RpcClientService;

public class BaseFeeOracleService implements BaseFeeOracle {

  private static final long REFRESH_INTERVAL_SECONDS = 10;
  private final RpcClient rpcClient;
  private Instant lastCachedBaseFeeAt;
  private Long lastCachedBaseFee;

  public BaseFeeOracleService(final String rpcURL) {
    this.rpcClient = new RpcClientService(rpcURL);
  }

  @Override
  public Long estimateBaseFee(final String block) {
    if (needRefresh()) {
      lastCachedBaseFee = refreshBaseFee(block);
      lastCachedBaseFeeAt = Instant.now();
    }
    return lastCachedBaseFee;
  }

  private boolean needRefresh() {
    return lastCachedBaseFeeAt == null
        || lastCachedBaseFeeAt.plusSeconds(REFRESH_INTERVAL_SECONDS).compareTo(Instant.now()) <= 0;
  }

  private Long refreshBaseFee(final String block) {
    try {
      final String baseFee =
          JsonPath.parse(rpcClient.call(RpcMethodTemplate.ETH_GET_BLOCK_BY_NUMBER.format(block)))
              .read("$.result.baseFee");
      return Long.parseLong(baseFee.substring(2), 16);
    } catch (final Exception e) {
      Logger.error(e, "error retrieving base fee");
      return null;
    }
  }
}
