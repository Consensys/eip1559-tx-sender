package tech.pegasys.net.api.service;

public interface BaseFeeOracle {

  Long estimateBaseFee(String block);

  default Long estimateBaseFee() {
    return estimateBaseFee("latest");
  }
}
