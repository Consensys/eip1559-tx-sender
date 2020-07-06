package tech.pegasys.net.api.service;

import org.web3j.crypto.Credentials;

import java.util.Optional;
import java.util.stream.Stream;

public interface CredentialsRepository {

  void put(String identifier, Credentials credentials);

  Optional<Credentials> get(String identifier);

  Stream<Credentials> all();
}
