package tech.pegasys.net.core.account;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;
import tech.pegasys.net.api.model.Account;

/**
 * Immutable implementation of {@link InMemoryAccountRepository}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableInMemoryAccountRepository.builder()}.
 */
@Generated(from = "InMemoryAccountRepository", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class ImmutableInMemoryAccountRepository
    extends InMemoryAccountRepository {
  private final ImmutableMap<String, Account> accounts;

  private ImmutableInMemoryAccountRepository(
      ImmutableMap<String, Account> accounts) {
    this.accounts = accounts;
  }

  /**
   * @return The value of the {@code accounts} attribute
   */
  @Override
  public ImmutableMap<String, Account> accounts() {
    return accounts;
  }

  /**
   * Copy the current immutable object by replacing the {@link InMemoryAccountRepository#accounts() accounts} map with the specified map.
   * Nulls are not permitted as keys or values.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param entries The entries to be added to the accounts map
   * @return A modified copy of {@code this} object
   */
  public final ImmutableInMemoryAccountRepository withAccounts(Map<String, ? extends Account> entries) {
    if (this.accounts == entries) return this;
    ImmutableMap<String, Account> newValue = ImmutableMap.copyOf(entries);
    return new ImmutableInMemoryAccountRepository(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableInMemoryAccountRepository} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableInMemoryAccountRepository
        && equalTo((ImmutableInMemoryAccountRepository) another);
  }

  private boolean equalTo(ImmutableInMemoryAccountRepository another) {
    return accounts.equals(another.accounts);
  }

  /**
   * Computes a hash code from attributes: {@code accounts}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + accounts.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code InMemoryAccountRepository} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("InMemoryAccountRepository")
        .omitNullValues()
        .add("accounts", accounts)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link InMemoryAccountRepository} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable InMemoryAccountRepository instance
   */
  public static ImmutableInMemoryAccountRepository copyOf(InMemoryAccountRepository instance) {
    if (instance instanceof ImmutableInMemoryAccountRepository) {
      return (ImmutableInMemoryAccountRepository) instance;
    }
    return ImmutableInMemoryAccountRepository.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableInMemoryAccountRepository ImmutableInMemoryAccountRepository}.
   * <pre>
   * ImmutableInMemoryAccountRepository.builder()
   *    .putAccounts|putAllAccounts(String =&gt; tech.pegasys.net.api.model.Account) // {@link InMemoryAccountRepository#accounts() accounts} mappings
   *    .build();
   * </pre>
   * @return A new ImmutableInMemoryAccountRepository builder
   */
  public static ImmutableInMemoryAccountRepository.Builder builder() {
    return new ImmutableInMemoryAccountRepository.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableInMemoryAccountRepository ImmutableInMemoryAccountRepository}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "InMemoryAccountRepository", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private ImmutableMap.Builder<String, Account> accounts = ImmutableMap.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code InMemoryAccountRepository} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(InMemoryAccountRepository instance) {
      Objects.requireNonNull(instance, "instance");
      putAllAccounts(instance.accounts());
      return this;
    }

    /**
     * Put one entry to the {@link InMemoryAccountRepository#accounts() accounts} map.
     * @param key The key in the accounts map
     * @param value The associated value in the accounts map
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder putAccounts(String key, Account value) {
      this.accounts.put(key, value);
      return this;
    }

    /**
     * Put one entry to the {@link InMemoryAccountRepository#accounts() accounts} map. Nulls are not permitted
     * @param entry The key and value entry
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder putAccounts(Map.Entry<String, ? extends Account> entry) {
      this.accounts.put(entry);
      return this;
    }

    /**
     * Sets or replaces all mappings from the specified map as entries for the {@link InMemoryAccountRepository#accounts() accounts} map. Nulls are not permitted
     * @param entries The entries that will be added to the accounts map
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder accounts(Map<String, ? extends Account> entries) {
      this.accounts = ImmutableMap.builder();
      return putAllAccounts(entries);
    }

    /**
     * Put all mappings from the specified map as entries to {@link InMemoryAccountRepository#accounts() accounts} map. Nulls are not permitted
     * @param entries The entries that will be added to the accounts map
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder putAllAccounts(Map<String, ? extends Account> entries) {
      this.accounts.putAll(entries);
      return this;
    }

    /**
     * Builds a new {@link ImmutableInMemoryAccountRepository ImmutableInMemoryAccountRepository}.
     * @return An immutable instance of InMemoryAccountRepository
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableInMemoryAccountRepository build() {
      return new ImmutableInMemoryAccountRepository(accounts.build());
    }
  }
}
