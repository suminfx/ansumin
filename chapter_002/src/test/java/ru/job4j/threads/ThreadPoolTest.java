package ru.job4j.threads;

import org.junit.Before;
import org.junit.Test;

public class ThreadPoolTest {
    private ThreadPool pool;
    static int count = 0;

    @Before
    public void initThreadPool() {
        pool = new ThreadPool();
    }

    @Test
    public void inOneMomentShouldNotUsingMoreThanSixThreads() {
        for (int i = 0; i < 20; i++) {
            try {
                pool.execute(() -> {
                    int current = count++;
                    System.out.println(current + " начал выполнение...");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(current + " завершил выполнение.");
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
