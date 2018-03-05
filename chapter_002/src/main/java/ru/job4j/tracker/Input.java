package ru.job4j.tracker;

/**
 * Ввод данных для трекера.
 *
 * @author Andrey Sumin
 * @since 05.03.2018
 */
public interface Input {
    String ask(String question);

    int ask(String question, int[] range);
}
