package tech.pegasys.net.api.model;

import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link Account}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableAccount.builder()}.
 */
@Generated(from = "Account", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class ImmutableAccount implements Account {
  private final String address;

  private ImmutableAccount(String address) {
    this.address = address;
  }

  /**
   * @return The value of the {@code address} attribute
   */
  @Override
  public String address() {
    return address;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Account#address() address} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for address
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAccount withAddress(String value) {
    String newValue = Objects.requireNonNull(value, "address");
    if (this.address.equals(newValue)) return this;
    return new ImmutableAccount(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableAccount} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableAccount
        && equalTo((ImmutableAccount) another);
  }

  private boolean equalTo(ImmutableAccount another) {
    return address.equals(another.address);
  }

  /**
   * Computes a hash code from attributes: {@code address}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + address.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Account} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Account")
        .omitNullValues()
        .add("address", address)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link Account} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Account instance
   */
  public static ImmutableAccount copyOf(Account instance) {
    if (instance instanceof ImmutableAccount) {
      return (ImmutableAccount) instance;
    }
    return ImmutableAccount.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableAccount ImmutableAccount}.
   * <pre>
   * ImmutableAccount.builder()
   *    .address(String) // required {@link Account#address() address}
   *    .build();
   * </pre>
   * @return A new ImmutableAccount builder
   */
  public static ImmutableAccount.Builder builder() {
    return new ImmutableAccount.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableAccount ImmutableAccount}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Account", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ADDRESS = 0x1L;
    private long initBits = 0x1L;

    private @Nullable String address;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Account} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(Account instance) {
      Objects.requireNonNull(instance, "instance");
      address(instance.address());
      return this;
    }

    /**
     * Initializes the value for the {@link Account#address() address} attribute.
     * @param address The value for address 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder address(String address) {
      this.address = Objects.requireNonNull(address, "address");
      initBits &= ~INIT_BIT_ADDRESS;
      return this;
    }

    /**
     * Builds a new {@link ImmutableAccount ImmutableAccount}.
     * @return An immutable instance of Account
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableAccount build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableAccount(address);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_ADDRESS) != 0) attributes.add("address");
      return "Cannot build Account, some of required attributes are not set " + attributes;
    }
  }
}
