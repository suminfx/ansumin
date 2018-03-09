package ru.job4j.chess;

/**
 * Класс-исключение.
 * Выбрасывается, когда в клетке source, откуда должна начать движение фигура,
 * отсутствует фигура.
 *
 * @author Andrey Sumin
 * @since 09.03.2018
 */
public class FigureNotFoundException extends RuntimeException {
    public FigureNotFoundException() {
        super("На исходной клетке отсутствует фигура.");
    }
}
