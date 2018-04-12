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
    private int rowsIndex = 0;
    private int colsIndex = -1;

    public MatrixIterator(int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return (values.length != 0) && (rowsIndex < values.length - 1 || colsIndex < values[rowsIndex].length - 1);
    }

    @Override
    public Integer next() {
        if (this.hasNext()) {
            return colsIndex < values[rowsIndex].length - 1 ? values[rowsIndex][++colsIndex] : values[++rowsIndex][colsIndex = 0];
        } else {
            throw new NoSuchElementException();
        }
    }
}
