package ru.job4j.threads.issues;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class User {
    @GuardedBy("this")
    private final int id;

    @GuardedBy("this")
    private int amount;

    public User(int id) {
        this.id = id;
    }

    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public synchronized int getId() {
        return id;
    }

    synchronized int getAmount() {
        return amount;
    }

    synchronized void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public synchronized boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public synchronized int hashCode() {
        return id;
    }
}
