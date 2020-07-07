package tech.pegasys.net.api.repository;

import java.util.Optional;
import java.util.stream.Stream;

import org.web3j.crypto.Credentials;

public interface CredentialsRepository {

  void put(String identifier, Credentials credentials);

  Optional<Credentials> get(String identifier);

  Stream<Credentials> all();
}
