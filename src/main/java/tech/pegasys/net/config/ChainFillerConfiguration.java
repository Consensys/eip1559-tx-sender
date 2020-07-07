package tech.pegasys.net.config;

import java.util.List;

import org.immutables.value.Value;

@Value.Immutable
public interface ChainFillerConfiguration {
  FillerMode fillerMode();

  int numThreads();

  int repeatEveryNSeconds();

  List<String> rpcEndpoints();

  List<String> accountPrivateKeys();

  List<String> recipientAddresses();

  int numTransactions();

  int numSmartContracts();

  double eip1559TxWeight();

  double fuzzTransferValueLowerBoundEth();

  double fuzzTransferValueUpperBoundEth();

  String contractDir();

  String natsURL();

  boolean natsAsyncConnection();

  String natsFuzzerTopicTransactions();
}
