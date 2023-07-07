package xyz.chaobei.tinypool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.chaobei.tinypool.task.Task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author mrc
 */
public class TinyPoolThreadExecutor extends ThreadPoolExecutor {

    private final Logger logger = LoggerFactory.getLogger(TinyPoolThreadExecutor.class);

    protected TinyPoolThreadExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {

        logger.info("TinyPoolThreadExecutor is running a task {}");
        ((Task) r).beforeTask(t);

    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {

        logger.info("TinyPoolThreadExecutor has run a task {}");
        ((Task) r).afterTask(t);

    }

    @Override
    protected void terminated() {
        logger.info("TinyPoolThreadExecutor is terminating.");
    }
}
