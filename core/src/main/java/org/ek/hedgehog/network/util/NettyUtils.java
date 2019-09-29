package org.ek.hedgehog.network.util;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.epoll.EpollSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.ek.hedgehog.thread.NamedThreadFactory;

import java.util.concurrent.ThreadFactory;

public final class NettyUtils {

    private static ThreadFactory DEFAULT_EVENT_LOOP_THREAD_FACTORY = new NamedThreadFactory("default-event-loop-thread-%d");

    public static EventLoopGroup createEventLoopGroup() {
        return createEventLoopGroup(0);
    }

    public static EventLoopGroup createEventLoopGroup(int nThreads) {
        return createEventLoopGroup(nThreads, DEFAULT_EVENT_LOOP_THREAD_FACTORY);
    }

    public static EventLoopGroup createEventLoopGroup(int nThreads, ThreadFactory threadFactory) {
        return Epoll.isAvailable() ? new EpollEventLoopGroup(nThreads, threadFactory) : new NioEventLoopGroup(nThreads, threadFactory);
    }

    public static Class<? extends SocketChannel> defaultClientSocketChannel() {
        return Epoll.isAvailable() ? EpollSocketChannel.class : NioSocketChannel.class;
    }

    public static Class<? extends ServerSocketChannel> defaultServerSocketChannel() {
        return Epoll.isAvailable() ? EpollServerSocketChannel.class : NioServerSocketChannel.class;
    }

}
