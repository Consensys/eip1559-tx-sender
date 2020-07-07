package tech.pegasys.net.api.model.payload;

import com.google.gson.Gson;
import tech.pegasys.net.api.model.TransactionType;

import java.math.BigInteger;

public class TransactionPayload {
  private static final Gson GSON = new Gson().newBuilder().setPrettyPrinting().create();
  private Long nonce;
  private BigInteger value;
  private BigInteger gasPrice;
  private BigInteger gasPremium;
  private BigInteger feeCap;

  public TransactionPayload(final Long nonce, final BigInteger value, final BigInteger gasPrice) {
    this(nonce, value, gasPrice, null, null);
  }

  public TransactionPayload(
      final Long nonce,
      final BigInteger value,
      final BigInteger gasPremium,
      final BigInteger feeCap) {
    this(nonce, value, null, gasPremium, feeCap);
  }

  public TransactionPayload(
      final Long nonce,
      final BigInteger value,
      final BigInteger gasPrice,
      final BigInteger gasPremium,
      final BigInteger feeCap) {
    this.nonce = nonce;
    this.value = value;
    this.gasPrice = gasPrice;
    this.gasPremium = gasPremium;
    this.feeCap = feeCap;
  }

  public static TransactionPayload from(final String json) {
    return GSON.fromJson(json, TransactionPayload.class);
  }

  @Override
  public String toString() {
    return GSON.toJson(this);
  }

  public Long getNonce() {
    return nonce;
  }

  public void setNonce(Long nonce) {
    this.nonce = nonce;
  }

  public BigInteger getValue() {
    return value;
  }

  public void setValue(BigInteger value) {
    this.value = value;
  }

  public BigInteger getGasPrice() {
    return gasPrice;
  }

  public void setGasPrice(BigInteger gasPrice) {
    this.gasPrice = gasPrice;
  }

  public BigInteger getGasPremium() {
    return gasPremium;
  }

  public void setGasPremium(BigInteger gasPremium) {
    this.gasPremium = gasPremium;
  }

  public BigInteger getFeeCap() {
    return feeCap;
  }

  public void setFeeCap(BigInteger feeCap) {
    this.feeCap = feeCap;
  }

  public TransactionType type() {
    return gasPremium != null && feeCap != null ? TransactionType.EIP1559 : TransactionType.LEGACY;
  }

  /*public static void main(final String[] args) {
    final TransactionPayload legacy =
        new TransactionPayload(
            1L,
            Convert.Unit.ETHER.getWeiFactor().multiply(BigDecimal.ONE).toBigInteger(),
            BigInteger.valueOf(21000));
    System.out.println(legacy.toString());

    final TransactionPayload eip1559 =
        new TransactionPayload(
            1L,
            Convert.Unit.ETHER.getWeiFactor().multiply(BigDecimal.ONE).toBigInteger(),
            Convert.Unit.GWEI.getWeiFactor().multiply(BigDecimal.ONE).toBigInteger(),
            Convert.Unit.GWEI.getWeiFactor().multiply(BigDecimal.valueOf(10)).toBigInteger());
    System.out.println(eip1559.toString());
  }*/
}
