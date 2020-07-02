package tech.pegasys.net.api;

public interface Reporter {

  long totalTransactionsSubmitted();

  void incTotalTransactions();

  long totalLegacyTransactionsSubmitted();

  void incLegacyTransactions();

  long totalEIP1559TransactionsSubmitted();

  void incEIP1559Transactions();

}
