package tech.pegasys.net.api.model;

import org.immutables.value.Value;

import java.math.BigInteger;
import java.util.Optional;

@Value.Immutable
public abstract class LegacyTransaction extends Transaction {

  public abstract BigInteger gasPrice();

  public abstract Optional<String> bytecode();
}
