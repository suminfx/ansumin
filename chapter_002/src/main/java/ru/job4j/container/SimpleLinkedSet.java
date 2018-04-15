package ru.job4j.container;

/**
 * Реализация простого Set на основе связного списка.
 *
 * @param <T> - тип объектов в множестве.
 * @author Andrey Sumin
 * @since 15.04.2018
 */
public class SimpleLinkedSet<T> extends SimpleSet<T> {
    public SimpleLinkedSet() {
        super(new ManualLinkedList<>());
    }
}
