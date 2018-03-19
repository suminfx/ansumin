package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Стартовый класс с пользовательским меню
 * для добавления, удаления, редактирования
 * и поиска заявок.
 *
 * @author Andrey Sumin
 * @since 27.02.2018
 */
public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private List<Integer> range;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Инициализация пользовательского меню
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.tracker, this.input);
        menu.fillActions();
        this.range = new ArrayList<>();
        for (UserAction action : menu.actions) {
            this.range.add(action.key());
        }
        while (!menu.isStop()) {
            menu.show();
            try {
                int result = input.ask("Выберите пункт меню:", range);
                menu.select(result);
            } catch (MenuOutException e) {
                System.out.println("Выберите один из пунктов меню.");
            }
            System.out.println();
        }
    }

    /**
     * Запуск программы.
     *
     * @param args - аргументы командной строки.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
