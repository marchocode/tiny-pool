package xyz.chaobei.tinypool.task;

/**
 * @author mrc
 */
public abstract class AbstractTask implements Task {

    private long startTime;
    private long endTime;
    private boolean success;
    private Throwable error;

    private final String key;
    private final Runnable runnable;

    protected AbstractTask(String key, Runnable runnable) {
        this.key = key;
        this.runnable = runnable;
    }

    @Override
    public void beforeTask(Thread thread) {
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public String key() {
        return this.key;
    }

    @Override
    public void run() {
        runnable.run();
    }

    @Override
    public void afterTask(Throwable t) {

        this.endTime = System.currentTimeMillis();
        this.error = t;

        if (t == null) {
            this.success = true;
        }

    }

    @Override
    public boolean isSuccess() {
        return this.success;
    }

    @Override
    public Throwable errorStack() {
        return this.error;
    }

    @Override
    public long startTime() {
        return this.startTime;
    }

    @Override
    public long endTime() {
        return this.endTime;
    }

}

