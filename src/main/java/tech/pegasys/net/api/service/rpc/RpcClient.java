package tech.pegasys.net.api.service.rpc;

import java.io.IOException;
import java.util.List;

public interface RpcClient {

  String call(String request) throws IOException;

  void ethBatchSendRawTransaction(final List<String> transactions) throws IOException;
}
