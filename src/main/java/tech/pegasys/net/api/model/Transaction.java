package tech.pegasys.net.api.model;

import java.math.BigDecimal;

public abstract class Transaction {
  public abstract String recipientAddress();

  public abstract BigDecimal value();
}
