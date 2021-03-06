package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Класс Tracker - обертка над массивом Item.
 *
 * @author Andrey Sumin
 * @since 26.02.2018
 */
public class Tracker {
    private List<Item> items = new ArrayList<>();
    private final Random random = new Random();

    /**
     * Добавление заявки.
     *
     * @param item - новая заявка.
     * @return - добавленная заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        return item;
    }

    /**
     * Перегрузка добавления заявки массивом.
     *
     * @param items - заявки
     */
    public void add(Item... items) {
        for (Item item : items) {
            this.add(item);
        }
    }

    /**
     * Заменяет заявку в массиве на новую, по ее id
     *
     * @param id   - id
     * @param item - новая заявка.
     * @return Успешность редактирования заявки.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                item.setId(items.get(i).getId());
                this.items.set(i, item);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Сгенерировать уникальный ключ для заявки.
     *
     * @return - id
     */
    private String generateId() {
        return Math.abs(random.nextLong() + System.currentTimeMillis()) + "";
    }

    /**
     * Удаляет заявку по ее id
     *
     * @param id - id
     * @return Успешность удаления элемента
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                this.items.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Возвращает массив ненулевых значений.
     *
     * @return массив заявок.
     */
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        result.addAll(this.items);
        return result;
    }

    /**
     * Поиск всех заявок с именем key.
     *
     * @param key - имя заявки.
     * @return - Массив заявок.
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Поиск заявки по id
     *
     * @param id - id
     * @return - Найденную заявку или null, если заявка не найдена.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}
