package org.ek.hedgehog.network;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultConnectionManager implements ConnectionManager {


    private Map<Long, ConnectionPool<Connection>> connectionPoolMap = new ConcurrentHashMap<>();

    public DefaultConnectionManager() {

    }

    public void newPool(String ip, int port) {

    }

    @Override
    public Connection getConnection(long addr) {
        return null;
    }


}
