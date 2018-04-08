package ru.job4j.container;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Ручная рализация ArrayList, коллекция на основе массива.
 * Реализует интерфейс ManualList.
 *
 * @param <E> - тип данных, которые будет хранить лист.
 * @author Andrey Sumin
 * @since 08.04.2018
 */
public class ManualArrayList<E> implements ManualList<E> {
    private E[] array;
    private int index = 0;
    private int modCount = 0;
    private static final float FACTOR = 1.5f;

    public ManualArrayList() {
        array = (E[]) new Object[10];
    }

    @Override
    public void add(E value) {
        if (value != null) {
            modCount++;
            if (index < array.length) {
                E[] newArray = (E[]) new Object[(int) (array.length * FACTOR)];
                System.arraycopy(array, 0, newArray, 0, array.length);
                array = newArray;
            }
            array[index++] = value;
        }
    }

    @Override
    public E get(int index) {
        E result = null;
        if (index >= 0 && index < this.index) {
            result = array[index];
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            int current = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount == modCount) {
                    return array[current] != null;
                } else {
                    throw new ConcurrentModificationException();
                }
            }

            @Override
            public E next() {
                if (hasNext()) {
                    return array[current++];
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}
