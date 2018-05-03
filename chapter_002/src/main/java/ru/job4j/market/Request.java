package ru.job4j.market;

/**
 * Класс - запрос в систему трейдинга.
 * id - уникальный ключ заявки.
 * book - идентификатор ценной бумаги.
 * type - add/delete - выставить заявку на торги или снять
 * action - bid/ask - заявка имеет два действия. Заявка на покупка ценной бумаги или на продажу.
 * price - цена, по которой мы ходим сделать действия покупки или продажи.
 * volume - количество акций, которые мы ходим продать или купить.
 *
 * @author Andrey Sumin
 * @since 03.05.2018
 */
public class Request {
    private int id;
    private final Book book;
    private final Type type;
    private final Action action;
    private final int price;
    private int volume;

    public Request(Book book, Type type, Action action, int price, int volume) {
        this.book = book;
        this.type = type;
        this.action = action;
        this.price = price;
        this.volume = volume;
    }

    public Book getBook() {
        return book;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public Action getAction() {
        return action;
    }

    public int getPrice() {
        return price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Названия эмитентов акций.
     */
    public enum Book {
        GAZPROM,
        NIKEL,
        LUKOIL
    }

    /**
     * Добавить или удалить заявку.
     */
    public enum Type {
        add,
        delete
    }

    /**
     * Купить или продать акции.
     */
    public enum Action {
        bid,
        ask
    }
}
