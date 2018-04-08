package ru.job4j.generics;

/**
 * Класс - хранитель сущность Role, наследует абстрактный класс хранителей сущностей.
 *
 * @author Andrey Sumin
 * @since 08.04.2018
 */
public class UserStore extends AbstractStore<User> {
    private final SimpleArray<User> users = new SimpleArray<>();

    @Override
    public void add(User model) {
        users.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        return this.replace(users, id, model);
    }

    @Override
    public boolean delete(String id) {
        return this.delete(users, id);
    }

    @Override
    public User findById(String id) {
        return this.findById(users, id);
    }
}
