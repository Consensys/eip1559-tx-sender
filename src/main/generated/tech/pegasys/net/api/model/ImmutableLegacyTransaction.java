package tech.pegasys.net.api.model;

import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link LegacyTransaction}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableLegacyTransaction.builder()}.
 */
@Generated(from = "LegacyTransaction", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class ImmutableLegacyTransaction extends LegacyTransaction {
  private final BigInteger nonce;
  private final String recipientAddress;
  private final BigDecimal value;
  private final BigInteger gasPrice;
  private final @Nullable String bytecode;

  private ImmutableLegacyTransaction(
      BigInteger nonce,
      String recipientAddress,
      BigDecimal value,
      BigInteger gasPrice,
      @Nullable String bytecode) {
    this.nonce = nonce;
    this.recipientAddress = recipientAddress;
    this.value = value;
    this.gasPrice = gasPrice;
    this.bytecode = bytecode;
  }

  /**
   * @return The value of the {@code nonce} attribute
   */
  @Override
  public BigInteger nonce() {
    return nonce;
  }

  /**
   * @return The value of the {@code recipientAddress} attribute
   */
  @Override
  public String recipientAddress() {
    return recipientAddress;
  }

  /**
   * @return The value of the {@code value} attribute
   */
  @Override
  public BigDecimal value() {
    return value;
  }

  /**
   * @return The value of the {@code gasPrice} attribute
   */
  @Override
  public BigInteger gasPrice() {
    return gasPrice;
  }

  /**
   * @return The value of the {@code bytecode} attribute
   */
  @Override
  public Optional<String> bytecode() {
    return Optional.ofNullable(bytecode);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link LegacyTransaction#nonce() nonce} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for nonce
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableLegacyTransaction withNonce(BigInteger value) {
    BigInteger newValue = Objects.requireNonNull(value, "nonce");
    if (this.nonce.equals(newValue)) return this;
    return new ImmutableLegacyTransaction(newValue, this.recipientAddress, this.value, this.gasPrice, this.bytecode);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link LegacyTransaction#recipientAddress() recipientAddress} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for recipientAddress
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableLegacyTransaction withRecipientAddress(String value) {
    String newValue = Objects.requireNonNull(value, "recipientAddress");
    if (this.recipientAddress.equals(newValue)) return this;
    return new ImmutableLegacyTransaction(this.nonce, newValue, this.value, this.gasPrice, this.bytecode);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link LegacyTransaction#value() value} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for value
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableLegacyTransaction withValue(BigDecimal value) {
    BigDecimal newValue = Objects.requireNonNull(value, "value");
    if (this.value.equals(newValue)) return this;
    return new ImmutableLegacyTransaction(this.nonce, this.recipientAddress, newValue, this.gasPrice, this.bytecode);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link LegacyTransaction#gasPrice() gasPrice} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for gasPrice
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableLegacyTransaction withGasPrice(BigInteger value) {
    BigInteger newValue = Objects.requireNonNull(value, "gasPrice");
    if (this.gasPrice.equals(newValue)) return this;
    return new ImmutableLegacyTransaction(this.nonce, this.recipientAddress, this.value, newValue, this.bytecode);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link LegacyTransaction#bytecode() bytecode} attribute.
   * @param value The value for bytecode
   * @return A modified copy of {@code this} object
   */
  public final ImmutableLegacyTransaction withBytecode(String value) {
    @Nullable String newValue = Objects.requireNonNull(value, "bytecode");
    if (Objects.equals(this.bytecode, newValue)) return this;
    return new ImmutableLegacyTransaction(this.nonce, this.recipientAddress, this.value, this.gasPrice, newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link LegacyTransaction#bytecode() bytecode} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for bytecode
   * @return A modified copy of {@code this} object
   */
  public final ImmutableLegacyTransaction withBytecode(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equals(this.bytecode, value)) return this;
    return new ImmutableLegacyTransaction(this.nonce, this.recipientAddress, this.value, this.gasPrice, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableLegacyTransaction} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableLegacyTransaction
        && equalTo((ImmutableLegacyTransaction) another);
  }

  private boolean equalTo(ImmutableLegacyTransaction another) {
    return nonce.equals(another.nonce)
        && recipientAddress.equals(another.recipientAddress)
        && value.equals(another.value)
        && gasPrice.equals(another.gasPrice)
        && Objects.equals(bytecode, another.bytecode);
  }

  /**
   * Computes a hash code from attributes: {@code nonce}, {@code recipientAddress}, {@code value}, {@code gasPrice}, {@code bytecode}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + nonce.hashCode();
    h += (h << 5) + recipientAddress.hashCode();
    h += (h << 5) + value.hashCode();
    h += (h << 5) + gasPrice.hashCode();
    h += (h << 5) + Objects.hashCode(bytecode);
    return h;
  }

  /**
   * Prints the immutable value {@code LegacyTransaction} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("LegacyTransaction")
        .omitNullValues()
        .add("nonce", nonce)
        .add("recipientAddress", recipientAddress)
        .add("value", value)
        .add("gasPrice", gasPrice)
        .add("bytecode", bytecode)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link LegacyTransaction} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable LegacyTransaction instance
   */
  public static ImmutableLegacyTransaction copyOf(LegacyTransaction instance) {
    if (instance instanceof ImmutableLegacyTransaction) {
      return (ImmutableLegacyTransaction) instance;
    }
    return ImmutableLegacyTransaction.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableLegacyTransaction ImmutableLegacyTransaction}.
   * <pre>
   * ImmutableLegacyTransaction.builder()
   *    .nonce(java.math.BigInteger) // required {@link LegacyTransaction#nonce() nonce}
   *    .recipientAddress(String) // required {@link LegacyTransaction#recipientAddress() recipientAddress}
   *    .value(java.math.BigDecimal) // required {@link LegacyTransaction#value() value}
   *    .gasPrice(java.math.BigInteger) // required {@link LegacyTransaction#gasPrice() gasPrice}
   *    .bytecode(String) // optional {@link LegacyTransaction#bytecode() bytecode}
   *    .build();
   * </pre>
   * @return A new ImmutableLegacyTransaction builder
   */
  public static ImmutableLegacyTransaction.Builder builder() {
    return new ImmutableLegacyTransaction.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableLegacyTransaction ImmutableLegacyTransaction}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "LegacyTransaction", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_NONCE = 0x1L;
    private static final long INIT_BIT_RECIPIENT_ADDRESS = 0x2L;
    private static final long INIT_BIT_VALUE = 0x4L;
    private static final long INIT_BIT_GAS_PRICE = 0x8L;
    private long initBits = 0xfL;

    private @Nullable BigInteger nonce;
    private @Nullable String recipientAddress;
    private @Nullable BigDecimal value;
    private @Nullable BigInteger gasPrice;
    private @Nullable String bytecode;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code tech.pegasys.net.api.model.LegacyTransaction} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(LegacyTransaction instance) {
      Objects.requireNonNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    /**
     * Fill a builder with attribute values from the provided {@code tech.pegasys.net.api.model.Transaction} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(Transaction instance) {
      Objects.requireNonNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    private void from(Object object) {
      if (object instanceof LegacyTransaction) {
        LegacyTransaction instance = (LegacyTransaction) object;
        Optional<String> bytecodeOptional = instance.bytecode();
        if (bytecodeOptional.isPresent()) {
          bytecode(bytecodeOptional);
        }
        gasPrice(instance.gasPrice());
      }
      if (object instanceof Transaction) {
        Transaction instance = (Transaction) object;
        recipientAddress(instance.recipientAddress());
        nonce(instance.nonce());
        value(instance.value());
      }
    }

    /**
     * Initializes the value for the {@link LegacyTransaction#nonce() nonce} attribute.
     * @param nonce The value for nonce 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder nonce(BigInteger nonce) {
      this.nonce = Objects.requireNonNull(nonce, "nonce");
      initBits &= ~INIT_BIT_NONCE;
      return this;
    }

    /**
     * Initializes the value for the {@link LegacyTransaction#recipientAddress() recipientAddress} attribute.
     * @param recipientAddress The value for recipientAddress 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder recipientAddress(String recipientAddress) {
      this.recipientAddress = Objects.requireNonNull(recipientAddress, "recipientAddress");
      initBits &= ~INIT_BIT_RECIPIENT_ADDRESS;
      return this;
    }

    /**
     * Initializes the value for the {@link LegacyTransaction#value() value} attribute.
     * @param value The value for value 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder value(BigDecimal value) {
      this.value = Objects.requireNonNull(value, "value");
      initBits &= ~INIT_BIT_VALUE;
      return this;
    }

    /**
     * Initializes the value for the {@link LegacyTransaction#gasPrice() gasPrice} attribute.
     * @param gasPrice The value for gasPrice 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder gasPrice(BigInteger gasPrice) {
      this.gasPrice = Objects.requireNonNull(gasPrice, "gasPrice");
      initBits &= ~INIT_BIT_GAS_PRICE;
      return this;
    }

    /**
     * Initializes the optional value {@link LegacyTransaction#bytecode() bytecode} to bytecode.
     * @param bytecode The value for bytecode
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder bytecode(String bytecode) {
      this.bytecode = Objects.requireNonNull(bytecode, "bytecode");
      return this;
    }

    /**
     * Initializes the optional value {@link LegacyTransaction#bytecode() bytecode} to bytecode.
     * @param bytecode The value for bytecode
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder bytecode(Optional<String> bytecode) {
      this.bytecode = bytecode.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ImmutableLegacyTransaction ImmutableLegacyTransaction}.
     * @return An immutable instance of LegacyTransaction
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableLegacyTransaction build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableLegacyTransaction(nonce, recipientAddress, value, gasPrice, bytecode);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_NONCE) != 0) attributes.add("nonce");
      if ((initBits & INIT_BIT_RECIPIENT_ADDRESS) != 0) attributes.add("recipientAddress");
      if ((initBits & INIT_BIT_VALUE) != 0) attributes.add("value");
      if ((initBits & INIT_BIT_GAS_PRICE) != 0) attributes.add("gasPrice");
      return "Cannot build LegacyTransaction, some of required attributes are not set " + attributes;
    }
  }
}
