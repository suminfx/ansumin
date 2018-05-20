package ru.job4j.threads.issues;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserStorageTest {
    private UserStorage users = new UserStorage();

    @Before
    public void initAndFillStorage() {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                users.add(new User(i, i * 100));
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 20; i < 40; i++) {
                users.add(new User(i, i * 100));
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void successTransfer() {
        for (int i = 1; i < 40; i++) {
            assertTrue(users.transfer(i, i - 1, 100));
        }
        System.out.println(users);
    }

    @Test
    public void failedTransfer() {
        assertFalse(users.transfer(15, 16, 1600));
        assertFalse(users.transfer(15, 46, 8000));
        assertTrue(users.transfer(15, 14, 100));
        users.delete(new User(15));
        assertFalse(users.transfer(15, 14, 100));
    }
}
