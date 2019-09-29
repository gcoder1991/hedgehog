package org.ek.hedgehog.rpc;

import co.paralleluniverse.fibers.SuspendExecution;
import org.ek.hedgehog.handler.Processor;
import org.ek.hedgehog.rpc.exception.NoSuchRpcMethodException;
import org.ek.hedgehog.rpc.exception.ServiceInvokeException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class LocalProcessor<S extends RpcService> implements Processor {

    private final S serviceImpl;

    private Map<String, Method> methodMap = new HashMap<>();

    public LocalProcessor(S serviceImpl) {
        this.serviceImpl = serviceImpl;

        Method[] methods = serviceImpl.getClass().getDeclaredMethods();
        for (Method method : methods) {
            methodMap.put(method.getName(), method);
        }
    }

    @Override
    public Object process(String method, Object[] params) throws SuspendExecution {
        Method mthd = methodMap.get(method);
        if (mthd != null) {
            try {
                return mthd.invoke(serviceImpl, params);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new ServiceInvokeException();
            }
        } else {
            throw new NoSuchRpcMethodException(method);
        }
    }
}
