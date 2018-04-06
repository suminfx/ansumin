package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] values;

    private int index = -1;

    public EvenNumbersIterator(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return this.hasEvenNumber() != -1;
    }

    @Override
    public Integer next() {
        int result;
        if (this.hasNext()) {
            this.index = hasEvenNumber();
            result = this.values[this.index];
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }

    private int hasEvenNumber() {
        int result = -1;
        for (int i = index + 1; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                result = i;
                break;
            }
        }
        return result;
    }
}
