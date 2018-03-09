package ru.job4j.chess;

/**
 * Абстрактный класс, описывающий поведение шахматной фигуры.
 *
 * @author Andrey Sumin
 * @since 09.03.2018
 */
public abstract class Figure {
    final Cell position;

    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * Продвижение фигуры по доске от клетки src до клетки dst.
     *
     * @param src - Исходное положение фигуры.
     * @param dst - Точка назначения фигуры.
     * @return - массив клеток, которые прошла фигура.
     * @throws ImpossibleMoveException - указана недостижимая точка назначения.
     */
    abstract Cell[] way(Cell src, Cell dst) throws ImpossibleMoveException;

    /**
     * Создание фигуры с новыми координатами.
     *
     * @param dst - новые координаты фигуры.
     * @return - фигура с новыми координатами.
     */
    abstract Figure copy(Cell dst);
}
