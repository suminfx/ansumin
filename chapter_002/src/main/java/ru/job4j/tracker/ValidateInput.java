package ru.job4j.tracker;

/**
 * Класс-наследник ConsoleInput,
 * обрабатывает ввод пользователем, не позволяя ввести данные, которых нет в меню.
 *
 * @author Andrey Sumin
 * @since 05.03.2018
 */
public class ValidateInput extends ConsoleInput {
    @Override
    public int ask(String question, int[] range) throws MenuOutException {
        int result = super.ask(question, range);
        boolean valid = false;
        while (!valid) {
            for (int i : range) {
                if (i == result) {
                    valid = true;
                }
            }
            if (!valid) {
                throw new MenuOutException("Please enter one of menu's items.");
            }
        }
        return result;
    }
}
