package ru.job4j.threads;

import java.util.LinkedList;
import java.util.Queue;

class ThreadPool {
    private Queue<Work> queueOfWork;
    private Work[] workingProcesses = new Work[3];
    private boolean isShutDown = false;
    private boolean wasStart = false;
    private boolean search = false;

    ThreadPool() {
        this.queueOfWork = new LinkedList<>();
    }

    void add(Work work) {
        queueOfWork.offer(work);
        synchronized (this) {
            notifyAll();
        }
        try {
            startWork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void shutDown() {
        this.isShutDown = true;
    }

    private void startWork() throws InterruptedException {
        synchronized (this) {
            while (!isShutDown) {
                while (queueOfWork.isEmpty()) {
                    wait();
                }
                search = true;
                for (int i = 0; i < workingProcesses.length; i++) {
                    if (workingProcesses[i] == null || !workingProcesses[i].isAlive()) {
                        workingProcesses[i] = queueOfWork.poll();
                        workingProcesses[i].start();
                        search = false;
                        break;
                    }
                }
                notifyAll();
            }
        }
    }
}
