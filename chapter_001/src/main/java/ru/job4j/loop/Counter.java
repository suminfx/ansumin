package ru.job4j.loop;

/**
 * Подсчет суммы.
 *
 * @author Andrey Sumin
 * @since 17.02.2018
 */
public class Counter {
    /**
     * Подсчет суммы четных чисел
     *
     * @param start  - start
     * @param finish - finish
     * @return Сумма четных чисел от start до finish
     */
    public int add(int start, int finish) {
        int result = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        return result;
    }
}
