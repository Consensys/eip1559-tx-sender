package tech.pegasys.net.api.model.rpc;

public enum RpcMethodTemplate {
  ETH_GET_BLOCK_BY_NUMBER(
      "{\"jsonrpc\":\"2.0\",\"method\":\"eth_getBlockByNumber\",\"params\":[\"%s\", false], \"id\":1}");

  private final String template;

  RpcMethodTemplate(final String template) {
    this.template = template;
  }

  public String getTemplate() {
    return template;
  }

  public String format(final Object... params) {
    return String.format(getTemplate(), params);
  }
}
