package tech.pegasys.net.api.model;

import org.immutables.value.Value;

@Value.Immutable
public interface Account {
  String address();
}
