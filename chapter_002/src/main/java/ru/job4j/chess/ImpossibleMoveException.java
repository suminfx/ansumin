package ru.job4j.chess;

/**
 * Класс-исключение.
 * Выбрасывается, когда для фигуры указана клетка назначения
 * в которую она не может пойти.
 *
 * @author Andrey Sumin
 * @since 09.03.2018
 */
public class ImpossibleMoveException extends RuntimeException {
    public ImpossibleMoveException() {
        super("Укажите правильную точку назначения.");
    }
}
