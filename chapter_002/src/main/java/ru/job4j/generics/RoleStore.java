package ru.job4j.generics;

/**
 * Класс - хранитель сущность Role, наследует абстрактный класс хранителей сущностей.
 *
 * @author Andrey Sumin
 * @since 08.04.2018
 */
public class RoleStore extends AbstractStore<Role> {
    public RoleStore() {
        super(new SimpleArray<>());
    }
}
