package ru.job4j.array;

/**
 * Класс для поиска перебором.
 *
 * @author Andrey Sumin
 * @since 18.02.2018
 */
public class FindLoop {
    /**
     * Метод поиска в массиве перебором.
     *
     * @param data    - массив, в котором будем искать элемент.
     * @param element - искомый элемент.
     * @return - индекс найденного элемента или -1, если элемент не найден.
     */
    public int indexOf(int[] data, int element) {
        int result = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == element) {
                result = i;
                break;
            }
        }
        return result;
    }
}
