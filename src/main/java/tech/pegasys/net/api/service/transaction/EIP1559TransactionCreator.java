package tech.pegasys.net.api.service.transaction;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

import org.web3j.utils.Convert;
import tech.pegasys.net.api.model.EIP1559Transaction;
import tech.pegasys.net.api.model.payload.TransactionPayload;

public interface EIP1559TransactionCreator {

  Random random = new Random();

  EIP1559Transaction create(TransactionPayload transactionPayload);

  EIP1559Transaction create(BigInteger nonce, BigInteger gasPremium, BigInteger feeCap);

  default EIP1559Transaction create(BigInteger nonce) {
    return create(
        nonce,
        Convert.Unit.GWEI
            .getWeiFactor()
            .multiply(getRandomNumberUsingNextIntForTip(new BigInteger("200", 10)))
            .toBigInteger(),
        getRandomNumberUsingNextInt(new BigInteger("400000000000", 10)));
  }

  static BigInteger getRandomNumberUsingNextInt(BigInteger max) {
    return new BigInteger(max.bitLength(), new SecureRandom())
        .mod(max)
        .add(new BigInteger("1000000000000000", 10));
  }

  static BigDecimal getRandomNumberUsingNextIntForTip(BigInteger max) {
    return new BigDecimal(
        new BigInteger(max.bitLength(), new SecureRandom()).mod(max).add(new BigInteger("1", 10)));
  }

  public static void main(final String[] args) {
    System.out.println(new BigInteger("50000000000", 10));
    System.out.println(getRandomNumberUsingNextInt(new BigInteger("50000000000", 10)));
  }
}
