package org.ek.hedgehog.network;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.ek.hedgehog.network.util.NettyUtils;

import java.net.InetSocketAddress;

public class NettyConnectionPoolConfig extends GenericObjectPoolConfig {

    public static final EventLoopGroup DEFAULT_EVENT_LOOP_GROUP = NettyUtils.createEventLoopGroup();
    public static final Class<? extends SocketChannel> DEFAULT_SOCKET_CHANNEL = NettyUtils.defaultClientSocketChannel();

    private EventLoopGroup eventLoopGroup = DEFAULT_EVENT_LOOP_GROUP;
    private Class<? extends SocketChannel> socketChannel = DEFAULT_SOCKET_CHANNEL;

    private InetSocketAddress remoteAddress;

    public EventLoopGroup getEventLoopGroup() {
        return eventLoopGroup;
    }

    public void setEventLoopGroup(EventLoopGroup eventLoopGroup) {
        this.eventLoopGroup = eventLoopGroup;
    }

    public Class<? extends SocketChannel> getSocketChannel() {
        return socketChannel;
    }

    public void setSocketChannel(Class<? extends SocketChannel> socketChannel) {
        this.socketChannel = socketChannel;
    }

    public InetSocketAddress getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(InetSocketAddress remoteAddress) {
        this.remoteAddress = remoteAddress;
    }
}
