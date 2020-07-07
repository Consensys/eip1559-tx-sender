package tech.pegasys.net.api.service.rpc;

import java.io.IOException;

public interface RpcClient {

  String call(String request) throws IOException;
}
