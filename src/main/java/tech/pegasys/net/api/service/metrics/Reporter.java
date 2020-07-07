package tech.pegasys.net.api.service.metrics;

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

  long totalContractsDeployed();

  long totalContractsDeploymentsError();

  void incTotalContractsDeployed();

  void incTotalContractsDeploymentsError();

  String report();
}
