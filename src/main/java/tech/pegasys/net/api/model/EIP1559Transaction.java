package tech.pegasys.net.api.model;

import org.immutables.value.Value;

import java.math.BigInteger;

@Value.Immutable
public abstract class EIP1559Transaction extends Transaction {
  public abstract BigInteger gasPremium();

  public abstract BigInteger feeCap();
}
