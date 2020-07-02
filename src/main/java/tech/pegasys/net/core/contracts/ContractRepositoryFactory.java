package tech.pegasys.net.core.contracts;

import tech.pegasys.net.api.ContractRepository;
import tech.pegasys.net.api.model.Contract;
import tech.pegasys.net.util.FileUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContractRepositoryFactory {

  private static final List<String> CONTRACT_FILES = Arrays.asList("binance-erc20-bytecode");

  public static ContractRepository inMemoryContractRepository() {
    return ImmutableInMemoryContractRepository.builder()
        .addAllContracts(
            CONTRACT_FILES.stream()
                .map(ContractRepositoryFactory.class.getClassLoader()::getResource)
                .map(FileUtils::readContent)
                .map(Contract::of)
                .collect(Collectors.toList()))
        .build();
  }
}
