package tech.pegasys.net.api.model;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Contract {

  public static Contract of(final String code) {
    return ImmutableContract.builder().code(code).build();
  }

  public abstract String code();
}
