package org.spark;

import org.spark.net.SparkTcpTransport;

public class SparkClientConnection {
  private SparkProtocol m_proto;

  private SparkClientConnection(SparkProtocol protocol) {
    m_proto = protocol;
  }

  public static SparkClientConnection createTCPClientConnection(String host, int port) throws SparkException {
    SparkTransport transport = new SparkTcpTransport(host, port);
    return new SparkClientConnection(new SparkProtocol(transport));
  }

  public SparkObject getProxyObject(String objectId) {
    return new SparkObjectImpl(m_proto, objectId);
  }
}
