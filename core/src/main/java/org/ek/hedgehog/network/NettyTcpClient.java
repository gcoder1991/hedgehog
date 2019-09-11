package org.ek.hedgehog.network;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.ek.hedgehog.util.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.CompletableFuture;

@Getter
@ToString
public class NettyTcpClient implements Client {

    private static final Logger LOG = LoggerFactory.getLogger(NettyTcpClient.class);

    private final Bootstrap bootstrap = new Bootstrap();

    private final EventLoopGroup loopGroup;

    private Channel channel;

    private volatile boolean connected;

    public NettyTcpClient() {
        this(SystemUtils.isLinux() ? new EpollEventLoopGroup(1) : new NioEventLoopGroup(),
                SystemUtils.isLinux() ? EpollSocketChannel.class : NioSocketChannel.class);
    }

    public NettyTcpClient(EventLoopGroup loopGroup, Class<? extends SocketChannel> channelClass) {
        this.loopGroup = loopGroup;
        this.bootstrap.group(loopGroup)
                .channel(channelClass)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
    }

    @Setter
    private InetSocketAddress remoteAddress;

    public <T> NettyTcpClient addOption(ChannelOption<T> childOption, T value) {
        bootstrap.option(childOption, value);
        return this;
    }

    public NettyTcpClient initChannelInitializer(ChannelInitializer<SocketChannel> channelInitializer) {
        bootstrap.handler(channelInitializer);
        return this;
    }

    public NettyTcpClient remoteAddress(InetSocketAddress remoteAddress) {
        this.remoteAddress = remoteAddress;
        return this;
    }

    @Override
    public synchronized CompletableFuture<? extends Client> connect() {
        assert remoteAddress != null;
        if (!connected) {
            CompletableFuture<NettyTcpClient> connectFuture = new CompletableFuture<>();
            bootstrap.remoteAddress(remoteAddress);
            bootstrap.connect().addListener(channelFuture -> {
                if (!channelFuture.isSuccess()) {
                    Throwable cause = channelFuture.cause();
                    LOG.error(String.format("Client : %s Connect Failed.", this), cause);
                    connected = false;
                    connectFuture.completeExceptionally(cause);
                    return;
                }

                channel = ((ChannelFuture) channelFuture).channel();
                connectFuture.complete(this);

                LOG.info(String.format("Client : %s Connected.", this));
            });
            connected = true;
            return connectFuture;
        } else {
            throw new RuntimeException("Client Already Connected!");
        }
    }

    @Override
    public synchronized CompletableFuture<? extends Client> disconnect() {
        if (connected) {
            CompletableFuture<NettyTcpClient> disconnectFuture = new CompletableFuture<>();
            channel.close().addListener(channelFuture -> {
                if (!channelFuture.isSuccess()) {
                    disconnectFuture.completeExceptionally(channelFuture.cause());
                } else {
                    channel = null;
                    connected = false;
                    LOG.info(String.format("Client : %s Disconnected.", this));
                    disconnectFuture.complete(this);
                }
            });
            return disconnectFuture;
        } else {
            throw new RuntimeException("Client Not Started!");
        }
    }

    @Override
    public InetSocketAddress getRemoteAddress() {
        return this.remoteAddress;
    }

    @Override
    public TransmissionProtocol transmissionProtocol() {
        return TransmissionProtocol.TCP;
    }

}
