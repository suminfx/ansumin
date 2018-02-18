package ru.job4j.array;

/**
 * Класс для сортировки массива пузырьком.
 *
 * @author Andrey Sumin
 * @since 18.02.2018
 */
public class BubbleSort {
    /**
     * Сортировка пузырьком.
     *
     * @param src - исходный массив.
     * @return - отсортированный массив.
     */
    public int[] sort(int[] src) {
        for (int i = 0; i < src.length; i++) {
            for (int j = 1; j < src.length; j++) {
                if (src[j] < src[j - 1]) {
                    int temp = src[j];
                    src[j] = src[j - 1];
                    src[j - 1] = temp;
                }
            }
        }
        return src;
    }
}
