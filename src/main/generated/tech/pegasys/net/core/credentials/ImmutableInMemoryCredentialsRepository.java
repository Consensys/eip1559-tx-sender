package tech.pegasys.net.core.credentials;

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
import org.web3j.crypto.Credentials;

/**
 * Immutable implementation of {@link InMemoryCredentialsRepository}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableInMemoryCredentialsRepository.builder()}.
 */
@Generated(from = "InMemoryCredentialsRepository", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class ImmutableInMemoryCredentialsRepository
    extends InMemoryCredentialsRepository {
  private final ImmutableMap<String, Credentials> credentialsStore;

  private ImmutableInMemoryCredentialsRepository(
      ImmutableMap<String, Credentials> credentialsStore) {
    this.credentialsStore = credentialsStore;
  }

  /**
   * @return The value of the {@code credentialsStore} attribute
   */
  @Override
  public ImmutableMap<String, Credentials> credentialsStore() {
    return credentialsStore;
  }

  /**
   * Copy the current immutable object by replacing the {@link InMemoryCredentialsRepository#credentialsStore() credentialsStore} map with the specified map.
   * Nulls are not permitted as keys or values.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param entries The entries to be added to the credentialsStore map
   * @return A modified copy of {@code this} object
   */
  public final ImmutableInMemoryCredentialsRepository withCredentialsStore(Map<String, ? extends Credentials> entries) {
    if (this.credentialsStore == entries) return this;
    ImmutableMap<String, Credentials> newValue = ImmutableMap.copyOf(entries);
    return new ImmutableInMemoryCredentialsRepository(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableInMemoryCredentialsRepository} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableInMemoryCredentialsRepository
        && equalTo((ImmutableInMemoryCredentialsRepository) another);
  }

  private boolean equalTo(ImmutableInMemoryCredentialsRepository another) {
    return credentialsStore.equals(another.credentialsStore);
  }

  /**
   * Computes a hash code from attributes: {@code credentialsStore}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + credentialsStore.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code InMemoryCredentialsRepository} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("InMemoryCredentialsRepository")
        .omitNullValues()
        .add("credentialsStore", credentialsStore)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link InMemoryCredentialsRepository} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable InMemoryCredentialsRepository instance
   */
  public static ImmutableInMemoryCredentialsRepository copyOf(InMemoryCredentialsRepository instance) {
    if (instance instanceof ImmutableInMemoryCredentialsRepository) {
      return (ImmutableInMemoryCredentialsRepository) instance;
    }
    return ImmutableInMemoryCredentialsRepository.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableInMemoryCredentialsRepository ImmutableInMemoryCredentialsRepository}.
   * <pre>
   * ImmutableInMemoryCredentialsRepository.builder()
   *    .putCredentialsStore|putAllCredentialsStore(String =&gt; org.web3j.crypto.Credentials) // {@link InMemoryCredentialsRepository#credentialsStore() credentialsStore} mappings
   *    .build();
   * </pre>
   * @return A new ImmutableInMemoryCredentialsRepository builder
   */
  public static ImmutableInMemoryCredentialsRepository.Builder builder() {
    return new ImmutableInMemoryCredentialsRepository.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableInMemoryCredentialsRepository ImmutableInMemoryCredentialsRepository}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "InMemoryCredentialsRepository", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private ImmutableMap.Builder<String, Credentials> credentialsStore = ImmutableMap.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code InMemoryCredentialsRepository} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(InMemoryCredentialsRepository instance) {
      Objects.requireNonNull(instance, "instance");
      putAllCredentialsStore(instance.credentialsStore());
      return this;
    }

    /**
     * Put one entry to the {@link InMemoryCredentialsRepository#credentialsStore() credentialsStore} map.
     * @param key The key in the credentialsStore map
     * @param value The associated value in the credentialsStore map
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder putCredentialsStore(String key, Credentials value) {
      this.credentialsStore.put(key, value);
      return this;
    }

    /**
     * Put one entry to the {@link InMemoryCredentialsRepository#credentialsStore() credentialsStore} map. Nulls are not permitted
     * @param entry The key and value entry
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder putCredentialsStore(Map.Entry<String, ? extends Credentials> entry) {
      this.credentialsStore.put(entry);
      return this;
    }

    /**
     * Sets or replaces all mappings from the specified map as entries for the {@link InMemoryCredentialsRepository#credentialsStore() credentialsStore} map. Nulls are not permitted
     * @param entries The entries that will be added to the credentialsStore map
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder credentialsStore(Map<String, ? extends Credentials> entries) {
      this.credentialsStore = ImmutableMap.builder();
      return putAllCredentialsStore(entries);
    }

    /**
     * Put all mappings from the specified map as entries to {@link InMemoryCredentialsRepository#credentialsStore() credentialsStore} map. Nulls are not permitted
     * @param entries The entries that will be added to the credentialsStore map
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder putAllCredentialsStore(Map<String, ? extends Credentials> entries) {
      this.credentialsStore.putAll(entries);
      return this;
    }

    /**
     * Builds a new {@link ImmutableInMemoryCredentialsRepository ImmutableInMemoryCredentialsRepository}.
     * @return An immutable instance of InMemoryCredentialsRepository
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableInMemoryCredentialsRepository build() {
      return new ImmutableInMemoryCredentialsRepository(credentialsStore.build());
    }
  }
}
