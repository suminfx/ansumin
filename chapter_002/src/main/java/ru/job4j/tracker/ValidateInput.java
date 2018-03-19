package ru.job4j.tracker;

import java.util.List;

/**
 * Класс-наследник ConsoleInput,
 * обрабатывает ввод пользователем, не позволяя ввести данные, которых нет в меню.
 *
 * @author Andrey Sumin
 * @since 05.03.2018
 */
public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    @Override
    public int ask(String question, List<Integer> range) {
        boolean valid = false;
        int result = -1;
        while (!valid) {
            try {
                result = input.ask(question, range);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Введите корректное значение.");
            } catch (MenuOutException e1) {
                System.out.println(e1.getMessage());
            }
        }
        return result;
    }
}
