package org.ek.hedgehog.handler;

import java.util.Collection;

public interface Dispatcher<K> {

    void registerProcessor(K key, Processor processor);

    Processor getProcessor(K key);

    // TODO Processor getProcessorHash

    Collection<Processor> getAllProcessor(K key);

    void deregisterProcessor(K key, Processor processor);

    void deregisterAllProcessor(K key);

}
