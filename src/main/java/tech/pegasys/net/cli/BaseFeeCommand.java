package tech.pegasys.net.cli;

import org.json.JSONObject;
import picocli.CommandLine;
import tech.pegasys.net.core.oracle.BaseFeeOracleService;

@CommandLine.Command(
    name = "basefee",
    description = "Gets base fee value at given block.",
    mixinStandardHelpOptions = true)
public class BaseFeeCommand implements Runnable {

  @CommandLine.Option(
      names = {"--rpc-endpoint"},
      paramLabel = "<http://host:port>",
      description = "RPC endpoint of Ethereum client node. (default: ${DEFAULT-VALUE})",
      arity = "1")
  private String rpcEndpoint = "http://127.0.0.1:8545";

  @CommandLine.Option(
      names = {"--block"},
      paramLabel = "<block>",
      description =
          "Block number in hex or one of earliest, latest, pending. (default: ${DEFAULT-VALUE})",
      arity = "1")
  private String block = "latest";

  public BaseFeeCommand() {}

  @Override
  public void run() {
    final BaseFeeOracleService baseFeeOracle = new BaseFeeOracleService(rpcEndpoint);
    final Long baseFee = baseFeeOracle.estimateBaseFee();
    final String baseFeeHex = String.format("0x%s", Long.toHexString(baseFee));
    System.out.println(
        new JSONObject().put("baseFee", baseFee).put("baseFeeHex", baseFeeHex).toString());
  }
}
