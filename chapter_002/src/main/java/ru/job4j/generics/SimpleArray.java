package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Параметризированный класс - массив с вспомогательными методами
 * вставки, удаления, редактирования, реализует Iterable.
 *
 * @param <T> - тип данных в массиве.
 * @author Andrey Sumin
 * @since 07.04.2018
 */
public class SimpleArray<T> implements Iterable<T> {
    private T[] array;
    private int index = 0;
    private final float coef = 1.5f;

    public SimpleArray() {
        this.array = (T[]) new Object[10];
    }

    /**
     * Добавить элемент в массив, при достижении конца
     * массива его размер увеличивается в 1.5 раза.
     *
     * @param model - элемент, который нужно добавить.
     */
    public void add(T model) {
        if (index > array.length - 1) {
            T[] temp = (T[]) new Object[(int) (array.length * coef)];
            System.arraycopy(array, 0, temp, 0, array.length);
            this.array = temp;
        }
        this.array[index++] = model;
    }

    /**
     * Отредактировать (заменить) элемент в массиве.
     * Если индекс больше, чем число элементов в массиве
     * (т.е. нужный элемент в массиве отсутствует), то метод ничего не сделает.
     *
     * @param index - индекс элемента, который нужно заменить.
     * @param model - новый элемент.
     */
    public void set(int index, T model) {
        if (index <= this.index) {
            this.array[index] = model;
        }
    }

    /**
     * Удалить элемент из массива.
     *
     * @param index - индекс удаляемого элемента.
     */
    public void delete(int index) {
        if (index <= this.index) {
            System.arraycopy(array, index + 1, array, index, array.length - index - 1);
            array[array.length - 1] = null;
            this.index--;
        }
    }

    /**
     * Получить элемент массива по его индексу.
     * Если такого элемента нет, возвращает null.
     *
     * @param index - индекс искомого элемента.
     * @return - найденный элемент или null, если элемент не найден.
     */
    public T get(int index) {
        T result = null;
        if (index <= this.index) {
            result = this.array[index];
        }
        return result;
    }

    /**
     * Получить текущий размер массива.
     *
     * @return - размер массива.
     */
    public int getSize() {
        return this.index;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int position = 0;

            @Override
            public boolean hasNext() {
                return array[position] != null;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    return array[position++];
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}
