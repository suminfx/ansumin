package ru.job4j.tracker;

/**
 * Класс Заявки.
 *
 * @author Andrey Sumin
 * @since 26.02.2018
 */
public class Item {
    private String id;
    private String name;
    private String description;

    public Item(String name, String description, String id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    /**
     * Геттер на имя заявки.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Геттер на id
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Установить id.
     *
     * @param id - id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Геттер на description
     * @return description
     */
    public String getDescription() {
        return description;
    }
}
