package org.ek.hedgehog.network;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class ConnectionPool<C extends Connection> {

    private final GenericObjectPool<C> pool;

    public ConnectionPool(final GenericObjectPoolConfig poolConfig, PooledObjectFactory<C> factory) {
        pool = new GenericObjectPool<>(factory, poolConfig);
    }


}
