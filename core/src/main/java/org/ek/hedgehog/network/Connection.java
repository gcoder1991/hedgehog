package org.ek.hedgehog.network;

import org.ek.hedgehog.rpc.RpcContext;

import java.net.InetSocketAddress;

public interface Connection {

    void connect();

    void send(byte[] data);

    RpcContext getRpcContext();

    long getAddr();

    InetSocketAddress getSocketAddr();

}
