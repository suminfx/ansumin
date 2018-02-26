package ru.job4j.prof;

/**
 * Класс Профессия - родительский класс для всех профессий.
 *
 * @author Andrey Sumin
 * @since 26.02.2018
 */
public class Profession {
    private String name;
    private String profession;

    public Profession(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    /**
     * Геттер на имя.
     *
     * @return - имя.
     */
    public String getName() {
        return name;
    }

    /**
     * Геттер на профессию.
     *
     * @return - название профессии.
     */
    public String getProfession() {
        return profession;
    }
}
