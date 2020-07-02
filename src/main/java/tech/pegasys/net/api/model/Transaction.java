package tech.pegasys.net.api.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class Transaction {

  public abstract BigInteger nonce();

  public abstract String recipientAddress();

  public abstract BigDecimal value();
}
