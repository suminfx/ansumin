package ru.job4j.tracker;

/**
 * Реализация меню трекера
 *
 * @author Andrey Sumin
 * @since 05.03.2018
 */
public class MenuTracker {
    private Tracker tracker;
    private Input input;
    private boolean stop = false;
    private int position = 0;

    public MenuTracker(Tracker tracker, Input input) {
        this.tracker = tracker;
        this.input = input;
    }

    UserAction[] actions = new UserAction[7];

    /**
     * Заполняем массив действий пунктов меню.
     */
    public void fillActions() {
        this.actions[position++] = new AddItem(0, "Add new item");
        this.actions[position++] = new ShowAllItems(1, "Show all items");
        this.actions[position++] = new EditItems(2, "Edit item");
        this.actions[position++] = new DeleteItem(3, "Delete item");
        this.actions[position++] = new FindById(4, "Find item by id");
        this.actions[position++] = new FindByName(5, "Find item by name");
        this.actions[position++] = new Exit(6, "Exit");
    }

    /**
     * Проверка был ли вызван выход из программы.
     *
     * @return - остановлена ли программа.
     */
    public boolean isStop() {
        return this.stop;
    }

    /**
     * Исполнение действия меню по его номеру.
     *
     * @param key - номер пункта.
     */
    public void select(int key) {
        for (UserAction action : this.actions) {
            if (action != null && key == action.key()) {
                action.execute(this.input, this.tracker);
            }
        }
    }

    /**
     * Показать меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Внутренний класс, реализующий пункт меню:
     * добавление заявки в трекер
     *
     * @author Andrey Sumin
     * @since 05.03.2018
     */
    private class AddItem extends BaseAction {
        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя новой заявки:");
            String desc = input.ask("Введите описание:");
            tracker.add(new Item(name, desc));
            System.out.println("Заявка добавлена успешно!");
        }
    }

    /**
     * Внутренний класс, реализующий пункт меню:
     * показать все созданные заявки.
     *
     * @author Andrey Sumin
     * @since 05.03.2018
     */
    private class ShowAllItems extends BaseAction {
        public ShowAllItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Все созданные заявки:");
            Item[] items = tracker.findAll();
            for (Item item : items) {
                System.out.println("id: " + item.getId() + "\tname: " + item.getName() + "\tdesc: " + item.getDescription());
            }
        }
    }

    /**
     * Внутренний класс, реализующий пункт меню:
     * редактирование заявки в трекере
     *
     * @author Andrey Sumin
     * @since 05.03.2018
     */
    private class EditItems extends BaseAction {
        public EditItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки, которую нужно отредактировать:");
            String name = input.ask("Введите новое имя:");
            String desc = input.ask("Введите новое описание:");
            boolean result = tracker.replace(id, new Item(name, desc));
            if (result) {
                System.out.println("Заявка отредактирована успешно!");
            } else {
                System.out.println("Заявка с таким id не найдена");
            }
        }
    }

    /**
     * Внутренний класс, реализующий пункт меню:
     * удаление заявки из трекера
     *
     * @author Andrey Sumin
     * @since 05.03.2018
     */
    private class DeleteItem extends BaseAction {
        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки, которую нужно удалить:");
            boolean result = tracker.delete(id);
            if (result) {
                System.out.println("Заявка удалена успешно!");
            } else {
                System.out.println("Заявка с таким id не найдена");
            }
        }
    }

    /**
     * Внутренний класс, реализующий пункт меню:
     * поиск заявки по ее id
     *
     * @author Andrey Sumin
     * @since 05.03.2018
     */
    private class FindById extends BaseAction {
        public FindById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки, которую нужно найти:");
            Item result = tracker.findById(id);
            if (result != null) {
                System.out.println("name: " + result.getName() + " desc: " + result.getDescription());
            } else {
                System.out.println("Заявка с таким id не найдена");
            }
        }
    }

    /**
     * Внутренний класс, реализующий пункт меню:
     * поиск заявки по ее имени
     *
     * @author Andrey Sumin
     * @since 05.03.2018
     */
    private class FindByName extends BaseAction {
        public FindByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки, которую нужно найти:");
            Item[] result = tracker.findByName(name);
            if (result.length > 0) {
                for (Item item : result) {
                    System.out.println("id: " + item.getId() + " name: " + item.getName() + " desc: " + item.getDescription());
                }
            } else {
                System.out.println("Заявок с таким именем не найдено");
            }
        }
    }

    /**
     * Внутренний класс, реализующий пункт меню:
     * выход из программы.
     *
     * @author Andrey Sumin
     * @since 05.03.2018
     */
    private class Exit extends BaseAction {
        public Exit(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            stop = true;
        }
    }
}
