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

    public MenuTracker(Tracker tracker, Input input) {
        this.tracker = tracker;
        this.input = input;
    }

    UserAction[] actions = new UserAction[7];

    /**
     * Заполняем массив действий пунктов меню.
     */
    public void fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowAllItems();
        this.actions[2] = new EditItems();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindById();
        this.actions[5] = new FindByName();
        this.actions[6] = new Exit();
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
    private class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя новой заявки:");
            String desc = input.ask("Введите описание:");
            tracker.add(new Item(name, desc));
            System.out.println("Заявка добавлена успешно!");
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add new item");
        }
    }

    /**
     * Внутренний класс, реализующий пункт меню:
     * показать все созданные заявки.
     *
     * @author Andrey Sumin
     * @since 05.03.2018
     */
    private class ShowAllItems implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Все созданные заявки:");
            Item[] items = tracker.findAll();
            for (Item item : items) {
                System.out.println("id: " + item.getId() + "\tname: " + item.getName() + "\tdesc: " + item.getDescription());
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }

    /**
     * Внутренний класс, реализующий пункт меню:
     * редактирование заявки в трекере
     *
     * @author Andrey Sumin
     * @since 05.03.2018
     */
    private class EditItems implements UserAction {
        @Override
        public int key() {
            return 2;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Edit item");
        }
    }

    /**
     * Внутренний класс, реализующий пункт меню:
     * удаление заявки из трекера
     *
     * @author Andrey Sumin
     * @since 05.03.2018
     */
    private class DeleteItem implements UserAction {
        @Override
        public int key() {
            return 3;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }
    }

    /**
     * Внутренний класс, реализующий пункт меню:
     * поиск заявки по ее id
     *
     * @author Andrey Sumin
     * @since 05.03.2018
     */
    private class FindById implements UserAction {
        @Override
        public int key() {
            return 4;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by id");
        }
    }

    /**
     * Внутренний класс, реализующий пункт меню:
     * поиск заявки по ее имени
     *
     * @author Andrey Sumin
     * @since 05.03.2018
     */
    private class FindByName implements UserAction {
        @Override
        public int key() {
            return 5;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by name");
        }
    }

    /**
     * Внутренний класс, реализующий пункт меню:
     * выход из программы.
     *
     * @author Andrey Sumin
     * @since 05.03.2018
     */
    private class Exit implements UserAction {
        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            stop = true;
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Exit");
        }
    }
}
