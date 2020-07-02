package tech.pegasys.net.core.report;

import tech.pegasys.net.api.Reporter;

import java.util.concurrent.atomic.AtomicLong;

public class ReporterService implements Reporter {
  private final AtomicLong totalTransactionsSubmitted;
  private final AtomicLong totalLegacyTransactionsSubmitted;
  private final AtomicLong totalEIP1559TransactionsSubmitted;

  public ReporterService() {
    this.totalTransactionsSubmitted = new AtomicLong(0);
    this.totalLegacyTransactionsSubmitted = new AtomicLong(0);
    this.totalEIP1559TransactionsSubmitted = new AtomicLong(0);
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
  public long totalLegacyTransactionsSubmitted() {
    return totalLegacyTransactionsSubmitted.get();
  }

  @Override
  public void incLegacyTransactions() {
    incTotalTransactions();
    totalLegacyTransactionsSubmitted.incrementAndGet();
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
}
