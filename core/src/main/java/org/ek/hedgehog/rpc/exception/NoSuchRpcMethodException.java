package org.ek.hedgehog.rpc.exception;

public class NoSuchRpcMethodException extends RpcException {

    private String methodName;

    public NoSuchRpcMethodException(String methodName) {
        this.methodName = methodName;
    }
}
