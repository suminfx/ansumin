package ru.job4j.max;

/**
 * Класс для нахождения максимального числа.
 *
 * @author Andrey Sumin
 * @since 17.02.2018
 */
public class Max {
    /**
     * Метод возвращает максимальное из двух чисел.
     *
     * @param first  - первый аргумент
     * @param second - второй аргумент
     * @return - max
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Метод возвращает максимальное из трех чисел.
     *
     * @param first  - первый аргумент
     * @param second - второй аргумент
     * @param third  - третий аргумент
     * @return max
     */
    public int max(int first, int second, int third) {
        return max(max(first, second), third);
    }
}
