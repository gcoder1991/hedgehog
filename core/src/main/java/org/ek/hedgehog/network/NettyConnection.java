package org.ek.hedgehog.network;

import io.netty.channel.Channel;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import org.apache.commons.pool2.PooledObject;
import org.ek.hedgehog.rpc.RpcContext;

import java.net.InetSocketAddress;

public class NettyConnection implements Connection {

    private final Channel channel;

    public NettyConnection(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void connect() {

    }

    @Override
    public void send(byte[] data) {
        channel.writeAndFlush(data);
    }

    @Override
    public RpcContext getRpcContext() {
        AttributeKey<RpcContext> key = AttributeKey.valueOf(RpcContext.ATTR_NAME);
        Attribute<RpcContext> ctxAttr = channel.attr(key);
        return ctxAttr.setIfAbsent(new RpcContext());
    }

    @Override
    public long getAddr() {
        return 0;
    }

    @Override
    public InetSocketAddress getSocketAddr() {
        return null;
    }
}
