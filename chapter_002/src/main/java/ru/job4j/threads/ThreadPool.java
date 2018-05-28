package ru.job4j.threads;

import java.util.LinkedList;
import java.util.Queue;

class ThreadPool {
    private Queue<Work> queueOfWork;
    private static Work[] workingProcesses = new Work[3];
    private boolean isShutDown = false;
    private boolean wasStart = false;

    ThreadPool() {
        this.queueOfWork = new LinkedList<>();
    }

    void add(Work work) {
        queueOfWork.offer(work);
        if (!wasStart) {
            wasStart = true;
            Thread start = new Thread(new Runnable() {
                @Override
                public void run() {
                    startWork(workingProcesses);
                }
            });
            start.setDaemon(false);
            start.start();
        }
    }

    void shutDown() {
        this.isShutDown = true;
    }

    private void startWork(Work[] workingProcesses) {
        while (!isShutDown) {
            if (!queueOfWork.isEmpty()) {
                for (int i = 0; i < workingProcesses.length; i++) {
                    if (workingProcesses[i] == null || !workingProcesses[i].isAlive()) {
                        workingProcesses[i] = queueOfWork.poll();
                        workingProcesses[i].start();
                        break;
                    }
                }
            }
        }
    }
}
