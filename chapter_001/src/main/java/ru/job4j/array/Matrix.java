package ru.job4j.array;

/**
 * Таблица умножения различного размера
 *
 * @author Andrey Sumin
 * @since 18.02.2018
 */
public class Matrix {
    int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
