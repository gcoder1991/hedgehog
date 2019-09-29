package org.ek.hedgehog.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ThreadFactory;

public class NamedThreadFactory implements ThreadFactory {

    private ThreadFactory threadFactory;


    public NamedThreadFactory(String nameFormat) {
        threadFactory = new ThreadFactoryBuilder()
                .setDaemon(true)
                .setPriority(Thread.NORM_PRIORITY)
                .setNameFormat(nameFormat)
                .build();
    }

    @Override
    public Thread newThread(Runnable r) {
        return threadFactory.newThread(r);
    }

}
