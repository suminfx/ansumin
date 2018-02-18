package ru.job4j.array;

/**
 * Таблица умножения различного размера
 *
 * @author Andrey Sumin
 * @since 18.02.2018
 */
public class Matrix {
    int[][] multiple(int size) {
        int newSize = size + 1;
        int[][] table = new int[newSize][newSize];
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                if (i == 0) {
                    table[i][j] = (i + 1) * j;
                } else if (j == 0) {
                    table[i][j] = i * (j + 1);
                } else {
                    table[i][j] = i * j;
                }
            }
        }
        return table;
    }
}
