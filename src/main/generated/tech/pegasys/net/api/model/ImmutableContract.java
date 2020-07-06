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
 * Immutable implementation of {@link Contract}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableContract.builder()}.
 */
@Generated(from = "Contract", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class ImmutableContract extends Contract {
  private final String code;

  private ImmutableContract(String code) {
    this.code = code;
  }

  /**
   * @return The value of the {@code code} attribute
   */
  @Override
  public String code() {
    return code;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Contract#code() code} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for code
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableContract withCode(String value) {
    String newValue = Objects.requireNonNull(value, "code");
    if (this.code.equals(newValue)) return this;
    return new ImmutableContract(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableContract} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableContract
        && equalTo((ImmutableContract) another);
  }

  private boolean equalTo(ImmutableContract another) {
    return code.equals(another.code);
  }

  /**
   * Computes a hash code from attributes: {@code code}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + code.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Contract} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Contract")
        .omitNullValues()
        .add("code", code)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link Contract} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Contract instance
   */
  public static ImmutableContract copyOf(Contract instance) {
    if (instance instanceof ImmutableContract) {
      return (ImmutableContract) instance;
    }
    return ImmutableContract.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableContract ImmutableContract}.
   * <pre>
   * ImmutableContract.builder()
   *    .code(String) // required {@link Contract#code() code}
   *    .build();
   * </pre>
   * @return A new ImmutableContract builder
   */
  public static ImmutableContract.Builder builder() {
    return new ImmutableContract.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableContract ImmutableContract}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Contract", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_CODE = 0x1L;
    private long initBits = 0x1L;

    private @Nullable String code;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Contract} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(Contract instance) {
      Objects.requireNonNull(instance, "instance");
      code(instance.code());
      return this;
    }

    /**
     * Initializes the value for the {@link Contract#code() code} attribute.
     * @param code The value for code 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder code(String code) {
      this.code = Objects.requireNonNull(code, "code");
      initBits &= ~INIT_BIT_CODE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableContract ImmutableContract}.
     * @return An immutable instance of Contract
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableContract build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableContract(code);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_CODE) != 0) attributes.add("code");
      return "Cannot build Contract, some of required attributes are not set " + attributes;
    }
  }
}
