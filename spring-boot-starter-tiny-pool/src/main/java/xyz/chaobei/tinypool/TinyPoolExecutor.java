package xyz.chaobei.tinypool;

import xyz.chaobei.tinypool.config.TinyPoolProperties;
import xyz.chaobei.tinypool.task.Task;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class TinyPoolExecutor {

    private final ConcurrentHashMap<String, TinyPoolThreadExecutor> pools = new ConcurrentHashMap<>();
    private final String DEFAULT_KEY = "default";
    private final TinyPoolThreadExecutor def;

    public TinyPoolExecutor(TinyPoolProperties properties) {
        this(properties.getCorePoolSize(), properties.getMaximumPoolSize());
    }

    private TinyPoolExecutor(int corePoolSize, int maximumPoolSize) {
        this.def = new TinyPoolThreadExecutor(corePoolSize, maximumPoolSize, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
        this.pools.put(DEFAULT_KEY, this.def);
    }

    public void execute(Task runnable) {
        this.execute(DEFAULT_KEY, runnable);
    }

    public void execute(String key, Task runnable) {
        pools.getOrDefault(key, def).execute(runnable);
    }

    /**
     * get the number of active thread
     *
     * @return
     */
    protected int getActiveCount(String key) {
        return pools.get(key).getActiveCount();
    }

    protected long getTaskCount(String key) {
        return pools.get(key).getTaskCount();
    }

    /**
     * the number of core thread
     *
     * @return
     */
    protected int getCorePoolSize(String key) {
        return pools.get(key).getCorePoolSize();
    }

    /**
     * the number of the largest pool size
     *
     * @return
     */
    protected int getMaximumPoolSize(String key) {
        return pools.get(key).getMaximumPoolSize();
    }

    protected long getCompletedTaskCount(String key) {
        return pools.get(key).getCompletedTaskCount();
    }

    protected long getLargestPoolSize(String key) {
        return pools.get(key).getLargestPoolSize();
    }


}
