package org.ek.hedgehog.rpc;

import co.paralleluniverse.fibers.SuspendExecution;
import com.google.protobuf.ByteString;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.PooledByteBufAllocator;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import lombok.Data;
import org.ek.hedgehog.core.proto.RpcRequest;
import org.ek.hedgehog.handler.Processor;
import org.ek.hedgehog.util.AddressUtils;
import org.ek.hedgehog.util.Varint32Utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class RemoteProcessor<S extends RpcService> implements Processor {

    private static AtomicLong idGen = new AtomicLong();

    private final long address;

    private Class<S> clazz;

    private Map<String, RemoteMethodInfo> methodMap = new HashMap<>();

    public RemoteProcessor(String ip, int port) {
        this(AddressUtils.addressToLong(ip, port));
    }

    public RemoteProcessor(final long address) {
        this.address = address;
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
        try (ByteBufInputStream inputStream = new ByteBufInputStream(buf)) {
            for (int i = 0; i < parameterTypes.length; i++) {
                LinkedBuffer lb = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
                Schema schema = RuntimeSchema.getSchema(parameterTypes[i]);
                int size = ProtostuffIOUtil.writeTo(lb, params[i], schema);
                Varint32Utils.writeRawVarint32(buf, size);
                ProtostuffIOUtil.mergeFrom(inputStream, params[i], schema);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        req.setParms(ByteString.copyFrom(buf.array()));

        // TODO  FIND CONNECTION AND  CALL THE RPC SERVER


        return null;
    }


    @Data
    class RemoteMethodInfo {
        private Method method;
    }

}
