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
    private static final String ADD = "0";
    private static final String SHOW_ALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";
    private static final String EXIT = "6";

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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String result = input.ask("Выберите пункт меню:");
            switch (result) {
                case ADD:
                    this.addItem();
                    break;
                case SHOW_ALL:
                    this.showItems();
                    break;
                case EDIT:
                    this.editItem();
                    break;
                case DELETE:
                    this.deleteItem();
                    break;
                case FIND_BY_ID:
                    this.findById();
                    break;
                case FIND_BY_NAME:
                    this.findByName();
                    break;
                case EXIT:
                    exit = true;
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Вывод меню в консоль.
     */
    private void showMenu() {
        System.out.println("\n\tMenu");
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by id");
        System.out.println("5. Find item by name");
        System.out.println("6. Exit");
    }

    /**
     * Добавление заявки.
     */
    private void addItem() {
        String name = this.input.ask("Введите имя новой заявки:");
        String desc = this.input.ask("Введите описание:");
        this.tracker.add(new Item(name, desc));
        System.out.println("Заявка добавлена успешно!");
    }

    /**
     * Вывод списка всех созданных заявок.
     */
    private void showItems() {
        System.out.println("Все созданные заявки:");
        Item[] items = this.tracker.findAll();
        for (Item item : items) {
            System.out.println("id: " + item.getId() + "\tname: " + item.getName() + "\tdesc: " + item.getDescription());
        }
    }

    /**
     * Редактирование заявки.
     */
    private void editItem() {
        String id = this.input.ask("Введите id заявки, которую нужно отредактировать:");
        String name = this.input.ask("Введите новое имя:");
        String desc = this.input.ask("Введите новое описание:");
        boolean result = this.tracker.replace(id, new Item(name, desc));
        if (result) {
            System.out.println("Заявка отредактирована успешно!");
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
    }

    /**
     * Удаление заявки.
     */
    private void deleteItem() {
        String id = this.input.ask("Введите id заявки, которую нужно удалить:");
        boolean result = this.tracker.delete(id);
        if (result) {
            System.out.println("Заявка удалена успешно!");
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
    }

    /**
     * Поиск заявки по ее id.
     */
    private void findById() {
        String id = this.input.ask("Введите id заявки, которую нужно найти:");
        Item result = this.tracker.findById(id);
        if (result != null) {
            System.out.println("name: " + result.getName() + " desc: " + result.getDescription());
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
    }

    /**
     * Поиск заявки по ее имени.
     */
    private void findByName() {
        String name = this.input.ask("Введите имя заявки, которую нужно найти:");
        Item[] result = this.tracker.findByName(name);
        if (result.length > 0) {
            for (Item item : result) {
                System.out.println("id: " + item.getId() + " name: " + item.getName() + " desc: " + item.getDescription());
            }
        } else {
            System.out.println("Заявок с таким именем не найдено");
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
