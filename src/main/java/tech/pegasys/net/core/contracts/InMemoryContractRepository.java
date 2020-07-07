package tech.pegasys.net.core.contracts;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import org.immutables.value.Value;
import tech.pegasys.net.api.model.Contract;
import tech.pegasys.net.api.repository.ContractRepository;

@Value.Immutable
public abstract class InMemoryContractRepository implements ContractRepository {

  public abstract List<Contract> contracts();

  @Override
  public void add(final Contract contract) {
    contracts().add(contract);
  }

  public Contract random() {
    return contracts().get(ThreadLocalRandom.current().nextInt(contracts().size()));
  }

  @Override
  public Stream<Contract> all() {
    return contracts().stream();
  }
}
