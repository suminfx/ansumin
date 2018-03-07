package ru.job4j.array;

/**
 * Даны два отсотрированных по возрастанию массива
 * Создать третий массив, объединяющий оба этих массива,
 * также отсортированный по возрастанию.
 *
 * @author Andrey Sumin
 * @since 07.03.2018
 */
public class SortArray {
    /**
     * Объединить отстортированные массивы в новый отсортированный массив.
     * @param first - первый массив.
     * @param second - второй массив.
     * @return - результирующий массив
     */
    public int[] sort(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        for (int index = 0; index < result.length; index++) {
            if (i == first.length) {
                result[index] = second[j++];
            } else if (j == second.length) {
                result[index] = first[i++];
            } else {
                result[index] = first[i] < second[j] ? first[i++] : second[j++];
            }
        }
        return result;
    }
}
