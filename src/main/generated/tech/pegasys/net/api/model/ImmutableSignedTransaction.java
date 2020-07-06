package tech.pegasys.net.api.model;

import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link SignedTransaction}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableSignedTransaction.builder()}.
 */
@Generated(from = "SignedTransaction", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class ImmutableSignedTransaction implements SignedTransaction {
  private final byte[] signedMessage;

  private ImmutableSignedTransaction(byte[] signedMessage) {
    this.signedMessage = signedMessage;
  }

  /**
   * @return A cloned {@code signedMessage} array
   */
  @Override
  public byte[] signedMessage() {
    return signedMessage.clone();
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link SignedTransaction#signedMessage() signedMessage}.
   * The array is cloned before being saved as attribute values.
   * @param elements The non-null elements for signedMessage
   * @return A modified copy of {@code this} object
   */
  public final ImmutableSignedTransaction withSignedMessage(byte... elements) {
    byte[] newValue = elements.clone();
    return new ImmutableSignedTransaction(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableSignedTransaction} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableSignedTransaction
        && equalTo((ImmutableSignedTransaction) another);
  }

  private boolean equalTo(ImmutableSignedTransaction another) {
    return Arrays.equals(signedMessage, another.signedMessage);
  }

  /**
   * Computes a hash code from attributes: {@code signedMessage}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + Arrays.hashCode(signedMessage);
    return h;
  }

  /**
   * Prints the immutable value {@code SignedTransaction} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("SignedTransaction")
        .omitNullValues()
        .add("signedMessage", Arrays.toString(signedMessage))
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link SignedTransaction} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable SignedTransaction instance
   */
  public static ImmutableSignedTransaction copyOf(SignedTransaction instance) {
    if (instance instanceof ImmutableSignedTransaction) {
      return (ImmutableSignedTransaction) instance;
    }
    return ImmutableSignedTransaction.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableSignedTransaction ImmutableSignedTransaction}.
   * <pre>
   * ImmutableSignedTransaction.builder()
   *    .signedMessage(byte) // required {@link SignedTransaction#signedMessage() signedMessage}
   *    .build();
   * </pre>
   * @return A new ImmutableSignedTransaction builder
   */
  public static ImmutableSignedTransaction.Builder builder() {
    return new ImmutableSignedTransaction.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableSignedTransaction ImmutableSignedTransaction}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "SignedTransaction", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_SIGNED_MESSAGE = 0x1L;
    private long initBits = 0x1L;

    private @Nullable byte[] signedMessage;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code SignedTransaction} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(SignedTransaction instance) {
      Objects.requireNonNull(instance, "instance");
      signedMessage(instance.signedMessage());
      return this;
    }

    /**
     * Initializes the value for the {@link SignedTransaction#signedMessage() signedMessage} attribute.
     * @param signedMessage The elements for signedMessage
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder signedMessage(byte... signedMessage) {
      this.signedMessage = signedMessage.clone();
      initBits &= ~INIT_BIT_SIGNED_MESSAGE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableSignedTransaction ImmutableSignedTransaction}.
     * @return An immutable instance of SignedTransaction
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableSignedTransaction build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableSignedTransaction(signedMessage);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_SIGNED_MESSAGE) != 0) attributes.add("signedMessage");
      return "Cannot build SignedTransaction, some of required attributes are not set " + attributes;
    }
  }
}
