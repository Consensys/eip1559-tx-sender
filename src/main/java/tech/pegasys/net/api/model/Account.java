package tech.pegasys.net.api.model;

import org.immutables.value.Value;
import org.web3j.crypto.Credentials;

@Value.Immutable
public interface Account {
  String address();

  Credentials credentials();
}
