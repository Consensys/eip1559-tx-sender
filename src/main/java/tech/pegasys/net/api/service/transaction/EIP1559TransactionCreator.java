package tech.pegasys.net.api.service.transaction;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.web3j.utils.Convert;
import tech.pegasys.net.api.model.EIP1559Transaction;
import tech.pegasys.net.api.model.payload.TransactionPayload;

public interface EIP1559TransactionCreator {

  EIP1559Transaction create(TransactionPayload transactionPayload);

  EIP1559Transaction create(BigInteger nonce, BigInteger gasPremium, BigInteger feeCap);

  default EIP1559Transaction create(BigInteger nonce) {
    return create(
        nonce,
        Convert.Unit.GWEI.getWeiFactor().multiply(BigDecimal.ONE).toBigInteger(),
        new BigInteger("50000000000", 10));
  }
}
