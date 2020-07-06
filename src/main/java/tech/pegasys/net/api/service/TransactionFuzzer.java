package tech.pegasys.net.api.service;

import java.math.BigDecimal;

public interface TransactionFuzzer {

  BigDecimal value();

  BigDecimal value(BigDecimal upperBound);

  BigDecimal value(BigDecimal lowerBound, BigDecimal upperBound);

  default BigDecimal value(double lowerBound, double upperBound) {
    return value(BigDecimal.valueOf(lowerBound), BigDecimal.valueOf(upperBound));
  }
}
