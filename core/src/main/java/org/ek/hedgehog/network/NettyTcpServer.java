package org.ek.hedgehog.network;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.DefaultThreadFactory;
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
public class NettyTcpServer implements Server {

    private static final Logger LOG = LoggerFactory.getLogger(NettyTcpServer.class);

    private InetSocketAddress localAddress;

    private final ServerBootstrap bootstrap = new ServerBootstrap();

    private final EventLoopGroup bossGroup;
    private final EventLoopGroup workerGroup;

    private Channel channel;

    private volatile boolean started;

    public NettyTcpServer() {
        this(SystemUtils.isLinux() ? new EpollEventLoopGroup(1) : new NioEventLoopGroup(1),
                SystemUtils.isLinux() ? new EpollEventLoopGroup() : new NioEventLoopGroup(),
                SystemUtils.isLinux() ? EpollServerSocketChannel.class : NioServerSocketChannel.class);
    }

    public NettyTcpServer(EventLoopGroup bossGroup, EventLoopGroup workerGroup, Class<? extends ServerChannel> channelClass) {
        this.bossGroup = bossGroup;
        this.workerGroup = workerGroup;
        bootstrap.group(bossGroup, workerGroup)
                .channel(channelClass)
                .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childOption(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
    }

    @Override
    public NettyTcpServer localAddress(InetSocketAddress localAddress) {
        this.localAddress = localAddress;
        return this;
    }

    public <T> NettyTcpServer addChildOption(ChannelOption<T> childOption, T value) {
        bootstrap.childOption(childOption, value);
        return this;
    }

    public NettyTcpServer initChannelInitializer(ChannelInitializer<SocketChannel> channelInitializer) {
        bootstrap.childHandler(channelInitializer);
        return this;
    }

    @Override
    public synchronized CompletableFuture<NettyTcpServer> start() {
        assert localAddress != null;
        if (!started) {

            CompletableFuture<NettyTcpServer> startFuture = new CompletableFuture<>();
            bootstrap.bind(getLocalAddress()).addListener(channelFuture -> {
                if (!channelFuture.isSuccess()) {
                    Throwable cause = channelFuture.cause();
                    LOG.error(String.format("Server : %s Startup Failed.", this), cause);
                    started = false;
                    startFuture.completeExceptionally(cause);
                    return;
                }

                channel = ((ChannelFuture) channelFuture).channel();
                startFuture.complete(this);
                LOG.info(String.format("Server : %s Started.", this));
            });
            started = true;
            return startFuture;
        } else {
            throw new RuntimeException("Server Already Started!");
        }
    }

    @Override
    public synchronized CompletableFuture<NettyTcpServer> shutdown() {
        if (started) {
            CompletableFuture<NettyTcpServer> shutdownFuture = new CompletableFuture<>();
            channel.close().addListener(channelFuture -> {
                if (!channelFuture.isSuccess()) {
                    shutdownFuture.completeExceptionally(channelFuture.cause());
                } else {
                    channel = null;
                    started = false;
                    LOG.info(String.format("Server : %s Shutdown.", this));
                    shutdownFuture.complete(this);
                }
            });
            return shutdownFuture;
        } else {
            throw new RuntimeException("Server Not Started!");
        }
    }

    @Override
    public InetSocketAddress getLocalAddress() {
        return localAddress;
    }

    @Override
    public TransmissionProtocol transmissionProtocol() {
        return TransmissionProtocol.TCP;
    }
}
