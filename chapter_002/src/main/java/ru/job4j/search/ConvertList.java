package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для преобразований массива в лист и обратно.
 *
 * @author Andrey Sumin
 * @since 18.03.2018
 */
public class ConvertList {
    /**
     * Преобразовать двумерный массив в лист.
     *
     * @param array - двумерный массив.
     * @return - ArrayList.
     */
    public List<Integer> toList(int[][] array) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int[] i : array) {
            for (int j : i) {
                result.add(j);
            }
        }
        return result;
    }

    /**
     * Преобразовать Лист в двумерный массив.
     *
     * @param list - исходный Лист.
     * @param rows - кол-во строк.
     * @return - двумерный массив.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cols = list.size() % rows == 0 ? list.size() / rows : (list.size() / rows) + 1;
        int[][] result = new int[rows][cols];
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (index < list.size()) {
                    result[i][j] = list.get(index++);
                }
            }
        }
        return result;
    }
}
