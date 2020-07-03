package tech.pegasys.net.core.contracts;

import tech.pegasys.net.api.ContractRepository;
import tech.pegasys.net.api.model.Contract;
import tech.pegasys.net.util.FileUtils;

import java.io.File;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

public class ContractRepositoryFactory {

  private static final String CONTRACTS_ROOT_LOCATION = "contracts";
  private static final String CONTRACTS_FILE_EXTENSION = ".contract";

  public static ContractRepository inMemoryContractRepository() {
    try {
      return ImmutableInMemoryContractRepository.builder()
          .addAllContracts(
              Stream.of(
                      requireNonNull(
                          new File(
                                  requireNonNull(
                                          ContractRepositoryFactory.class
                                              .getClassLoader()
                                              .getResource(CONTRACTS_ROOT_LOCATION))
                                      .toURI())
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
