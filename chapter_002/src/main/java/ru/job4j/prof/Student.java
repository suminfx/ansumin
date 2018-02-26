package ru.job4j.prof;

/**
 * Класс Студент.
 *
 * @author Andrey Sumin
 * @since 26.02.2018
 */
public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    /**
     * Геттер на имя студента.
     *
     * @return - имя студента.
     */
    public String getName() {
        return name;
    }
}
