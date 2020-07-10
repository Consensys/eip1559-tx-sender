package tech.pegasys.net.api.service;

import tech.pegasys.net.api.model.ActionableAccount;

@FunctionalInterface
public interface ActionableAccountProcessor {

  void processAccount(ActionableAccount actionableAccount);
}
