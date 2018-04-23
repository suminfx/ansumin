package ru.job4j.container.map;

import java.util.Calendar;

/**
 * Класс - пользователь с полями - имя, количество детей, день рождения.
 *
 * @author Andrey Sumin
 * @since 23.04.2018
 */
public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}
