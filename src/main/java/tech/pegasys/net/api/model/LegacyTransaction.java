package tech.pegasys.net.api.model;

import java.math.BigInteger;
import java.util.Optional;

import org.immutables.value.Value;

@Value.Immutable
public abstract class LegacyTransaction extends Transaction {

  public abstract BigInteger gasPrice();

  public abstract Optional<String> bytecode();
}
