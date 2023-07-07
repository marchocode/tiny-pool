package xyz.chaobei.tinypool.task;

public class TinyTask extends AbstractTask {

    public TinyTask(String key, Runnable runnable) {
        super(key, runnable);
    }
}
