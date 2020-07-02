package tech.pegasys.net.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtils {

  public static BigDecimal generateRandomBigDecimalFromRange(
      final BigDecimal min, final BigDecimal max) {
    final BigDecimal randomBigDecimal =
        min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
    return randomBigDecimal.setScale(2, RoundingMode.HALF_UP);
  }
}
