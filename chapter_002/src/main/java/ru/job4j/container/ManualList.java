package ru.job4j.container;

/**
 * Интерфейс - упрощенный List, для работы с коллекциями, имеет методы add и get.
 *
 * @param <E> - тип данных в коллекции.
 */
public interface ManualList<E> extends Iterable<E> {
    /**
     * Добавить элемент в коллекцию.
     *
     * @param value - новый элемент.
     */
    void add(E value);

    /**
     * Получить элемент по его индексу.
     *
     * @param index - индекс.
     * @return - элемент по его индексу или null, если элемент не найден.
     */
    E get(int index);
}
