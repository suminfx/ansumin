package ru.job4j.array;

import java.util.Arrays;

/**
 * Класс для удаления дубликатов в массиве.
 *
 * @author Andrey Sumin
 * @since 19.02.2018
 */
public class ArrayDuplicate {
    /**
     * Метод удаляет все дубликаты из массива.
     *
     * @param array - Исходный массив.
     * @return - Массив уникальных значений.
     */
    public String[] remove(String[] array) {
        int end = array.length - 1;
        for (int i = 0; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (array[j].equals(array[i])) {
                    String temp = array[end];
                    array[end--] = array[j];
                    array[j] = temp;
                }
            }
        }
        return Arrays.copyOf(array, end + 1);
    }
}
