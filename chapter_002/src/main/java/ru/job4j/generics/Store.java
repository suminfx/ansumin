package ru.job4j.generics;

/**
 * Интерфейс для хранителей сущностей.
 *
 * @param <T> - ограничение для сущности (она должны наследовать базовый класс всех сущностей).
 */
public interface Store<T extends Base> {
    /**
     * Добавить элемент.
     *
     * @param model - новый элемент.
     */
    void add(T model);

    /**
     * Заменить элемент.
     *
     * @param id    - id элемента.
     * @param model - новый элемент.
     * @return - успешность оперции.
     */
    boolean replace(String id, T model);

    /**
     * Удалить элемент.
     *
     * @param id - id элемента.
     * @return - успешность операции.
     */
    boolean delete(String id);

    /**
     * Поиск элемента по его id.
     *
     * @param id - id элемента.
     * @return - найденный элемент или null, если элемент не найден.
     */
    T findById(String id);
}
