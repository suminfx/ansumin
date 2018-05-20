package ru.job4j.threads.issues;

/**
 * Класс в котором демонстрируются проблемы многопоточности,
 * в данном случае - Race Condition, переменная a в одном потоке
 * увеличивается на единицу 1000 раз, в другом потоке уменьшается
 * на единицу 1000 раз, в итоге у нас должно получиться 0,
 * но из-за отсутсвия синхронизации доступа всегда получаются различные значения.
 *
 * @author Andrey Sumin
 * @since 15.05.2018
 */
public class Issue {
    private static int a = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Issue.a += 1;
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Issue.a -= 1;
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
        System.out.println(a);
    }
}
