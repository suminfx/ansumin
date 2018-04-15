package ru.job4j.container;

import java.util.Iterator;

/**
 * Упрощенный Set на основе ArrayList,
 * единственное отличие - не может хранить дубликаты.
 *
 * @param <T> - тип хранимых объектов.
 * @author Andrey Sumin
 * @since 15.04.2018
 */
public class SimpleSet<T> implements Iterable<T> {
    private ManualArrayList<T> list = new ManualArrayList<>();
    private int index = 0;

    public void add(T value) {
        if (!contains(value)) {
            list.add(value);
            index++;
        }
    }

    public int getSize() {
        return this.index;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    private boolean contains(T element) {
        boolean result = false;
        for (T object : list) {
            if (object == element) {
                result = true;
                break;
            }
        }
        return result;
    }
}
