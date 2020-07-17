package tech.pegasys.net.util;

import java.util.Arrays;

import org.apache.commons.math3.distribution.EnumeratedDistribution;
import org.apache.commons.math3.util.Pair;
import tech.pegasys.net.api.model.TransactionType;

public class TransactionTypeSelector {

  private final EnumeratedDistribution<TransactionType> distribution;

  public TransactionTypeSelector(final double eip1559Weight) {
    distribution =
        new EnumeratedDistribution<>(
            Arrays.asList(
                new Pair<>(TransactionType.LEGACY, 1 - eip1559Weight),
                new Pair<>(TransactionType.EIP1559, eip1559Weight)));
  }

  public TransactionType next() {
    return distribution.sample();
  }
}
