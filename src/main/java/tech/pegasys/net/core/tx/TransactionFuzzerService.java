package tech.pegasys.net.core.tx;

import tech.pegasys.net.api.TransactionFuzzer;
import tech.pegasys.net.util.NumberUtils;

import java.math.BigDecimal;

public class TransactionFuzzerService implements TransactionFuzzer {
  public static final BigDecimal DEFAULT_LOWER_BOUND_ETH = BigDecimal.valueOf(1);
  public static final BigDecimal DEFAULT_UPPER_BOUND_ETH = BigDecimal.valueOf(5);

  @Override
  public BigDecimal value() {
    return NumberUtils.generateRandomBigDecimalFromRange(
        DEFAULT_LOWER_BOUND_ETH, DEFAULT_UPPER_BOUND_ETH);
  }

  @Override
  public BigDecimal value(final BigDecimal upperBound) {
    return NumberUtils.generateRandomBigDecimalFromRange(BigDecimal.ZERO, upperBound);
  }

  @Override
  public BigDecimal value(final BigDecimal lowerBound, final BigDecimal upperBound) {
    return NumberUtils.generateRandomBigDecimalFromRange(lowerBound, upperBound);
  }
}
