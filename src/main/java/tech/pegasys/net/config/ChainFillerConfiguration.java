package tech.pegasys.net.config;

import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
public interface ChainFillerConfiguration {
  int numThreads();

  int repeatEveryNSeconds();

  List<String> rpcEndpoints();

  List<String> accountPrivateKeys();

  List<String> recipientAddresses();

  int numTransactions();

  double eip1559TxWeight();
}
