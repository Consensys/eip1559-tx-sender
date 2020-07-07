package tech.pegasys.net.core.credentials;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.web3j.crypto.Credentials;
import tech.pegasys.net.api.repository.CredentialsRepository;

public class CredentialsRepositoryFactory {

  public static CredentialsRepository inMemoryCredentialsRepository(
      final List<String> privateKeys) {
    final Map<String, Credentials> credentialsStore =
        privateKeys.stream()
            .collect(
                Collectors.toMap(
                    privateKey -> privateKey,
                    Credentials::create,
                    (a, b) -> b,
                    ConcurrentHashMap::new));
    return ImmutableInMemoryCredentialsRepository.builder()
        .credentialsStore(credentialsStore)
        .build();
  }
}
