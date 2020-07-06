package tech.pegasys.net.api.model;

import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.math.BigDecimal;
import java.math.BigInteger;
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
 * Immutable implementation of {@link EIP1559Transaction}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableEIP1559Transaction.builder()}.
 */
@Generated(from = "EIP1559Transaction", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class ImmutableEIP1559Transaction extends EIP1559Transaction {
  private final BigInteger nonce;
  private final String recipientAddress;
  private final BigDecimal value;
  private final BigInteger gasPremium;
  private final BigInteger feeCap;

  private ImmutableEIP1559Transaction(
      BigInteger nonce,
      String recipientAddress,
      BigDecimal value,
      BigInteger gasPremium,
      BigInteger feeCap) {
    this.nonce = nonce;
    this.recipientAddress = recipientAddress;
    this.value = value;
    this.gasPremium = gasPremium;
    this.feeCap = feeCap;
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
   * @return The value of the {@code gasPremium} attribute
   */
  @Override
  public BigInteger gasPremium() {
    return gasPremium;
  }

  /**
   * @return The value of the {@code feeCap} attribute
   */
  @Override
  public BigInteger feeCap() {
    return feeCap;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link EIP1559Transaction#nonce() nonce} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for nonce
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEIP1559Transaction withNonce(BigInteger value) {
    BigInteger newValue = Objects.requireNonNull(value, "nonce");
    if (this.nonce.equals(newValue)) return this;
    return new ImmutableEIP1559Transaction(newValue, this.recipientAddress, this.value, this.gasPremium, this.feeCap);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link EIP1559Transaction#recipientAddress() recipientAddress} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for recipientAddress
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEIP1559Transaction withRecipientAddress(String value) {
    String newValue = Objects.requireNonNull(value, "recipientAddress");
    if (this.recipientAddress.equals(newValue)) return this;
    return new ImmutableEIP1559Transaction(this.nonce, newValue, this.value, this.gasPremium, this.feeCap);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link EIP1559Transaction#value() value} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for value
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEIP1559Transaction withValue(BigDecimal value) {
    BigDecimal newValue = Objects.requireNonNull(value, "value");
    if (this.value.equals(newValue)) return this;
    return new ImmutableEIP1559Transaction(this.nonce, this.recipientAddress, newValue, this.gasPremium, this.feeCap);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link EIP1559Transaction#gasPremium() gasPremium} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for gasPremium
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEIP1559Transaction withGasPremium(BigInteger value) {
    BigInteger newValue = Objects.requireNonNull(value, "gasPremium");
    if (this.gasPremium.equals(newValue)) return this;
    return new ImmutableEIP1559Transaction(this.nonce, this.recipientAddress, this.value, newValue, this.feeCap);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link EIP1559Transaction#feeCap() feeCap} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for feeCap
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEIP1559Transaction withFeeCap(BigInteger value) {
    BigInteger newValue = Objects.requireNonNull(value, "feeCap");
    if (this.feeCap.equals(newValue)) return this;
    return new ImmutableEIP1559Transaction(this.nonce, this.recipientAddress, this.value, this.gasPremium, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableEIP1559Transaction} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableEIP1559Transaction
        && equalTo((ImmutableEIP1559Transaction) another);
  }

  private boolean equalTo(ImmutableEIP1559Transaction another) {
    return nonce.equals(another.nonce)
        && recipientAddress.equals(another.recipientAddress)
        && value.equals(another.value)
        && gasPremium.equals(another.gasPremium)
        && feeCap.equals(another.feeCap);
  }

  /**
   * Computes a hash code from attributes: {@code nonce}, {@code recipientAddress}, {@code value}, {@code gasPremium}, {@code feeCap}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + nonce.hashCode();
    h += (h << 5) + recipientAddress.hashCode();
    h += (h << 5) + value.hashCode();
    h += (h << 5) + gasPremium.hashCode();
    h += (h << 5) + feeCap.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code EIP1559Transaction} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("EIP1559Transaction")
        .omitNullValues()
        .add("nonce", nonce)
        .add("recipientAddress", recipientAddress)
        .add("value", value)
        .add("gasPremium", gasPremium)
        .add("feeCap", feeCap)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link EIP1559Transaction} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable EIP1559Transaction instance
   */
  public static ImmutableEIP1559Transaction copyOf(EIP1559Transaction instance) {
    if (instance instanceof ImmutableEIP1559Transaction) {
      return (ImmutableEIP1559Transaction) instance;
    }
    return ImmutableEIP1559Transaction.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableEIP1559Transaction ImmutableEIP1559Transaction}.
   * <pre>
   * ImmutableEIP1559Transaction.builder()
   *    .nonce(java.math.BigInteger) // required {@link EIP1559Transaction#nonce() nonce}
   *    .recipientAddress(String) // required {@link EIP1559Transaction#recipientAddress() recipientAddress}
   *    .value(java.math.BigDecimal) // required {@link EIP1559Transaction#value() value}
   *    .gasPremium(java.math.BigInteger) // required {@link EIP1559Transaction#gasPremium() gasPremium}
   *    .feeCap(java.math.BigInteger) // required {@link EIP1559Transaction#feeCap() feeCap}
   *    .build();
   * </pre>
   * @return A new ImmutableEIP1559Transaction builder
   */
  public static ImmutableEIP1559Transaction.Builder builder() {
    return new ImmutableEIP1559Transaction.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableEIP1559Transaction ImmutableEIP1559Transaction}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "EIP1559Transaction", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_NONCE = 0x1L;
    private static final long INIT_BIT_RECIPIENT_ADDRESS = 0x2L;
    private static final long INIT_BIT_VALUE = 0x4L;
    private static final long INIT_BIT_GAS_PREMIUM = 0x8L;
    private static final long INIT_BIT_FEE_CAP = 0x10L;
    private long initBits = 0x1fL;

    private @Nullable BigInteger nonce;
    private @Nullable String recipientAddress;
    private @Nullable BigDecimal value;
    private @Nullable BigInteger gasPremium;
    private @Nullable BigInteger feeCap;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code tech.pegasys.net.api.model.EIP1559Transaction} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(EIP1559Transaction instance) {
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
      if (object instanceof EIP1559Transaction) {
        EIP1559Transaction instance = (EIP1559Transaction) object;
        feeCap(instance.feeCap());
        gasPremium(instance.gasPremium());
      }
      if (object instanceof Transaction) {
        Transaction instance = (Transaction) object;
        recipientAddress(instance.recipientAddress());
        nonce(instance.nonce());
        value(instance.value());
      }
    }

    /**
     * Initializes the value for the {@link EIP1559Transaction#nonce() nonce} attribute.
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
     * Initializes the value for the {@link EIP1559Transaction#recipientAddress() recipientAddress} attribute.
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
     * Initializes the value for the {@link EIP1559Transaction#value() value} attribute.
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
     * Initializes the value for the {@link EIP1559Transaction#gasPremium() gasPremium} attribute.
     * @param gasPremium The value for gasPremium 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder gasPremium(BigInteger gasPremium) {
      this.gasPremium = Objects.requireNonNull(gasPremium, "gasPremium");
      initBits &= ~INIT_BIT_GAS_PREMIUM;
      return this;
    }

    /**
     * Initializes the value for the {@link EIP1559Transaction#feeCap() feeCap} attribute.
     * @param feeCap The value for feeCap 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder feeCap(BigInteger feeCap) {
      this.feeCap = Objects.requireNonNull(feeCap, "feeCap");
      initBits &= ~INIT_BIT_FEE_CAP;
      return this;
    }

    /**
     * Builds a new {@link ImmutableEIP1559Transaction ImmutableEIP1559Transaction}.
     * @return An immutable instance of EIP1559Transaction
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableEIP1559Transaction build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableEIP1559Transaction(nonce, recipientAddress, value, gasPremium, feeCap);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_NONCE) != 0) attributes.add("nonce");
      if ((initBits & INIT_BIT_RECIPIENT_ADDRESS) != 0) attributes.add("recipientAddress");
      if ((initBits & INIT_BIT_VALUE) != 0) attributes.add("value");
      if ((initBits & INIT_BIT_GAS_PREMIUM) != 0) attributes.add("gasPremium");
      if ((initBits & INIT_BIT_FEE_CAP) != 0) attributes.add("feeCap");
      return "Cannot build EIP1559Transaction, some of required attributes are not set " + attributes;
    }
  }
}
