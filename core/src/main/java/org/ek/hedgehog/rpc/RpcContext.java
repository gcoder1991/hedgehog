package org.ek.hedgehog.rpc;

import org.ek.hedgehog.core.proto.RetCode;
import org.ek.hedgehog.core.proto.RpcRequest;
import org.ek.hedgehog.core.proto.RpcResponse;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

public class RpcContext {

    public static final String ATTR_NAME = "RPC-CONTEXT";

    private Map<Long, CompletableFuture> rpcFutures = new ConcurrentHashMap<>();

    public void dealResponse(RpcResponse response) {
        CompletableFuture future = rpcFutures.remove(response.getRid());
        if (future != null) {
            if (response.getRet() != RetCode.OK_VALUE){
                future.completeExceptionally(new RuntimeException("code:" + response.getRet()));
            } else {
                future.complete(response);
            }
        }
    }

    public void newRequest(RpcRequest request, CompletableFuture<RpcResponse> future) {

    }
}
