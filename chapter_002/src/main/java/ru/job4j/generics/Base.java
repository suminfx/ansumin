package ru.job4j.generics;

/**
 * Абстрактный класс для сущностей.
 *
 * @author Andrey Sumin
 * @since 08.04.2018
 */
public abstract class Base {
    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
