package ru.job4j.array;

/**
 * Класс для заполнения массива квадратами чисел.
 *
 * @author Andrey Sumin
 * @since 18.02.2018
 */
public class Square {
    /**
     * Метод заполняет массив квадратами чисел от 1 до bound.
     *
     * @param bound - предел массива
     * @return - заполненный массив
     */
    public int[] calculate(int bound) {
        int[] result = new int[bound];
        for (int i = 1; i <= bound; i++) {
            result[i - 1] = i * i;
        }
        return result;
    }
}
