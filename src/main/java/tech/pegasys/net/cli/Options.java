package tech.pegasys.net.cli;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.tinylog.Logger;
import picocli.CommandLine.Option;
import tech.pegasys.net.config.ChainFillerConfiguration;
import tech.pegasys.net.config.FillerMode;
import tech.pegasys.net.config.ImmutableChainFillerConfiguration;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
      names = {"--num-contracts"},
      paramLabel = "<int>",
      arity = "1",
      description =
          "Number of smart contracts to deploy for each account on each RPC endpoint. (default: ${DEFAULT-VALUE})")
  private Integer numSmartContracts = 0;

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

  @Option(
      names = {"--contract-dir"},
      paramLabel = "<path>",
      arity = "1",
      description =
          "Location of contracts root directory used to provision contract repository. (default: ${DEFAULT-VALUE})")
  private String contractDir = "";

  @Option(
      names = {"--filler-mode"},
      paramLabel = "<MODE>",
      description = "Filler mode, possible values are ${COMPLETION-CANDIDATES} (default: ONESHOT)")
  private FillerMode fillerMode = FillerMode.ONESHOT;

  @Option(
      names = {"--nats-url"},
      paramLabel = "<nats://host:port>",
      arity = "1",
      description = "NATS URL. (default: ${DEFAULT-VALUE})")
  private String natsURL = "nats://127.0.0.1:4222";

  @Option(
      names = {"--nats-async-connection-enabled"},
      paramLabel = "<bool>",
      description = " (default: ${DEFAULT-VALUE})")
  private Boolean natsAsyncConnection = false;

  @Option(
      names = {"--nats-fuzzer-topic-transactions"},
      paramLabel = "<topic>",
      arity = "1",
      description = "NATS fuzzer transaction topic. (default: ${DEFAULT-VALUE})")
  private String natsFuzzerTopicTransactions = "fuzz.transactions";

  @Option(
      names = {"--genesis-file"},
      paramLabel = "<path>",
      arity = "1",
      description = "Location of genesis file. (default: ${DEFAULT-VALUE})")
  private String genesisFile = null;

  public static Options getInstance() {
    return instance;
  }

  public ChainFillerConfiguration toChainFillerConfiguration() {
    try {

      if (genesisFile != null) {
        final Path genesisPath = Paths.get(genesisFile);
        final DocumentContext documentContext = JsonPath.parse(genesisPath.toUri().toURL());
        final Map<String, Map<String, String>> alloc = documentContext.read("$.alloc");
        accountPrivateKeys = new ArrayList<>();
        recipientAddresses = new ArrayList<>();
        alloc.forEach(
            (address, account) -> {
              recipientAddresses.add(address);
              if (account.containsKey("privateKey")) {
                accountPrivateKeys.add(account.get("privateKey"));
              }
            });
      }
    } catch (final IOException e) {
      Logger.error(e);
    }
    return ImmutableChainFillerConfiguration.builder()
        .fillerMode(fillerMode)
        .addAllRpcEndpoints(rpcEndpoints)
        .addAllAccountPrivateKeys(accountPrivateKeys)
        .addAllRecipientAddresses(recipientAddresses)
        .numThreads(numThreads)
        .numTransactions(numTransactions)
        .numSmartContracts(numSmartContracts)
        .eip1559TxWeight(eip1559TxWeight)
        .repeatEveryNSeconds(repeatEveryNSeconds)
        .fuzzTransferValueLowerBoundEth(fuzzTransferValueLowerBoundEth)
        .fuzzTransferValueUpperBoundEth(fuzzTransferValueUpperBoundEth)
        .contractDir(contractDir)
        .natsURL(natsURL)
        .natsAsyncConnection(natsAsyncConnection)
        .natsFuzzerTopicTransactions(natsFuzzerTopicTransactions)
        .genesisFile(genesisFile)
        .build();
  }
}
