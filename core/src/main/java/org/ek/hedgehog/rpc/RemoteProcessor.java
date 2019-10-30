package org.ek.hedgehog.rpc;

import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.fibers.Suspendable;
import com.google.protobuf.ByteString;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.PooledByteBufAllocator;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import lombok.Data;
import org.ek.hedgehog.core.proto.*;
import org.ek.hedgehog.handler.Processor;
import org.ek.hedgehog.network.Connection;
import org.ek.hedgehog.network.ConnectionManager;
import org.ek.hedgehog.rpc.exception.RpcFailedException;
import org.ek.hedgehog.rpc.exception.RpcSerializeException;
import org.ek.hedgehog.util.AddressUtils;
import org.ek.hedgehog.util.Varint32Utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

public class RemoteProcessor<S extends RpcService> implements Processor {

    private static AtomicLong idGen = new AtomicLong();

    private final long address;

    private ConnectionManager connectionManager;


    private Class<S> clazz;

    private Map<String, RemoteMethodInfo> methodMap = new HashMap<>();

    public RemoteProcessor(String ip, int port, ConnectionManager connectionManager) {
        this(AddressUtils.addressToLong(ip, port), connectionManager);
    }

    public RemoteProcessor(final long address, ConnectionManager connectionManager) {
        this.address = address;
        this.connectionManager = connectionManager;
        this.clazz = (Class<S>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            RemoteMethodInfo methodInfo = new RemoteMethodInfo();
            methodInfo.setMethod(method);
            methodMap.putIfAbsent(method.getName(), methodInfo);
        }
    }

    private long newId() {
        return idGen.getAndIncrement();
    }

    @Suspendable
    private RpcResponse remoteCall(RpcRequest request) throws InterruptedException, ExecutionException, TimeoutException {
        Connection connection = connectionManager.getConnection(address);
        BasicTransform.Builder basic = BasicTransform.newBuilder();
        basic.setType(MessageType.RPC_REQ);
        basic.setContent(request.toByteString());

        CompletableFuture<RpcResponse> future = new CompletableFuture<>();
        RpcContext rpcContext = connection.getRpcContext();
        rpcContext.newRequest(request, future);
        connection.send(basic.build().toByteArray());
        return future.get(5, TimeUnit.SECONDS);
    }


    @Override
    public Object process(String method, Object[] params) throws SuspendExecution {

        RpcRequest.Builder req = RpcRequest.newBuilder();
        req.setRid(newId());
        req.setClassName(clazz.getName());
        req.setMethodName(method);
        RemoteMethodInfo methodInfo = methodMap.get(method);
        Class<?>[] parameterTypes = methodInfo.getMethod().getParameterTypes();

        ByteBuf buf = PooledByteBufAllocator.DEFAULT.buffer();
        Varint32Utils.writeRawVarint32(buf, parameterTypes.length);
        try (ByteBufOutputStream outputStream = new ByteBufOutputStream(buf)) {
            for (int i = 0; i < parameterTypes.length; i++) {
                Schema schema = RuntimeSchema.getSchema(parameterTypes[i]);
                ProtostuffIOUtil.writeDelimitedTo(outputStream, params[i], schema);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        req.setParms(ByteString.copyFrom(buf.array()));

        RpcResponse response = null;

        try {
            response = remoteCall(req.build());
            int ret = response.getRet();
            if (ret == RetCode.OK_VALUE) {
                Class returnType = methodInfo.getMethod().getReturnType();
                if (returnType != Void.class) {
                    Object n = null;
                    try {
                        n = returnType.getConstructor().newInstance();
                        ProtostuffIOUtil.mergeDelimitedFrom(response.getResult().newInput(), n, RuntimeSchema.getSchema(returnType));
                    } catch (InstantiationException | IllegalAccessException | NoSuchMethodException
                            | IOException | InvocationTargetException e) {
                        throw new RpcSerializeException("rpc deserialize fail!", e);
                    }
                    return n;
                } else {
                    return null;
                }
            } else {
                throw new RpcFailedException();
            }
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            // remote error
            throw new RpcFailedException();
        }
    }


    @Data
    class RemoteMethodInfo {
        private Method method;
    }

}
