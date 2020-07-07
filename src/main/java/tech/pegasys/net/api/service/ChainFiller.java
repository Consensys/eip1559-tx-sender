package tech.pegasys.net.api.service;

import tech.pegasys.net.api.repository.AccountRepository;
import tech.pegasys.net.api.repository.ContractRepository;
import tech.pegasys.net.api.repository.CredentialsRepository;
import tech.pegasys.net.api.service.metrics.Reporter;
import tech.pegasys.net.api.service.transaction.EIP1559TransactionCreator;
import tech.pegasys.net.api.service.transaction.LegacyTransactionCreator;

public interface ChainFiller {

  void fill();

  AccountRepository accountRepository();

  CredentialsRepository credentialsRepository();

  ContractRepository contractRepository();

  LegacyTransactionCreator legacyTransactionCreator();

  EIP1559TransactionCreator eip1559TransactionCreator();

  Reporter reporter();
}
