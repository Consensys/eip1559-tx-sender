package tech.pegasys.net.api.model;

import org.immutables.value.Value;

import java.math.BigInteger;

@Value.Immutable
public abstract class LegacyTransaction extends Transaction {

  public abstract BigInteger gasPrice();
}
