package ru.job4j.tracker;

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

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Инициализация пользовательского меню
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.tracker, this.input);
        while (!menu.isStop()) {
            menu.fillActions();
            menu.show();
            try {
                int result = Integer.parseInt(input.ask("Выберите пункт меню:"));
                menu.select(result);
            } catch (Exception e) {
                System.out.println("Пункт меню введен неверно");
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
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
