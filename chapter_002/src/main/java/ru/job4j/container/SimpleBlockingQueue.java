package ru.job4j.container;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {
    private int maxSize;

    public SimpleBlockingQueue() {
        this.maxSize = 10;
    }

    public SimpleBlockingQueue(int size) {
        this.maxSize = size;
    }

    @GuardedBy("this")
    private final Queue<T> queue = new LinkedList<>();

    void offer(T value) throws InterruptedException {
        synchronized (this) {
            while (queue.size() == this.maxSize) {
                wait();
            }
            queue.offer(value);
            notifyAll();
        }
    }

    T poll() throws InterruptedException {
        synchronized (this) {
            while (queue.size() == 0) {
                wait();
            }
            notifyAll();
            return queue.poll();
        }
    }

    public synchronized int getSize() {
        return queue.size();
    }
}
