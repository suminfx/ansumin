package ru.job4j.prof;

public class Diagnose {
    private String name;

    public Diagnose(String name) {
        this.name = name;
    }

    /**
     * Геттер на название болезни.
     *
     * @return - название болезни.
     */
    public String getName() {
        return name;
    }
}
