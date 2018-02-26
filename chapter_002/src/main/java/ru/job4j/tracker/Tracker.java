package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * Класс Tracker - обертка над массивом Item.
 *
 * @author Andrey Sumin
 * @since 26.02.2018
 */
public class Tracker {
    private Item[] items = new Item[100];
    private int index = 0;
    private final Random random = new Random();

    /**
     * Добавление заявки.
     *
     * @param item - новая заявка.
     * @return - добавленная заявка.
     */
    public Item add(Item item) {
        this.items[this.index++] = item;
        item.setId(this.generateId());
        return item;
    }

    /**
     * Перегрузка добавления заявки массивом.
     *
     * @param items - заявки
     * @return - массив добавленных заявок.
     */
    public Item[] add(Item... items) {
        for (Item item : items) {
            this.add(item);
        }
        return items;
    }

    /**
     * Заменяет заявку в массиве на новую, по ее id
     *
     * @param id   - id
     * @param item - новая заявка.
     */
    public void replace(String id, Item item) {
        for (int i = 0; i < this.index; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
            }
        }
    }

    /**
     * Сгенерировать уникальный ключ для заявки.
     *
     * @return - id
     */
    private String generateId() {
        return random.nextLong() + System.currentTimeMillis() + "";
    }

    /**
     * Удаляет заявку по ее id
     *
     * @param id - id
     */
    public void delete(String id) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getId().equals(id)) {
                Item[] temp = new Item[this.index - 1];
                System.arraycopy(this.items, 0, temp, 0, i);
                System.arraycopy(this.items, i + 1, temp, i, temp.length - i);
                this.items = Arrays.copyOf(temp, temp.length);
                this.index--;
            }
        }
    }

    /**
     * Возвращает массив ненулевых значений.
     *
     * @return массив заявок.
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.index);
    }

    /**
     * Поиск всех заявок с именем key.
     *
     * @param key - имя заявки.
     * @return - Массив заявок.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[index];
        int indexResult = 0;
        for (Item item : this.findAll()) {
            if (item.getName().equals(key)) {
                result[indexResult++] = item;
            }
        }
        return Arrays.copyOf(result, indexResult);
    }

    /**
     * Поиск заявки по id
     *
     * @param id - id
     * @return - Найденную заявку или null, если заявка не найдена.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.findAll()) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}
