package org.ek.hedgehog.rpc;

public interface RpcService {

    default String getName() {
        return this.getClass().getName();
    }

}
