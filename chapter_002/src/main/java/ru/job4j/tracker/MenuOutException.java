package ru.job4j.tracker;

/**
 * Класс наследует исключения,
 * предназначен для проверки правильности ввода пункта меню пользователем.
 * @author Andrey Sumin
 * @since 05.03.2018
 */
public class MenuOutException extends RuntimeException {
    public MenuOutException(String msg) {
        super(msg);
    }
}
