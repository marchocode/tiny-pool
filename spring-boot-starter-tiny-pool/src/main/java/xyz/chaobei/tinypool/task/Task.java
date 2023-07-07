package xyz.chaobei.tinypool.task;


public interface Task extends Runnable {

    void beforeTask(Thread thread);

    void afterTask(Throwable t);

    String key();

    long startTime();

    long endTime();

    boolean isSuccess();

    Throwable errorStack();

}
