package tech.pegasys.net.client;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import tech.pegasys.net.api.service.rpc.RpcClient;

public class RpcClientService implements RpcClient {
  private static final MediaType JSON = MediaType.parse("application/json");
  private final String rpcEndpoint;
  private final OkHttpClient client;

  public RpcClientService(final String rpcEndpoint) {
    this.rpcEndpoint = rpcEndpoint;
    this.client = new OkHttpClient.Builder().build();
  }

  @Override
  public String call(final String jsonRequest) throws IOException {
    final Response response =
        client
            .newCall(
                new Request.Builder()
                    .url(rpcEndpoint)
                    .post(RequestBody.create(jsonRequest, JSON))
                    .build())
            .execute();
    if (response.isSuccessful()) {
      return Objects.requireNonNull(response.body()).string();
    } else {
      throw new IOException("error calling rpc method");
    }
  }

  @Override
  public void ethBatchSendRawTransaction(final List<String> transactions) throws IOException {
    call(
        new JSONObject()
            .put("jsonrpc", "2.0")
            .put("method", "debug_batchSendRawTransaction")
            .put("params", new JSONArray(transactions))
            .put("id", 1)
            .toString());
  }
}
