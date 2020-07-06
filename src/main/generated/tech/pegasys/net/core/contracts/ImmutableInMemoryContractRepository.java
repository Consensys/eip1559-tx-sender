package tech.pegasys.net.core.contracts;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;
import tech.pegasys.net.api.model.Contract;

/**
 * Immutable implementation of {@link InMemoryContractRepository}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableInMemoryContractRepository.builder()}.
 */
@Generated(from = "InMemoryContractRepository", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class ImmutableInMemoryContractRepository
    extends InMemoryContractRepository {
  private final ImmutableList<Contract> contracts;

  private ImmutableInMemoryContractRepository(ImmutableList<Contract> contracts) {
    this.contracts = contracts;
  }

  /**
   * @return The value of the {@code contracts} attribute
   */
  @Override
  public ImmutableList<Contract> contracts() {
    return contracts;
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link InMemoryContractRepository#contracts() contracts}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableInMemoryContractRepository withContracts(Contract... elements) {
    ImmutableList<Contract> newValue = ImmutableList.copyOf(elements);
    return new ImmutableInMemoryContractRepository(newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link InMemoryContractRepository#contracts() contracts}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of contracts elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableInMemoryContractRepository withContracts(Iterable<? extends Contract> elements) {
    if (this.contracts == elements) return this;
    ImmutableList<Contract> newValue = ImmutableList.copyOf(elements);
    return new ImmutableInMemoryContractRepository(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableInMemoryContractRepository} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableInMemoryContractRepository
        && equalTo((ImmutableInMemoryContractRepository) another);
  }

  private boolean equalTo(ImmutableInMemoryContractRepository another) {
    return contracts.equals(another.contracts);
  }

  /**
   * Computes a hash code from attributes: {@code contracts}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + contracts.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code InMemoryContractRepository} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("InMemoryContractRepository")
        .omitNullValues()
        .add("contracts", contracts)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link InMemoryContractRepository} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable InMemoryContractRepository instance
   */
  public static ImmutableInMemoryContractRepository copyOf(InMemoryContractRepository instance) {
    if (instance instanceof ImmutableInMemoryContractRepository) {
      return (ImmutableInMemoryContractRepository) instance;
    }
    return ImmutableInMemoryContractRepository.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableInMemoryContractRepository ImmutableInMemoryContractRepository}.
   * <pre>
   * ImmutableInMemoryContractRepository.builder()
   *    .addContracts|addAllContracts(tech.pegasys.net.api.model.Contract) // {@link InMemoryContractRepository#contracts() contracts} elements
   *    .build();
   * </pre>
   * @return A new ImmutableInMemoryContractRepository builder
   */
  public static ImmutableInMemoryContractRepository.Builder builder() {
    return new ImmutableInMemoryContractRepository.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableInMemoryContractRepository ImmutableInMemoryContractRepository}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "InMemoryContractRepository", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private ImmutableList.Builder<Contract> contracts = ImmutableList.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code InMemoryContractRepository} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(InMemoryContractRepository instance) {
      Objects.requireNonNull(instance, "instance");
      addAllContracts(instance.contracts());
      return this;
    }

    /**
     * Adds one element to {@link InMemoryContractRepository#contracts() contracts} list.
     * @param element A contracts element
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addContracts(Contract element) {
      this.contracts.add(element);
      return this;
    }

    /**
     * Adds elements to {@link InMemoryContractRepository#contracts() contracts} list.
     * @param elements An array of contracts elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addContracts(Contract... elements) {
      this.contracts.add(elements);
      return this;
    }


    /**
     * Sets or replaces all elements for {@link InMemoryContractRepository#contracts() contracts} list.
     * @param elements An iterable of contracts elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder contracts(Iterable<? extends Contract> elements) {
      this.contracts = ImmutableList.builder();
      return addAllContracts(elements);
    }

    /**
     * Adds elements to {@link InMemoryContractRepository#contracts() contracts} list.
     * @param elements An iterable of contracts elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAllContracts(Iterable<? extends Contract> elements) {
      this.contracts.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutableInMemoryContractRepository ImmutableInMemoryContractRepository}.
     * @return An immutable instance of InMemoryContractRepository
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableInMemoryContractRepository build() {
      return new ImmutableInMemoryContractRepository(contracts.build());
    }
  }
}
