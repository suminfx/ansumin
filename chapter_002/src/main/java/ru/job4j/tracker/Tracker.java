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
     * @return Успешность редактирования заявки.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < this.index; i++) {
            if (this.items[i].getId().equals(id)) {
                item.setId(this.items[i].getId());
                this.items[i] = item;
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
        for (int i = 0; i < this.index; i++) {
            if (this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, this.index - i - 1);
                this.items[this.index - 1] = null;
                this.index--;
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
