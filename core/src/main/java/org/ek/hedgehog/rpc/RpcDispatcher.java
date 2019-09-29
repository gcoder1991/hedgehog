package org.ek.hedgehog.rpc;

import org.ek.hedgehog.handler.Dispatcher;
import org.ek.hedgehog.handler.Processor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class RpcDispatcher implements Dispatcher<String> {

    private Map<String, List<Processor>> dispatchers = new ConcurrentHashMap<>();
    private Map<String, LocalProcessor> localDispatcher = new ConcurrentHashMap<>();

    public void registerProcessor(RpcService service, Processor processor) {
        registerProcessor(service.getName(), processor);
    }

    @Override
    public synchronized void registerProcessor(String className, Processor processor) {
        List<Processor> processors = dispatchers.get(className);
        if (processors == null) {
            processors = new ArrayList<>();
            dispatchers.put(className, processors);
        }
        processors.add(processor);

        if (processor instanceof LocalProcessor) {
            localDispatcher.putIfAbsent(className, (LocalProcessor) processor);
        }
    }

    @Override
    public Processor getProcessor(String className) {
        List<Processor> processors = dispatchers.get(className);
        if (processors == null || processors.size() == 0) {
            return null;
        }
        if (processors.size() > 1) {
            LocalProcessor localProcessor = localDispatcher.get(className);
            if (localProcessor != null) {
                return localProcessor;
            } else {
                return processors.get(ThreadLocalRandom.current().nextInt(processors.size()));
            }
        } else {
            return processors.get(0);
        }
    }

    @Override
    public Collection<Processor> getAllProcessor(String className) {
        return dispatchers.get(className);
    }

    @Override
    public synchronized void deregisterProcessor(String className, Processor processor) {
        List<Processor> processors = dispatchers.get(className);
        if (processors != null) {
            processors.remove(processor);
        }
    }

    @Override
    public synchronized void deregisterAllProcessor(String key) {
        dispatchers.remove(key);
    }
}
