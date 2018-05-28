package ru.job4j.threads;

public class Work extends Thread {
    private Thread thread;

    public Work(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        thread.start();
    }
}
