package ru.job4j.loop;

/**
 * Класс для рассчета факториала
 *
 * @author Andrey Sumin
 * @since 17.02.2018
 */
public class Factorial {
    /**
     * Рассчет факториала N!
     *
     * @param n - N
     * @return - факториал
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
