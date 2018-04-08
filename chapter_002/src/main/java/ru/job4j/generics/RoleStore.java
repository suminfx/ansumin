package ru.job4j.generics;

/**
 * Класс - хранитель сущность Role, наследует абстрактный класс хранителей сущностей.
 *
 * @author Andrey Sumin
 * @since 08.04.2018
 */
public class RoleStore extends AbstractStore<Role> {
    private final SimpleArray<Role> roles = new SimpleArray<>();

    @Override
    public void add(Role model) {
        roles.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return this.replace(roles, id, model);
    }

    @Override
    public boolean delete(String id) {
        return this.delete(roles, id);
    }

    @Override
    public Role findById(String id) {
        return this.findById(roles, id);
    }
}
