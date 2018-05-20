package ru.job4j.threads.issues;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Класс Count представляет собой потокобезопасный код.
 *
 * @author Andrey Sumin
 * @since 20.05.2018
 */
@ThreadSafe
public class Count {
    @GuardedBy("this")
    private int value;

    /**
     * Увеличить значение на 1
     */
    public synchronized void increment() {
        this.value++;
    }

    public synchronized int get() {
        return this.value;
    }
}
