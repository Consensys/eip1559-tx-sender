package tech.pegasys.net.api.model;

import java.math.BigInteger;

import org.immutables.value.Value;

@Value.Immutable
public abstract class EIP1559Transaction extends Transaction {
  public abstract BigInteger gasPremium();

  public abstract BigInteger feeCap();
}
