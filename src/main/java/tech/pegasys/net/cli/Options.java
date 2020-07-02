package tech.pegasys.net.cli;

import picocli.CommandLine.Option;
import tech.pegasys.net.config.ChainFillerConfiguration;
import tech.pegasys.net.config.ImmutableChainFillerConfiguration;

import java.util.Arrays;
import java.util.List;

public class Options {
  private static Options instance = new Options();

  @Option(
      names = {"--rpc-endpoints"},
      paramLabel = "<http://host:port>",
      description = "Comma separated RPC endpoints of Ethereum clients nodes.",
      split = ",",
      arity = "0..*")
  private List<String> rpcEndpoints = Arrays.asList("http://127.0.0.1:8545");

  @Option(
      names = {"--account-private-keys"},
      paramLabel = "<privateKey>",
      description = "Comma separated Ethereum account private keys. ",
      split = ",",
      arity = "0..*")
  private List<String> accountPrivateKeys;

  @Option(
      names = {"--recipient-addresses"},
      paramLabel = "<address>",
      description = "Comma separated Ethereum account addresses. ",
      split = ",",
      arity = "0..*")
  private List<String> recipientAddresses;

  @Option(
      names = {"--num-threads"},
      paramLabel = "<int>",
      arity = "1",
      description = "Number of threads. (default: ${DEFAULT-VALUE})")
  private Integer numThreads = Runtime.getRuntime().availableProcessors();

  @Option(
      names = {"--num-transactions"},
      paramLabel = "<int>",
      arity = "1",
      description =
          "Number of transactions sent for each account on each RPC endpoint. (default: ${DEFAULT-VALUE})")
  private Integer numTransactions = 10;

  @Option(
      names = {"--eip-1559-tx-weight"},
      paramLabel = "<double>",
      arity = "1",
      description = "Percentage of EIP-1559 transactions. (default: ${DEFAULT-VALUE})")
  private Double eip1559TxWeight = 0.5;

  @Option(
      names = {"--repeat-every-n-seconds"},
      paramLabel = "<int>",
      arity = "1",
      description =
          "Repeat the process every n seconds, 0 means no repeat. (default: ${DEFAULT-VALUE})")
  private Integer repeatEveryNSeconds = 0;

  @Option(
      names = {"--fuzz-transfer-value-lower-bound-eth"},
      paramLabel = "<double>",
      arity = "1",
      description = "Lower bound for value transfer fuzzing in ETH. (default: ${DEFAULT-VALUE})")
  private Double fuzzTransferValueLowerBoundEth = 1.1;

  @Option(
      names = {"--fuzz-transfer-value-upper-bound-eth"},
      paramLabel = "<double>",
      arity = "1",
      description = "Upper bound for value transfer fuzzing in ETH. (default: ${DEFAULT-VALUE})")
  private Double fuzzTransferValueUpperBoundEth = 5.3;

  public static Options getInstance() {
    return instance;
  }

  public ChainFillerConfiguration toTxSenderConfiguration() {
    return ImmutableChainFillerConfiguration.builder()
        .addAllRpcEndpoints(rpcEndpoints)
        .addAllAccountPrivateKeys(accountPrivateKeys)
        .addAllRecipientAddresses(recipientAddresses)
        .numThreads(numThreads)
        .numTransactions(numTransactions)
        .eip1559TxWeight(eip1559TxWeight)
        .repeatEveryNSeconds(repeatEveryNSeconds)
        .fuzzTransferValueLowerBoundEth(fuzzTransferValueLowerBoundEth)
        .fuzzTransferValueUpperBoundEth(fuzzTransferValueUpperBoundEth)
        .build();
  }
}
