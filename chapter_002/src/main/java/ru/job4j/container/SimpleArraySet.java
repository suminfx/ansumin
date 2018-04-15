package ru.job4j.container;

import java.util.Iterator;

/**
 * Упрощенный Set на основе ArrayList.
 *
 * @param <T> - тип хранимых объектов.
 * @author Andrey Sumin
 * @since 15.04.2018
 */
public class SimpleArraySet<T> extends SimpleSet<T> {
    public SimpleArraySet() {
        super(new ManualArrayList<>());
    }
}
