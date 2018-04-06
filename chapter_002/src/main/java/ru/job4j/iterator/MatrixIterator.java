package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс - итератор двухмерного массива.
 *
 * @author Andrey Sumin
 * @since 06.04.2018
 */
public class MatrixIterator implements Iterator<Integer> {
    private final int[][] values;
    private int i = 0;
    private int j = -1;

    public MatrixIterator(int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (values.length != 0) {
            result = i < values.length - 1 || j < values[i].length - 1;
        }
        return result;
    }

    @Override
    public Integer next() {
        int result;
        if (this.hasNext()) {
            if (j < values[i].length - 1) {
                result = values[i][++j];
            } else {
                j = 0;
                result = values[++i][j];
            }
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }
}
