package tech.pegasys.net.core;

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
import tech.pegasys.net.api.service.ChainFiller;
import tech.pegasys.net.config.ChainFillerConfiguration;

/**
 * Immutable implementation of {@link RxChainFiller}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableRxChainFiller.builder()}.
 */
@Generated(from = "RxChainFiller", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class ImmutableRxChainFiller extends RxChainFiller {
  private final ChainFiller chainFiller;
  private final ChainFillerConfiguration configuration;

  private ImmutableRxChainFiller(
      ChainFiller chainFiller,
      ChainFillerConfiguration configuration) {
    this.chainFiller = chainFiller;
    this.configuration = configuration;
  }

  /**
   * @return The value of the {@code chainFiller} attribute
   */
  @Override
  public ChainFiller chainFiller() {
    return chainFiller;
  }

  /**
   * @return The value of the {@code configuration} attribute
   */
  @Override
  public ChainFillerConfiguration configuration() {
    return configuration;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link RxChainFiller#chainFiller() chainFiller} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for chainFiller
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRxChainFiller withChainFiller(ChainFiller value) {
    if (this.chainFiller == value) return this;
    ChainFiller newValue = Objects.requireNonNull(value, "chainFiller");
    return new ImmutableRxChainFiller(newValue, this.configuration);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link RxChainFiller#configuration() configuration} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for configuration
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRxChainFiller withConfiguration(ChainFillerConfiguration value) {
    if (this.configuration == value) return this;
    ChainFillerConfiguration newValue = Objects.requireNonNull(value, "configuration");
    return new ImmutableRxChainFiller(this.chainFiller, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableRxChainFiller} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableRxChainFiller
        && equalTo((ImmutableRxChainFiller) another);
  }

  private boolean equalTo(ImmutableRxChainFiller another) {
    return chainFiller.equals(another.chainFiller)
        && configuration.equals(another.configuration);
  }

  /**
   * Computes a hash code from attributes: {@code chainFiller}, {@code configuration}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + chainFiller.hashCode();
    h += (h << 5) + configuration.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code RxChainFiller} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("RxChainFiller")
        .omitNullValues()
        .add("chainFiller", chainFiller)
        .add("configuration", configuration)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link RxChainFiller} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable RxChainFiller instance
   */
  public static ImmutableRxChainFiller copyOf(RxChainFiller instance) {
    if (instance instanceof ImmutableRxChainFiller) {
      return (ImmutableRxChainFiller) instance;
    }
    return ImmutableRxChainFiller.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableRxChainFiller ImmutableRxChainFiller}.
   * <pre>
   * ImmutableRxChainFiller.builder()
   *    .chainFiller(tech.pegasys.net.api.service.ChainFiller) // required {@link RxChainFiller#chainFiller() chainFiller}
   *    .configuration(tech.pegasys.net.config.ChainFillerConfiguration) // required {@link RxChainFiller#configuration() configuration}
   *    .build();
   * </pre>
   * @return A new ImmutableRxChainFiller builder
   */
  public static ImmutableRxChainFiller.Builder builder() {
    return new ImmutableRxChainFiller.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableRxChainFiller ImmutableRxChainFiller}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "RxChainFiller", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_CHAIN_FILLER = 0x1L;
    private static final long INIT_BIT_CONFIGURATION = 0x2L;
    private long initBits = 0x3L;

    private @Nullable ChainFiller chainFiller;
    private @Nullable ChainFillerConfiguration configuration;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code RxChainFiller} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(RxChainFiller instance) {
      Objects.requireNonNull(instance, "instance");
      chainFiller(instance.chainFiller());
      configuration(instance.configuration());
      return this;
    }

    /**
     * Initializes the value for the {@link RxChainFiller#chainFiller() chainFiller} attribute.
     * @param chainFiller The value for chainFiller 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder chainFiller(ChainFiller chainFiller) {
      this.chainFiller = Objects.requireNonNull(chainFiller, "chainFiller");
      initBits &= ~INIT_BIT_CHAIN_FILLER;
      return this;
    }

    /**
     * Initializes the value for the {@link RxChainFiller#configuration() configuration} attribute.
     * @param configuration The value for configuration 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder configuration(ChainFillerConfiguration configuration) {
      this.configuration = Objects.requireNonNull(configuration, "configuration");
      initBits &= ~INIT_BIT_CONFIGURATION;
      return this;
    }

    /**
     * Builds a new {@link ImmutableRxChainFiller ImmutableRxChainFiller}.
     * @return An immutable instance of RxChainFiller
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableRxChainFiller build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableRxChainFiller(chainFiller, configuration);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_CHAIN_FILLER) != 0) attributes.add("chainFiller");
      if ((initBits & INIT_BIT_CONFIGURATION) != 0) attributes.add("configuration");
      return "Cannot build RxChainFiller, some of required attributes are not set " + attributes;
    }
  }
}
