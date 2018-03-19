package ru.job4j.search;

/**
 * Класс для пользователя с полями id, name, city.
 *
 * @author Andrey Sumin
 * @since 19.03.2018
 */
public class User {
    private int id;
    private String name;
    private String city;

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
