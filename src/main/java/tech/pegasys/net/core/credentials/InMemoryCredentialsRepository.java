package tech.pegasys.net.core.credentials;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import org.immutables.value.Value;
import org.web3j.crypto.Credentials;
import tech.pegasys.net.api.repository.CredentialsRepository;

@Value.Immutable
public abstract class InMemoryCredentialsRepository implements CredentialsRepository {

  public abstract Map<String, Credentials> credentialsStore();

  @Override
  public void put(final String identifier, final Credentials credentials) {
    credentialsStore().put(identifier, credentials);
  }

  @Override
  public Optional<Credentials> get(final String identifier) {
    return Optional.ofNullable(credentialsStore().get(identifier));
  }

  @Override
  public Stream<Credentials> all() {
    return credentialsStore().values().stream();
  }
}
