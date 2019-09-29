package org.ek.hedgehog.handler;

import co.paralleluniverse.fibers.SuspendExecution;

public interface Processor {

    Object process(String method, Object[] params) throws SuspendExecution;

}
