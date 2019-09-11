package org.ek.hedgehog.network;

import java.net.InetSocketAddress;
import java.util.concurrent.CompletableFuture;

public interface Client {

    CompletableFuture<? extends Client> connect();

    CompletableFuture<? extends Client> disconnect();

    InetSocketAddress getRemoteAddress();

    <C extends Client> C remoteAddress(InetSocketAddress remoteAddress);

    TransmissionProtocol transmissionProtocol();

}
