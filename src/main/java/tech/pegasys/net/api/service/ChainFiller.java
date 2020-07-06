package tech.pegasys.net.api.service;

public interface ChainFiller {

  void fill();

  AccountRepository accountRepository();

  CredentialsRepository credentialsRepository();

  ContractRepository contractRepository();

  LegacyTransactionCreator legacyTransactionCreator();

  EIP1559TransactionCreator eip1559TransactionCreator();

  Reporter reporter();
}
