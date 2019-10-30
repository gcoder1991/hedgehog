package org.ek.hedgehog.rpc.util;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.ek.hedgehog.handler.Processor;
import org.ek.hedgehog.rpc.RpcDispatcher;
import org.ek.hedgehog.rpc.RpcService;

public class RpcServiceUtils {

    public static <S extends RpcService> S findService(Class<S> clazz, RpcDispatcher dispatcher) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
            Processor processor = dispatcher.getProcessor(clazz.getName());
            return processor.process(method.getName(), args);
        });
        return (S)enhancer.create();
    }


}
