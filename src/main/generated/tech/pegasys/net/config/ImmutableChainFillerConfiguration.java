package tech.pegasys.net.config;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Doubles;
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
 * Immutable implementation of {@link ChainFillerConfiguration}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableChainFillerConfiguration.builder()}.
 */
@Generated(from = "ChainFillerConfiguration", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class ImmutableChainFillerConfiguration
    implements ChainFillerConfiguration {
  private final FillerMode fillerMode;
  private final int numThreads;
  private final int repeatEveryNSeconds;
  private final ImmutableList<String> rpcEndpoints;
  private final ImmutableList<String> accountPrivateKeys;
  private final ImmutableList<String> recipientAddresses;
  private final int numTransactions;
  private final int numSmartContracts;
  private final double eip1559TxWeight;
  private final double fuzzTransferValueLowerBoundEth;
  private final double fuzzTransferValueUpperBoundEth;
  private final String contractDir;
  private final String natsURL;
  private final boolean natsAsyncConnection;
  private final String natsFuzzerTopicTransactions;

  private ImmutableChainFillerConfiguration(
      FillerMode fillerMode,
      int numThreads,
      int repeatEveryNSeconds,
      ImmutableList<String> rpcEndpoints,
      ImmutableList<String> accountPrivateKeys,
      ImmutableList<String> recipientAddresses,
      int numTransactions,
      int numSmartContracts,
      double eip1559TxWeight,
      double fuzzTransferValueLowerBoundEth,
      double fuzzTransferValueUpperBoundEth,
      String contractDir,
      String natsURL,
      boolean natsAsyncConnection,
      String natsFuzzerTopicTransactions) {
    this.fillerMode = fillerMode;
    this.numThreads = numThreads;
    this.repeatEveryNSeconds = repeatEveryNSeconds;
    this.rpcEndpoints = rpcEndpoints;
    this.accountPrivateKeys = accountPrivateKeys;
    this.recipientAddresses = recipientAddresses;
    this.numTransactions = numTransactions;
    this.numSmartContracts = numSmartContracts;
    this.eip1559TxWeight = eip1559TxWeight;
    this.fuzzTransferValueLowerBoundEth = fuzzTransferValueLowerBoundEth;
    this.fuzzTransferValueUpperBoundEth = fuzzTransferValueUpperBoundEth;
    this.contractDir = contractDir;
    this.natsURL = natsURL;
    this.natsAsyncConnection = natsAsyncConnection;
    this.natsFuzzerTopicTransactions = natsFuzzerTopicTransactions;
  }

  /**
   * @return The value of the {@code fillerMode} attribute
   */
  @Override
  public FillerMode fillerMode() {
    return fillerMode;
  }

  /**
   * @return The value of the {@code numThreads} attribute
   */
  @Override
  public int numThreads() {
    return numThreads;
  }

  /**
   * @return The value of the {@code repeatEveryNSeconds} attribute
   */
  @Override
  public int repeatEveryNSeconds() {
    return repeatEveryNSeconds;
  }

  /**
   * @return The value of the {@code rpcEndpoints} attribute
   */
  @Override
  public ImmutableList<String> rpcEndpoints() {
    return rpcEndpoints;
  }

  /**
   * @return The value of the {@code accountPrivateKeys} attribute
   */
  @Override
  public ImmutableList<String> accountPrivateKeys() {
    return accountPrivateKeys;
  }

  /**
   * @return The value of the {@code recipientAddresses} attribute
   */
  @Override
  public ImmutableList<String> recipientAddresses() {
    return recipientAddresses;
  }

  /**
   * @return The value of the {@code numTransactions} attribute
   */
  @Override
  public int numTransactions() {
    return numTransactions;
  }

  /**
   * @return The value of the {@code numSmartContracts} attribute
   */
  @Override
  public int numSmartContracts() {
    return numSmartContracts;
  }

  /**
   * @return The value of the {@code eip1559TxWeight} attribute
   */
  @Override
  public double eip1559TxWeight() {
    return eip1559TxWeight;
  }

  /**
   * @return The value of the {@code fuzzTransferValueLowerBoundEth} attribute
   */
  @Override
  public double fuzzTransferValueLowerBoundEth() {
    return fuzzTransferValueLowerBoundEth;
  }

  /**
   * @return The value of the {@code fuzzTransferValueUpperBoundEth} attribute
   */
  @Override
  public double fuzzTransferValueUpperBoundEth() {
    return fuzzTransferValueUpperBoundEth;
  }

  /**
   * @return The value of the {@code contractDir} attribute
   */
  @Override
  public String contractDir() {
    return contractDir;
  }

  /**
   * @return The value of the {@code natsURL} attribute
   */
  @Override
  public String natsURL() {
    return natsURL;
  }

  /**
   * @return The value of the {@code natsAsyncConnection} attribute
   */
  @Override
  public boolean natsAsyncConnection() {
    return natsAsyncConnection;
  }

  /**
   * @return The value of the {@code natsFuzzerTopicTransactions} attribute
   */
  @Override
  public String natsFuzzerTopicTransactions() {
    return natsFuzzerTopicTransactions;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ChainFillerConfiguration#fillerMode() fillerMode} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for fillerMode
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChainFillerConfiguration withFillerMode(FillerMode value) {
    if (this.fillerMode == value) return this;
    FillerMode newValue = Objects.requireNonNull(value, "fillerMode");
    if (this.fillerMode.equals(newValue)) return this;
    return new ImmutableChainFillerConfiguration(
        newValue,
        this.numThreads,
        this.repeatEveryNSeconds,
        this.rpcEndpoints,
        this.accountPrivateKeys,
        this.recipientAddresses,
        this.numTransactions,
        this.numSmartContracts,
        this.eip1559TxWeight,
        this.fuzzTransferValueLowerBoundEth,
        this.fuzzTransferValueUpperBoundEth,
        this.contractDir,
        this.natsURL,
        this.natsAsyncConnection,
        this.natsFuzzerTopicTransactions);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ChainFillerConfiguration#numThreads() numThreads} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for numThreads
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChainFillerConfiguration withNumThreads(int value) {
    if (this.numThreads == value) return this;
    return new ImmutableChainFillerConfiguration(
        this.fillerMode,
        value,
        this.repeatEveryNSeconds,
        this.rpcEndpoints,
        this.accountPrivateKeys,
        this.recipientAddresses,
        this.numTransactions,
        this.numSmartContracts,
        this.eip1559TxWeight,
        this.fuzzTransferValueLowerBoundEth,
        this.fuzzTransferValueUpperBoundEth,
        this.contractDir,
        this.natsURL,
        this.natsAsyncConnection,
        this.natsFuzzerTopicTransactions);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ChainFillerConfiguration#repeatEveryNSeconds() repeatEveryNSeconds} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for repeatEveryNSeconds
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChainFillerConfiguration withRepeatEveryNSeconds(int value) {
    if (this.repeatEveryNSeconds == value) return this;
    return new ImmutableChainFillerConfiguration(
        this.fillerMode,
        this.numThreads,
        value,
        this.rpcEndpoints,
        this.accountPrivateKeys,
        this.recipientAddresses,
        this.numTransactions,
        this.numSmartContracts,
        this.eip1559TxWeight,
        this.fuzzTransferValueLowerBoundEth,
        this.fuzzTransferValueUpperBoundEth,
        this.contractDir,
        this.natsURL,
        this.natsAsyncConnection,
        this.natsFuzzerTopicTransactions);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ChainFillerConfiguration#rpcEndpoints() rpcEndpoints}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableChainFillerConfiguration withRpcEndpoints(String... elements) {
    ImmutableList<String> newValue = ImmutableList.copyOf(elements);
    return new ImmutableChainFillerConfiguration(
        this.fillerMode,
        this.numThreads,
        this.repeatEveryNSeconds,
        newValue,
        this.accountPrivateKeys,
        this.recipientAddresses,
        this.numTransactions,
        this.numSmartContracts,
        this.eip1559TxWeight,
        this.fuzzTransferValueLowerBoundEth,
        this.fuzzTransferValueUpperBoundEth,
        this.contractDir,
        this.natsURL,
        this.natsAsyncConnection,
        this.natsFuzzerTopicTransactions);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ChainFillerConfiguration#rpcEndpoints() rpcEndpoints}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of rpcEndpoints elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableChainFillerConfiguration withRpcEndpoints(Iterable<String> elements) {
    if (this.rpcEndpoints == elements) return this;
    ImmutableList<String> newValue = ImmutableList.copyOf(elements);
    return new ImmutableChainFillerConfiguration(
        this.fillerMode,
        this.numThreads,
        this.repeatEveryNSeconds,
        newValue,
        this.accountPrivateKeys,
        this.recipientAddresses,
        this.numTransactions,
        this.numSmartContracts,
        this.eip1559TxWeight,
        this.fuzzTransferValueLowerBoundEth,
        this.fuzzTransferValueUpperBoundEth,
        this.contractDir,
        this.natsURL,
        this.natsAsyncConnection,
        this.natsFuzzerTopicTransactions);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ChainFillerConfiguration#accountPrivateKeys() accountPrivateKeys}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableChainFillerConfiguration withAccountPrivateKeys(String... elements) {
    ImmutableList<String> newValue = ImmutableList.copyOf(elements);
    return new ImmutableChainFillerConfiguration(
        this.fillerMode,
        this.numThreads,
        this.repeatEveryNSeconds,
        this.rpcEndpoints,
        newValue,
        this.recipientAddresses,
        this.numTransactions,
        this.numSmartContracts,
        this.eip1559TxWeight,
        this.fuzzTransferValueLowerBoundEth,
        this.fuzzTransferValueUpperBoundEth,
        this.contractDir,
        this.natsURL,
        this.natsAsyncConnection,
        this.natsFuzzerTopicTransactions);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ChainFillerConfiguration#accountPrivateKeys() accountPrivateKeys}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of accountPrivateKeys elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableChainFillerConfiguration withAccountPrivateKeys(Iterable<String> elements) {
    if (this.accountPrivateKeys == elements) return this;
    ImmutableList<String> newValue = ImmutableList.copyOf(elements);
    return new ImmutableChainFillerConfiguration(
        this.fillerMode,
        this.numThreads,
        this.repeatEveryNSeconds,
        this.rpcEndpoints,
        newValue,
        this.recipientAddresses,
        this.numTransactions,
        this.numSmartContracts,
        this.eip1559TxWeight,
        this.fuzzTransferValueLowerBoundEth,
        this.fuzzTransferValueUpperBoundEth,
        this.contractDir,
        this.natsURL,
        this.natsAsyncConnection,
        this.natsFuzzerTopicTransactions);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ChainFillerConfiguration#recipientAddresses() recipientAddresses}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableChainFillerConfiguration withRecipientAddresses(String... elements) {
    ImmutableList<String> newValue = ImmutableList.copyOf(elements);
    return new ImmutableChainFillerConfiguration(
        this.fillerMode,
        this.numThreads,
        this.repeatEveryNSeconds,
        this.rpcEndpoints,
        this.accountPrivateKeys,
        newValue,
        this.numTransactions,
        this.numSmartContracts,
        this.eip1559TxWeight,
        this.fuzzTransferValueLowerBoundEth,
        this.fuzzTransferValueUpperBoundEth,
        this.contractDir,
        this.natsURL,
        this.natsAsyncConnection,
        this.natsFuzzerTopicTransactions);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ChainFillerConfiguration#recipientAddresses() recipientAddresses}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of recipientAddresses elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableChainFillerConfiguration withRecipientAddresses(Iterable<String> elements) {
    if (this.recipientAddresses == elements) return this;
    ImmutableList<String> newValue = ImmutableList.copyOf(elements);
    return new ImmutableChainFillerConfiguration(
        this.fillerMode,
        this.numThreads,
        this.repeatEveryNSeconds,
        this.rpcEndpoints,
        this.accountPrivateKeys,
        newValue,
        this.numTransactions,
        this.numSmartContracts,
        this.eip1559TxWeight,
        this.fuzzTransferValueLowerBoundEth,
        this.fuzzTransferValueUpperBoundEth,
        this.contractDir,
        this.natsURL,
        this.natsAsyncConnection,
        this.natsFuzzerTopicTransactions);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ChainFillerConfiguration#numTransactions() numTransactions} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for numTransactions
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChainFillerConfiguration withNumTransactions(int value) {
    if (this.numTransactions == value) return this;
    return new ImmutableChainFillerConfiguration(
        this.fillerMode,
        this.numThreads,
        this.repeatEveryNSeconds,
        this.rpcEndpoints,
        this.accountPrivateKeys,
        this.recipientAddresses,
        value,
        this.numSmartContracts,
        this.eip1559TxWeight,
        this.fuzzTransferValueLowerBoundEth,
        this.fuzzTransferValueUpperBoundEth,
        this.contractDir,
        this.natsURL,
        this.natsAsyncConnection,
        this.natsFuzzerTopicTransactions);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ChainFillerConfiguration#numSmartContracts() numSmartContracts} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for numSmartContracts
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChainFillerConfiguration withNumSmartContracts(int value) {
    if (this.numSmartContracts == value) return this;
    return new ImmutableChainFillerConfiguration(
        this.fillerMode,
        this.numThreads,
        this.repeatEveryNSeconds,
        this.rpcEndpoints,
        this.accountPrivateKeys,
        this.recipientAddresses,
        this.numTransactions,
        value,
        this.eip1559TxWeight,
        this.fuzzTransferValueLowerBoundEth,
        this.fuzzTransferValueUpperBoundEth,
        this.contractDir,
        this.natsURL,
        this.natsAsyncConnection,
        this.natsFuzzerTopicTransactions);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ChainFillerConfiguration#eip1559TxWeight() eip1559TxWeight} attribute.
   * A value strict bits equality used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for eip1559TxWeight
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChainFillerConfiguration withEip1559TxWeight(double value) {
    if (Double.doubleToLongBits(this.eip1559TxWeight) == Double.doubleToLongBits(value)) return this;
    return new ImmutableChainFillerConfiguration(
        this.fillerMode,
        this.numThreads,
        this.repeatEveryNSeconds,
        this.rpcEndpoints,
        this.accountPrivateKeys,
        this.recipientAddresses,
        this.numTransactions,
        this.numSmartContracts,
        value,
        this.fuzzTransferValueLowerBoundEth,
        this.fuzzTransferValueUpperBoundEth,
        this.contractDir,
        this.natsURL,
        this.natsAsyncConnection,
        this.natsFuzzerTopicTransactions);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ChainFillerConfiguration#fuzzTransferValueLowerBoundEth() fuzzTransferValueLowerBoundEth} attribute.
   * A value strict bits equality used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for fuzzTransferValueLowerBoundEth
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChainFillerConfiguration withFuzzTransferValueLowerBoundEth(double value) {
    if (Double.doubleToLongBits(this.fuzzTransferValueLowerBoundEth) == Double.doubleToLongBits(value)) return this;
    return new ImmutableChainFillerConfiguration(
        this.fillerMode,
        this.numThreads,
        this.repeatEveryNSeconds,
        this.rpcEndpoints,
        this.accountPrivateKeys,
        this.recipientAddresses,
        this.numTransactions,
        this.numSmartContracts,
        this.eip1559TxWeight,
        value,
        this.fuzzTransferValueUpperBoundEth,
        this.contractDir,
        this.natsURL,
        this.natsAsyncConnection,
        this.natsFuzzerTopicTransactions);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ChainFillerConfiguration#fuzzTransferValueUpperBoundEth() fuzzTransferValueUpperBoundEth} attribute.
   * A value strict bits equality used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for fuzzTransferValueUpperBoundEth
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChainFillerConfiguration withFuzzTransferValueUpperBoundEth(double value) {
    if (Double.doubleToLongBits(this.fuzzTransferValueUpperBoundEth) == Double.doubleToLongBits(value)) return this;
    return new ImmutableChainFillerConfiguration(
        this.fillerMode,
        this.numThreads,
        this.repeatEveryNSeconds,
        this.rpcEndpoints,
        this.accountPrivateKeys,
        this.recipientAddresses,
        this.numTransactions,
        this.numSmartContracts,
        this.eip1559TxWeight,
        this.fuzzTransferValueLowerBoundEth,
        value,
        this.contractDir,
        this.natsURL,
        this.natsAsyncConnection,
        this.natsFuzzerTopicTransactions);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ChainFillerConfiguration#contractDir() contractDir} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for contractDir
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChainFillerConfiguration withContractDir(String value) {
    String newValue = Objects.requireNonNull(value, "contractDir");
    if (this.contractDir.equals(newValue)) return this;
    return new ImmutableChainFillerConfiguration(
        this.fillerMode,
        this.numThreads,
        this.repeatEveryNSeconds,
        this.rpcEndpoints,
        this.accountPrivateKeys,
        this.recipientAddresses,
        this.numTransactions,
        this.numSmartContracts,
        this.eip1559TxWeight,
        this.fuzzTransferValueLowerBoundEth,
        this.fuzzTransferValueUpperBoundEth,
        newValue,
        this.natsURL,
        this.natsAsyncConnection,
        this.natsFuzzerTopicTransactions);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ChainFillerConfiguration#natsURL() natsURL} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for natsURL
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChainFillerConfiguration withNatsURL(String value) {
    String newValue = Objects.requireNonNull(value, "natsURL");
    if (this.natsURL.equals(newValue)) return this;
    return new ImmutableChainFillerConfiguration(
        this.fillerMode,
        this.numThreads,
        this.repeatEveryNSeconds,
        this.rpcEndpoints,
        this.accountPrivateKeys,
        this.recipientAddresses,
        this.numTransactions,
        this.numSmartContracts,
        this.eip1559TxWeight,
        this.fuzzTransferValueLowerBoundEth,
        this.fuzzTransferValueUpperBoundEth,
        this.contractDir,
        newValue,
        this.natsAsyncConnection,
        this.natsFuzzerTopicTransactions);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ChainFillerConfiguration#natsAsyncConnection() natsAsyncConnection} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for natsAsyncConnection
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChainFillerConfiguration withNatsAsyncConnection(boolean value) {
    if (this.natsAsyncConnection == value) return this;
    return new ImmutableChainFillerConfiguration(
        this.fillerMode,
        this.numThreads,
        this.repeatEveryNSeconds,
        this.rpcEndpoints,
        this.accountPrivateKeys,
        this.recipientAddresses,
        this.numTransactions,
        this.numSmartContracts,
        this.eip1559TxWeight,
        this.fuzzTransferValueLowerBoundEth,
        this.fuzzTransferValueUpperBoundEth,
        this.contractDir,
        this.natsURL,
        value,
        this.natsFuzzerTopicTransactions);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ChainFillerConfiguration#natsFuzzerTopicTransactions() natsFuzzerTopicTransactions} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for natsFuzzerTopicTransactions
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChainFillerConfiguration withNatsFuzzerTopicTransactions(String value) {
    String newValue = Objects.requireNonNull(value, "natsFuzzerTopicTransactions");
    if (this.natsFuzzerTopicTransactions.equals(newValue)) return this;
    return new ImmutableChainFillerConfiguration(
        this.fillerMode,
        this.numThreads,
        this.repeatEveryNSeconds,
        this.rpcEndpoints,
        this.accountPrivateKeys,
        this.recipientAddresses,
        this.numTransactions,
        this.numSmartContracts,
        this.eip1559TxWeight,
        this.fuzzTransferValueLowerBoundEth,
        this.fuzzTransferValueUpperBoundEth,
        this.contractDir,
        this.natsURL,
        this.natsAsyncConnection,
        newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableChainFillerConfiguration} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableChainFillerConfiguration
        && equalTo((ImmutableChainFillerConfiguration) another);
  }

  private boolean equalTo(ImmutableChainFillerConfiguration another) {
    return fillerMode.equals(another.fillerMode)
        && numThreads == another.numThreads
        && repeatEveryNSeconds == another.repeatEveryNSeconds
        && rpcEndpoints.equals(another.rpcEndpoints)
        && accountPrivateKeys.equals(another.accountPrivateKeys)
        && recipientAddresses.equals(another.recipientAddresses)
        && numTransactions == another.numTransactions
        && numSmartContracts == another.numSmartContracts
        && Double.doubleToLongBits(eip1559TxWeight) == Double.doubleToLongBits(another.eip1559TxWeight)
        && Double.doubleToLongBits(fuzzTransferValueLowerBoundEth) == Double.doubleToLongBits(another.fuzzTransferValueLowerBoundEth)
        && Double.doubleToLongBits(fuzzTransferValueUpperBoundEth) == Double.doubleToLongBits(another.fuzzTransferValueUpperBoundEth)
        && contractDir.equals(another.contractDir)
        && natsURL.equals(another.natsURL)
        && natsAsyncConnection == another.natsAsyncConnection
        && natsFuzzerTopicTransactions.equals(another.natsFuzzerTopicTransactions);
  }

  /**
   * Computes a hash code from attributes: {@code fillerMode}, {@code numThreads}, {@code repeatEveryNSeconds}, {@code rpcEndpoints}, {@code accountPrivateKeys}, {@code recipientAddresses}, {@code numTransactions}, {@code numSmartContracts}, {@code eip1559TxWeight}, {@code fuzzTransferValueLowerBoundEth}, {@code fuzzTransferValueUpperBoundEth}, {@code contractDir}, {@code natsURL}, {@code natsAsyncConnection}, {@code natsFuzzerTopicTransactions}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + fillerMode.hashCode();
    h += (h << 5) + numThreads;
    h += (h << 5) + repeatEveryNSeconds;
    h += (h << 5) + rpcEndpoints.hashCode();
    h += (h << 5) + accountPrivateKeys.hashCode();
    h += (h << 5) + recipientAddresses.hashCode();
    h += (h << 5) + numTransactions;
    h += (h << 5) + numSmartContracts;
    h += (h << 5) + Doubles.hashCode(eip1559TxWeight);
    h += (h << 5) + Doubles.hashCode(fuzzTransferValueLowerBoundEth);
    h += (h << 5) + Doubles.hashCode(fuzzTransferValueUpperBoundEth);
    h += (h << 5) + contractDir.hashCode();
    h += (h << 5) + natsURL.hashCode();
    h += (h << 5) + Booleans.hashCode(natsAsyncConnection);
    h += (h << 5) + natsFuzzerTopicTransactions.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ChainFillerConfiguration} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ChainFillerConfiguration")
        .omitNullValues()
        .add("fillerMode", fillerMode)
        .add("numThreads", numThreads)
        .add("repeatEveryNSeconds", repeatEveryNSeconds)
        .add("rpcEndpoints", rpcEndpoints)
        .add("accountPrivateKeys", accountPrivateKeys)
        .add("recipientAddresses", recipientAddresses)
        .add("numTransactions", numTransactions)
        .add("numSmartContracts", numSmartContracts)
        .add("eip1559TxWeight", eip1559TxWeight)
        .add("fuzzTransferValueLowerBoundEth", fuzzTransferValueLowerBoundEth)
        .add("fuzzTransferValueUpperBoundEth", fuzzTransferValueUpperBoundEth)
        .add("contractDir", contractDir)
        .add("natsURL", natsURL)
        .add("natsAsyncConnection", natsAsyncConnection)
        .add("natsFuzzerTopicTransactions", natsFuzzerTopicTransactions)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link ChainFillerConfiguration} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ChainFillerConfiguration instance
   */
  public static ImmutableChainFillerConfiguration copyOf(ChainFillerConfiguration instance) {
    if (instance instanceof ImmutableChainFillerConfiguration) {
      return (ImmutableChainFillerConfiguration) instance;
    }
    return ImmutableChainFillerConfiguration.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableChainFillerConfiguration ImmutableChainFillerConfiguration}.
   * <pre>
   * ImmutableChainFillerConfiguration.builder()
   *    .fillerMode(tech.pegasys.net.config.FillerMode) // required {@link ChainFillerConfiguration#fillerMode() fillerMode}
   *    .numThreads(int) // required {@link ChainFillerConfiguration#numThreads() numThreads}
   *    .repeatEveryNSeconds(int) // required {@link ChainFillerConfiguration#repeatEveryNSeconds() repeatEveryNSeconds}
   *    .addRpcEndpoints|addAllRpcEndpoints(String) // {@link ChainFillerConfiguration#rpcEndpoints() rpcEndpoints} elements
   *    .addAccountPrivateKeys|addAllAccountPrivateKeys(String) // {@link ChainFillerConfiguration#accountPrivateKeys() accountPrivateKeys} elements
   *    .addRecipientAddresses|addAllRecipientAddresses(String) // {@link ChainFillerConfiguration#recipientAddresses() recipientAddresses} elements
   *    .numTransactions(int) // required {@link ChainFillerConfiguration#numTransactions() numTransactions}
   *    .numSmartContracts(int) // required {@link ChainFillerConfiguration#numSmartContracts() numSmartContracts}
   *    .eip1559TxWeight(double) // required {@link ChainFillerConfiguration#eip1559TxWeight() eip1559TxWeight}
   *    .fuzzTransferValueLowerBoundEth(double) // required {@link ChainFillerConfiguration#fuzzTransferValueLowerBoundEth() fuzzTransferValueLowerBoundEth}
   *    .fuzzTransferValueUpperBoundEth(double) // required {@link ChainFillerConfiguration#fuzzTransferValueUpperBoundEth() fuzzTransferValueUpperBoundEth}
   *    .contractDir(String) // required {@link ChainFillerConfiguration#contractDir() contractDir}
   *    .natsURL(String) // required {@link ChainFillerConfiguration#natsURL() natsURL}
   *    .natsAsyncConnection(boolean) // required {@link ChainFillerConfiguration#natsAsyncConnection() natsAsyncConnection}
   *    .natsFuzzerTopicTransactions(String) // required {@link ChainFillerConfiguration#natsFuzzerTopicTransactions() natsFuzzerTopicTransactions}
   *    .build();
   * </pre>
   * @return A new ImmutableChainFillerConfiguration builder
   */
  public static ImmutableChainFillerConfiguration.Builder builder() {
    return new ImmutableChainFillerConfiguration.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableChainFillerConfiguration ImmutableChainFillerConfiguration}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "ChainFillerConfiguration", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_FILLER_MODE = 0x1L;
    private static final long INIT_BIT_NUM_THREADS = 0x2L;
    private static final long INIT_BIT_REPEAT_EVERY_N_SECONDS = 0x4L;
    private static final long INIT_BIT_NUM_TRANSACTIONS = 0x8L;
    private static final long INIT_BIT_NUM_SMART_CONTRACTS = 0x10L;
    private static final long INIT_BIT_EIP1559_TX_WEIGHT = 0x20L;
    private static final long INIT_BIT_FUZZ_TRANSFER_VALUE_LOWER_BOUND_ETH = 0x40L;
    private static final long INIT_BIT_FUZZ_TRANSFER_VALUE_UPPER_BOUND_ETH = 0x80L;
    private static final long INIT_BIT_CONTRACT_DIR = 0x100L;
    private static final long INIT_BIT_NATS_U_R_L = 0x200L;
    private static final long INIT_BIT_NATS_ASYNC_CONNECTION = 0x400L;
    private static final long INIT_BIT_NATS_FUZZER_TOPIC_TRANSACTIONS = 0x800L;
    private long initBits = 0xfffL;

    private @Nullable FillerMode fillerMode;
    private int numThreads;
    private int repeatEveryNSeconds;
    private ImmutableList.Builder<String> rpcEndpoints = ImmutableList.builder();
    private ImmutableList.Builder<String> accountPrivateKeys = ImmutableList.builder();
    private ImmutableList.Builder<String> recipientAddresses = ImmutableList.builder();
    private int numTransactions;
    private int numSmartContracts;
    private double eip1559TxWeight;
    private double fuzzTransferValueLowerBoundEth;
    private double fuzzTransferValueUpperBoundEth;
    private @Nullable String contractDir;
    private @Nullable String natsURL;
    private boolean natsAsyncConnection;
    private @Nullable String natsFuzzerTopicTransactions;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ChainFillerConfiguration} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(ChainFillerConfiguration instance) {
      Objects.requireNonNull(instance, "instance");
      fillerMode(instance.fillerMode());
      numThreads(instance.numThreads());
      repeatEveryNSeconds(instance.repeatEveryNSeconds());
      addAllRpcEndpoints(instance.rpcEndpoints());
      addAllAccountPrivateKeys(instance.accountPrivateKeys());
      addAllRecipientAddresses(instance.recipientAddresses());
      numTransactions(instance.numTransactions());
      numSmartContracts(instance.numSmartContracts());
      eip1559TxWeight(instance.eip1559TxWeight());
      fuzzTransferValueLowerBoundEth(instance.fuzzTransferValueLowerBoundEth());
      fuzzTransferValueUpperBoundEth(instance.fuzzTransferValueUpperBoundEth());
      contractDir(instance.contractDir());
      natsURL(instance.natsURL());
      natsAsyncConnection(instance.natsAsyncConnection());
      natsFuzzerTopicTransactions(instance.natsFuzzerTopicTransactions());
      return this;
    }

    /**
     * Initializes the value for the {@link ChainFillerConfiguration#fillerMode() fillerMode} attribute.
     * @param fillerMode The value for fillerMode 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder fillerMode(FillerMode fillerMode) {
      this.fillerMode = Objects.requireNonNull(fillerMode, "fillerMode");
      initBits &= ~INIT_BIT_FILLER_MODE;
      return this;
    }

    /**
     * Initializes the value for the {@link ChainFillerConfiguration#numThreads() numThreads} attribute.
     * @param numThreads The value for numThreads 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder numThreads(int numThreads) {
      this.numThreads = numThreads;
      initBits &= ~INIT_BIT_NUM_THREADS;
      return this;
    }

    /**
     * Initializes the value for the {@link ChainFillerConfiguration#repeatEveryNSeconds() repeatEveryNSeconds} attribute.
     * @param repeatEveryNSeconds The value for repeatEveryNSeconds 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder repeatEveryNSeconds(int repeatEveryNSeconds) {
      this.repeatEveryNSeconds = repeatEveryNSeconds;
      initBits &= ~INIT_BIT_REPEAT_EVERY_N_SECONDS;
      return this;
    }

    /**
     * Adds one element to {@link ChainFillerConfiguration#rpcEndpoints() rpcEndpoints} list.
     * @param element A rpcEndpoints element
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addRpcEndpoints(String element) {
      this.rpcEndpoints.add(element);
      return this;
    }

    /**
     * Adds elements to {@link ChainFillerConfiguration#rpcEndpoints() rpcEndpoints} list.
     * @param elements An array of rpcEndpoints elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addRpcEndpoints(String... elements) {
      this.rpcEndpoints.add(elements);
      return this;
    }


    /**
     * Sets or replaces all elements for {@link ChainFillerConfiguration#rpcEndpoints() rpcEndpoints} list.
     * @param elements An iterable of rpcEndpoints elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder rpcEndpoints(Iterable<String> elements) {
      this.rpcEndpoints = ImmutableList.builder();
      return addAllRpcEndpoints(elements);
    }

    /**
     * Adds elements to {@link ChainFillerConfiguration#rpcEndpoints() rpcEndpoints} list.
     * @param elements An iterable of rpcEndpoints elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAllRpcEndpoints(Iterable<String> elements) {
      this.rpcEndpoints.addAll(elements);
      return this;
    }

    /**
     * Adds one element to {@link ChainFillerConfiguration#accountPrivateKeys() accountPrivateKeys} list.
     * @param element A accountPrivateKeys element
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAccountPrivateKeys(String element) {
      this.accountPrivateKeys.add(element);
      return this;
    }

    /**
     * Adds elements to {@link ChainFillerConfiguration#accountPrivateKeys() accountPrivateKeys} list.
     * @param elements An array of accountPrivateKeys elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAccountPrivateKeys(String... elements) {
      this.accountPrivateKeys.add(elements);
      return this;
    }


    /**
     * Sets or replaces all elements for {@link ChainFillerConfiguration#accountPrivateKeys() accountPrivateKeys} list.
     * @param elements An iterable of accountPrivateKeys elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder accountPrivateKeys(Iterable<String> elements) {
      this.accountPrivateKeys = ImmutableList.builder();
      return addAllAccountPrivateKeys(elements);
    }

    /**
     * Adds elements to {@link ChainFillerConfiguration#accountPrivateKeys() accountPrivateKeys} list.
     * @param elements An iterable of accountPrivateKeys elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAllAccountPrivateKeys(Iterable<String> elements) {
      this.accountPrivateKeys.addAll(elements);
      return this;
    }

    /**
     * Adds one element to {@link ChainFillerConfiguration#recipientAddresses() recipientAddresses} list.
     * @param element A recipientAddresses element
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addRecipientAddresses(String element) {
      this.recipientAddresses.add(element);
      return this;
    }

    /**
     * Adds elements to {@link ChainFillerConfiguration#recipientAddresses() recipientAddresses} list.
     * @param elements An array of recipientAddresses elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addRecipientAddresses(String... elements) {
      this.recipientAddresses.add(elements);
      return this;
    }


    /**
     * Sets or replaces all elements for {@link ChainFillerConfiguration#recipientAddresses() recipientAddresses} list.
     * @param elements An iterable of recipientAddresses elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder recipientAddresses(Iterable<String> elements) {
      this.recipientAddresses = ImmutableList.builder();
      return addAllRecipientAddresses(elements);
    }

    /**
     * Adds elements to {@link ChainFillerConfiguration#recipientAddresses() recipientAddresses} list.
     * @param elements An iterable of recipientAddresses elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAllRecipientAddresses(Iterable<String> elements) {
      this.recipientAddresses.addAll(elements);
      return this;
    }

    /**
     * Initializes the value for the {@link ChainFillerConfiguration#numTransactions() numTransactions} attribute.
     * @param numTransactions The value for numTransactions 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder numTransactions(int numTransactions) {
      this.numTransactions = numTransactions;
      initBits &= ~INIT_BIT_NUM_TRANSACTIONS;
      return this;
    }

    /**
     * Initializes the value for the {@link ChainFillerConfiguration#numSmartContracts() numSmartContracts} attribute.
     * @param numSmartContracts The value for numSmartContracts 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder numSmartContracts(int numSmartContracts) {
      this.numSmartContracts = numSmartContracts;
      initBits &= ~INIT_BIT_NUM_SMART_CONTRACTS;
      return this;
    }

    /**
     * Initializes the value for the {@link ChainFillerConfiguration#eip1559TxWeight() eip1559TxWeight} attribute.
     * @param eip1559TxWeight The value for eip1559TxWeight 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder eip1559TxWeight(double eip1559TxWeight) {
      this.eip1559TxWeight = eip1559TxWeight;
      initBits &= ~INIT_BIT_EIP1559_TX_WEIGHT;
      return this;
    }

    /**
     * Initializes the value for the {@link ChainFillerConfiguration#fuzzTransferValueLowerBoundEth() fuzzTransferValueLowerBoundEth} attribute.
     * @param fuzzTransferValueLowerBoundEth The value for fuzzTransferValueLowerBoundEth 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder fuzzTransferValueLowerBoundEth(double fuzzTransferValueLowerBoundEth) {
      this.fuzzTransferValueLowerBoundEth = fuzzTransferValueLowerBoundEth;
      initBits &= ~INIT_BIT_FUZZ_TRANSFER_VALUE_LOWER_BOUND_ETH;
      return this;
    }

    /**
     * Initializes the value for the {@link ChainFillerConfiguration#fuzzTransferValueUpperBoundEth() fuzzTransferValueUpperBoundEth} attribute.
     * @param fuzzTransferValueUpperBoundEth The value for fuzzTransferValueUpperBoundEth 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder fuzzTransferValueUpperBoundEth(double fuzzTransferValueUpperBoundEth) {
      this.fuzzTransferValueUpperBoundEth = fuzzTransferValueUpperBoundEth;
      initBits &= ~INIT_BIT_FUZZ_TRANSFER_VALUE_UPPER_BOUND_ETH;
      return this;
    }

    /**
     * Initializes the value for the {@link ChainFillerConfiguration#contractDir() contractDir} attribute.
     * @param contractDir The value for contractDir 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder contractDir(String contractDir) {
      this.contractDir = Objects.requireNonNull(contractDir, "contractDir");
      initBits &= ~INIT_BIT_CONTRACT_DIR;
      return this;
    }

    /**
     * Initializes the value for the {@link ChainFillerConfiguration#natsURL() natsURL} attribute.
     * @param natsURL The value for natsURL 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder natsURL(String natsURL) {
      this.natsURL = Objects.requireNonNull(natsURL, "natsURL");
      initBits &= ~INIT_BIT_NATS_U_R_L;
      return this;
    }

    /**
     * Initializes the value for the {@link ChainFillerConfiguration#natsAsyncConnection() natsAsyncConnection} attribute.
     * @param natsAsyncConnection The value for natsAsyncConnection 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder natsAsyncConnection(boolean natsAsyncConnection) {
      this.natsAsyncConnection = natsAsyncConnection;
      initBits &= ~INIT_BIT_NATS_ASYNC_CONNECTION;
      return this;
    }

    /**
     * Initializes the value for the {@link ChainFillerConfiguration#natsFuzzerTopicTransactions() natsFuzzerTopicTransactions} attribute.
     * @param natsFuzzerTopicTransactions The value for natsFuzzerTopicTransactions 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder natsFuzzerTopicTransactions(String natsFuzzerTopicTransactions) {
      this.natsFuzzerTopicTransactions = Objects.requireNonNull(natsFuzzerTopicTransactions, "natsFuzzerTopicTransactions");
      initBits &= ~INIT_BIT_NATS_FUZZER_TOPIC_TRANSACTIONS;
      return this;
    }

    /**
     * Builds a new {@link ImmutableChainFillerConfiguration ImmutableChainFillerConfiguration}.
     * @return An immutable instance of ChainFillerConfiguration
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableChainFillerConfiguration build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableChainFillerConfiguration(
          fillerMode,
          numThreads,
          repeatEveryNSeconds,
          rpcEndpoints.build(),
          accountPrivateKeys.build(),
          recipientAddresses.build(),
          numTransactions,
          numSmartContracts,
          eip1559TxWeight,
          fuzzTransferValueLowerBoundEth,
          fuzzTransferValueUpperBoundEth,
          contractDir,
          natsURL,
          natsAsyncConnection,
          natsFuzzerTopicTransactions);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_FILLER_MODE) != 0) attributes.add("fillerMode");
      if ((initBits & INIT_BIT_NUM_THREADS) != 0) attributes.add("numThreads");
      if ((initBits & INIT_BIT_REPEAT_EVERY_N_SECONDS) != 0) attributes.add("repeatEveryNSeconds");
      if ((initBits & INIT_BIT_NUM_TRANSACTIONS) != 0) attributes.add("numTransactions");
      if ((initBits & INIT_BIT_NUM_SMART_CONTRACTS) != 0) attributes.add("numSmartContracts");
      if ((initBits & INIT_BIT_EIP1559_TX_WEIGHT) != 0) attributes.add("eip1559TxWeight");
      if ((initBits & INIT_BIT_FUZZ_TRANSFER_VALUE_LOWER_BOUND_ETH) != 0) attributes.add("fuzzTransferValueLowerBoundEth");
      if ((initBits & INIT_BIT_FUZZ_TRANSFER_VALUE_UPPER_BOUND_ETH) != 0) attributes.add("fuzzTransferValueUpperBoundEth");
      if ((initBits & INIT_BIT_CONTRACT_DIR) != 0) attributes.add("contractDir");
      if ((initBits & INIT_BIT_NATS_U_R_L) != 0) attributes.add("natsURL");
      if ((initBits & INIT_BIT_NATS_ASYNC_CONNECTION) != 0) attributes.add("natsAsyncConnection");
      if ((initBits & INIT_BIT_NATS_FUZZER_TOPIC_TRANSACTIONS) != 0) attributes.add("natsFuzzerTopicTransactions");
      return "Cannot build ChainFillerConfiguration, some of required attributes are not set " + attributes;
    }
  }
}
