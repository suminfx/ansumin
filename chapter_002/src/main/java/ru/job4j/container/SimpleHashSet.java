package ru.job4j.container;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Ручная реализация упрощенного HashSet.
 *
 * @param <T> - тип хранимых объектов.
 * @author Andrey Sumin
 * @since 17.04.2018
 */
public class SimpleHashSet<T> implements Iterable<T> {
    private T[] array;
    private int capacity = 16;
    private static final float FACTOR = 1.5f;
    private int size = 0;
    private int modCount = 0;

    public SimpleHashSet() {
        this.array = (T[]) new Object[this.capacity];
    }

    public int getSize() {
        return this.size;
    }

    /**
     * Добавить элемент в множество.
     *
     * @param element - новый элемент.
     * @return - успешность операции.
     */
    public boolean add(T element) {
        if (size == capacity) {
            this.capacity = (int) (capacity * FACTOR);
            T[] newArray = (T[]) new Object[this.capacity];
            for (T object : this.array) {
                newArray[hash(object)] = object;
            }
            this.array = newArray;
        }
        int index = hash(element);
        boolean result = false;
        if (this.array[index] == null) {
            this.array[index] = element;
            size++;
            modCount++;
            result = true;
        }
        return result;
    }

    /**
     * Содержит ли множество элемент.
     *
     * @param element - искомый элемент.
     * @return - содержит или нет.
     */
    public boolean contains(T element) {
        int index = this.hash(element);
        return (index >= 0 && index < this.capacity) && this.array[index] != null;
    }

    /**
     * Удалить элемент из множества.
     *
     * @param element - удаляемый элемент.
     * @return - успешность операции.
     */
    public boolean remove(T element) {
        boolean result = contains(element);
        if (result) {
            this.array[hash(element)] = null;
            size--;
            modCount++;
        }
        return result;
    }

    /**
     * Приватный метод для вычисления позиции элемента в массиве на основе хэш-кода элемента.
     *
     * @param key - хэшируемый элемент.
     * @return - индекс элемента в массиве.
     */
    private int hash(T key) {
        int hashCode = Math.abs(key.hashCode());
        return ((hashCode >> 16) ^ hashCode) % this.capacity;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int currentCount = modCount;
            int index = 0;

            @Override
            public boolean hasNext() {
                if (currentCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                boolean result = false;
                for (int i = index; i < capacity; i++) {
                    if (array[i] != null) {
                        result = true;
                        index = i;
                        break;
                    }
                }
                return result;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[index++];
            }
        };
    }
}
