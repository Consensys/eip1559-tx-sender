package tech.pegasys.net.core.report;

import org.json.JSONObject;
import tech.pegasys.net.api.Reporter;

import java.util.concurrent.atomic.AtomicLong;

public class ReporterService implements Reporter {
  private final AtomicLong totalTransactionsSubmitted;
  private final AtomicLong totalLegacyTransactionsSubmitted;
  private final AtomicLong totalTransactionsError;
  private final AtomicLong totalLegacyTransactionsError;
  private final AtomicLong totalEIP1559TransactionsSubmitted;
  private final AtomicLong totalEIP1559TransactionsError;

  public ReporterService() {
    this.totalTransactionsSubmitted = new AtomicLong(0);
    this.totalLegacyTransactionsSubmitted = new AtomicLong(0);
    this.totalEIP1559TransactionsSubmitted = new AtomicLong(0);
    this.totalLegacyTransactionsError = new AtomicLong(0);
    this.totalEIP1559TransactionsError = new AtomicLong(0);
    this.totalTransactionsError = new AtomicLong(0);
  }

  @Override
  public long totalTransactionsSubmitted() {
    return totalTransactionsSubmitted.get();
  }

  @Override
  public void incTotalTransactions() {
    totalTransactionsSubmitted.incrementAndGet();
  }

  @Override
  public long totalTransactionsError() {
    return totalTransactionsError.get();
  }

  @Override
  public void incTotalTransactionsError() {
    totalTransactionsError.incrementAndGet();
  }

  @Override
  public long totalLegacyTransactionsSubmitted() {
    return totalLegacyTransactionsSubmitted.get();
  }

  @Override
  public void incLegacyTransactions() {
    incTotalTransactions();
    totalLegacyTransactionsSubmitted.incrementAndGet();
  }

  @Override
  public long totalLegacyTransactionsError() {
    return totalLegacyTransactionsError.get();
  }

  @Override
  public void incLegacyTransactionsError() {
    incTotalTransactionsError();
    totalLegacyTransactionsError.incrementAndGet();
  }

  @Override
  public long totalEIP1559TransactionsSubmitted() {
    return totalEIP1559TransactionsSubmitted.get();
  }

  @Override
  public void incEIP1559Transactions() {
    incTotalTransactions();
    totalEIP1559TransactionsSubmitted.incrementAndGet();
  }

  @Override
  public long totalEIP1559TransactionsError() {
    return totalEIP1559TransactionsError.get();
  }

  @Override
  public void incEIP1559TransactionsError() {
    incTotalTransactionsError();
    totalEIP1559TransactionsError.incrementAndGet();
  }

  @Override
  public String report() {
    return new JSONObject()
        .put("totalTransactionsSuccess", totalTransactionsSubmitted())
        .put("totalTransactionsError", totalTransactionsError())
        .put("legacyTransactionsSuccess", totalLegacyTransactionsSubmitted())
        .put("legacyTransactionsError", totalLegacyTransactionsError())
        .put("eip1559TransactionsSuccess", totalEIP1559TransactionsSubmitted())
        .put("eip1559TransactionsError", totalEIP1559TransactionsError())
        .toString();
  }
}
