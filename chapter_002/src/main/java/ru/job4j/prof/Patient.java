package ru.job4j.prof;

/**
 * Класс пациент.
 *
 * @author Andrey Sumin
 * @since 26.02.2018
 */
public class Patient {
    private String name;

    public Patient(String name) {
        this.name = name;
    }

    /**
     * Геттер на имя пациента.
     *
     * @return - имя пациента.
     */
    public String getName() {
        return name;
    }
}
