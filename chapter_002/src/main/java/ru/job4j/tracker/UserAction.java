package ru.job4j.tracker;

/**
 * Определяет методы для событий в трекере
 *
 * @author Andrey Sumin
 * @since 05.03.2018
 */
public interface UserAction {
    int key();

    void execute(Input input, Tracker tracker);

    String info();
}
