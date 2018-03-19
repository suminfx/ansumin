package ru.job4j.tracker;

import java.util.List;
import java.util.Scanner;

/**
 * Консольный ввод пользователем.
 * @author Andrey Sumin
 * @since 05.03.2018
 */
public class ConsoleInput implements Input {
    private final Scanner in = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.println(question);
        return in.nextLine();
    }

    @Override
    public int ask(String question, List<Integer> range) throws MenuOutException {
        int result = Integer.parseInt(this.ask(question));
        boolean valid = false;
        for (int i : range) {
            if (result == i) {
                valid = true;
            }
        }
        if (!valid) {
            throw new MenuOutException("Выберите один из пунктов меню.");
        }
        return result;
    }
}
