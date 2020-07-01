package tech.pegasys.net.util;

public class EthereumUtils {

  public static final String censorPrivateKey(final String privateKey) {
    return String.format(
        "%s....%s", privateKey.substring(0, 6), privateKey.substring(privateKey.length() - 4));
  }
}
