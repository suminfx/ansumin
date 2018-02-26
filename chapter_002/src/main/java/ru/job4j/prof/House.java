package ru.job4j.prof;

/**
 * Класс здание.
 *
 * @author Andrey Sumin
 * @since 26.02.2018
 */
public class House {
    private String type;

    public House(String type) {
        this.type = type;
    }

    /**
     * Геттер на тип здания.
     *
     * @return - тип здания.
     */
    public String getType() {
        return type;
    }
}
