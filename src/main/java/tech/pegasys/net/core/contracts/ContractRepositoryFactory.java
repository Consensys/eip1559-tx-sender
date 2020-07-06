package tech.pegasys.net.core.contracts;

import tech.pegasys.net.api.model.Contract;
import tech.pegasys.net.api.service.ContractRepository;
import tech.pegasys.net.util.FileUtils;

import java.io.File;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

public class ContractRepositoryFactory {
  private static final String CONTRACTS_FILE_EXTENSION = ".contract";

  public static ContractRepository inMemoryContractRepository(final Optional<Path> contractDir) {
    try {
      if (contractDir.isEmpty()) {
        return ImmutableInMemoryContractRepository.builder()
            .addAllContracts(Collections.emptyList())
            .build();
      }
      return ImmutableInMemoryContractRepository.builder()
          .addAllContracts(
              Stream.of(
                      requireNonNull(
                          contractDir
                              .get()
                              .toFile()
                              .listFiles(
                                  (dir, name) ->
                                      name.toLowerCase().endsWith(CONTRACTS_FILE_EXTENSION))))
                  .map(File::toURI)
                  .map(FileUtils::readContent)
                  .map(Contract::of)
                  .collect(Collectors.toList()))
          .build();
    } catch (final Exception e) {
      throw new RuntimeException(e);
    }
  }
}
