package xyz.chaobei.tinypool;

import xyz.chaobei.tinypool.config.TinyPoolProperties;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TinyPoolExecutor {

    private final ThreadPoolExecutor threadPoolExecutor;

    public TinyPoolExecutor(TinyPoolProperties properties) {
        this(properties.getCorePoolSize(), properties.getMaximumPoolSize());
    }

    public TinyPoolExecutor(int corePoolSize, int maximumPoolSize) {
        this.threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
    }

    public void execute(Runnable runnable) {
        threadPoolExecutor.execute(runnable);
    }

    private void setCorePoolSize(int corePoolSize) {

    }

    protected void beforeExecute(Thread t, Runnable r) {

    }

    protected void afterExecute(Runnable r, Throwable t) {

    }
}
