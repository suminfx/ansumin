package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор для простых чисел в массиве.
 *
 * @author Andrey Sumin
 * @since 06.04.2018
 */
public class PrimeIterator implements Iterator<Integer> {
    private final int[] values;
    private int index = -1;

    public PrimeIterator(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return hasPrimeNumber() != -1;
    }

    @Override
    public Integer next() {
        int result;
        if (hasNext()) {
            index = hasPrimeNumber();
            result = values[index];
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }

    /**
     * Приватный метод поиска следующего простого числа в массиве.
     *
     * @return - индекс следующего простого числа.
     */
    private int hasPrimeNumber() {
        int result = -1;
        for (int i = index + 1; i < values.length; i++) {
            if (values[i] <= 1) {
                continue;
            }
            boolean isPrime = true;
            for (int j = 2; j <= values[i] / 2; j++) {
                if (values[i] % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                result = i;
                break;
            }
        }
        return result;
    }
}
