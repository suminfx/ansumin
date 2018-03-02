package ru.job4j.tracker;

/**
 * Класс для иммитации ввода значений пользователем
 *
 * @author Andrey Sumin
 * @since 02.03.2018
 */
public class StubInput implements Input {
    private String[] value;
    private int position = 0;

    public StubInput(String... value) {
        this.value = value;
    }

    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }
}
