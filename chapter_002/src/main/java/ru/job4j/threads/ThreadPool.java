package ru.job4j.threads;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@ThreadSafe
class ThreadPool {
    @GuardedBy("this")
    private BlockingQueue<Runnable> taskQueue = null;
    @GuardedBy("this")
    private final List<PoolThread> threads = new ArrayList<>();
    private boolean isStopped = false;

    public ThreadPool() {
        int size = Runtime.getRuntime().availableProcessors();
        taskQueue = new LinkedBlockingQueue(size);
        for (int i = 0; i < size; i++) {
            threads.add(new PoolThread(taskQueue));
        }
        for (PoolThread thread : threads) {
            thread.start();
        }
    }

    public synchronized void execute(Runnable task) throws Exception {
        if (this.isStopped) {
            throw new IllegalStateException("ThreadPool is stopped");
        }
        this.taskQueue.put(task);
    }

    public synchronized void stop() {
        this.isStopped = true;
        for (PoolThread thread : threads) {
            thread.doStop();
        }
    }
}
