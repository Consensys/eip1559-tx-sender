package tech.pegasys.net.config;

import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
public interface TxSenderConfiguration {
  int numThreads();

  int repeatEveryNSeconds();

  List<String> rpcEndpoints();

  List<String> accountPrivateKeys();

  int numTransactions();

  double eip1559TxWeight();
}
