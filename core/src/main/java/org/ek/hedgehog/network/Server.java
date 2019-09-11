package org.ek.hedgehog.network;

import java.net.InetSocketAddress;
import java.util.concurrent.CompletableFuture;

public interface Server {

    CompletableFuture<? extends Server> start();

    CompletableFuture<? extends Server> shutdown();

    InetSocketAddress getLocalAddress();

    <S extends Server> S localAddress(InetSocketAddress localAddress);

    TransmissionProtocol transmissionProtocol();

}
