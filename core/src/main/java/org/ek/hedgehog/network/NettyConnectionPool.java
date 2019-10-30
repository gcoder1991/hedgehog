package org.ek.hedgehog.network;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class NettyConnectionPool extends ConnectionPool<NettyConnection> {

    public NettyConnectionPool(NettyConnectionPoolConfig poolConfig, PooledObjectFactory<NettyConnection> factory) {
        super(poolConfig, new PooledObjectFactory(){

            @Override
            public PooledObject makeObject() throws Exception {
                NettyTcpClient client = new NettyTcpClient(poolConfig.getEventLoopGroup(), poolConfig.getSocketChannel());
                client.setRemoteAddress(poolConfig.getRemoteAddress());
                client.connect().get();
                return new DefaultPooledObject(client);
            }

            @Override
            public void destroyObject(PooledObject p) throws Exception {
                NettyTcpClient client = (NettyTcpClient) p.getObject();
                client.disconnect().get();
            }

            @Override
            public boolean validateObject(PooledObject p) {
                return false;
            }

            @Override
            public void activateObject(PooledObject p) throws Exception {

            }

            @Override
            public void passivateObject(PooledObject p) throws Exception {

            }

        });
    }
}
