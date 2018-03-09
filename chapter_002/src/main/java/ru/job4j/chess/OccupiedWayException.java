package ru.job4j.chess;

/**
 * Класс-исключение.
 * Выбрасывается, когда фигуре преграждает путь другая фигура.
 *
 * @author Andrey Sumin
 * @since 09.03.2018
 */
public class OccupiedWayException extends RuntimeException {
    public OccupiedWayException() {
        super("Путь преграждают другие фигуры.");
    }
}
