package tech.pegasys.net.core.credentials;

import org.web3j.crypto.Credentials;
import tech.pegasys.net.api.CredentialsRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

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
