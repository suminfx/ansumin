package ru.job4j.container;

import java.util.Iterator;

/**
 * Абстрактный класс для простых реализаций Set.
 *
 * @param <T> - тип объектов в коллекции.
 * @author Andrey Sumin
 * @since 15.04.2018
 */
public abstract class SimpleSet<T> implements Iterable<T> {
    private ManualList<T> list;
    private int index = 0;

    public SimpleSet(ManualList<T> list) {
        this.list = list;
    }

    /**
     * Добавляет элемент в множество в том случае, если такого объекта еще нет.
     *
     * @param value - добавляемый объект.
     */
    public void add(T value) {
        if (!this.contains(value)) {
            list.add(value);
            index++;
        }
    }

    /**
     * Приватный метод возвращает true, если передаваемый объект содержится в множестве.
     *
     * @param object - искомый объект.
     * @return - содержится ли объект в множестве.
     */
    private boolean contains(T object) {
        boolean result = false;
        for (T element : list) {
            if (element == object) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Получить размер множества.
     *
     * @return - количество элементов в множестве.
     */
    public int getSize() {
        return this.index;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
