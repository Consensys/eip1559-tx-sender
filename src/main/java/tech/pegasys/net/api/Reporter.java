package tech.pegasys.net.api;

public interface Reporter {

  long totalTransactionsSubmitted();

  void incTotalTransactions();

  long totalTransactionsError();

  void incTotalTransactionsError();

  long totalLegacyTransactionsSubmitted();

  void incLegacyTransactions();

  long totalLegacyTransactionsError();

  void incLegacyTransactionsError();

  long totalEIP1559TransactionsSubmitted();

  void incEIP1559Transactions();

  long totalEIP1559TransactionsError();

  void incEIP1559TransactionsError();

  String report();
}
