package org.ek.hedgehog.network;

import org.ek.hedgehog.util.AddressUtils;

import java.net.InetSocketAddress;
import java.util.concurrent.CompletableFuture;

public interface Server {

    default long getServerId() {
        InetSocketAddress localAddress = getLocalAddress();
        return AddressUtils.addressToLong(localAddress.getHostString(), localAddress.getPort());
    }

    CompletableFuture<? extends Server> start();

    CompletableFuture<? extends Server> shutdown();

    InetSocketAddress getLocalAddress();

    <S extends Server> S localAddress(InetSocketAddress localAddress);

    TransmissionProtocol transmissionProtocol();

}
