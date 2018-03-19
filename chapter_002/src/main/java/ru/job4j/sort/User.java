package ru.job4j.sort;

/**
 * Класс пользователь с полями имя и возраст. Реализует Comporable.
 * Сортируется по возрасту в порядке возрастания.
 *
 * @author Andrey Sumin
 * @since 19.03.2018
 */
public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        return o != null ? this.age - o.age : 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
