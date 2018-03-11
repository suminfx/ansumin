package ru.job4j.chess;

/**
 * Шахматный король - реализация шахматной фигуры.
 *
 * @author Andrey Sumin
 * @since 11.03.2018
 */
public class King extends Figure {
    public King(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell src, Cell dst) throws ImpossibleMoveException {
        Cell[] result = new Cell[2];
        boolean possible = false;
        if (dst.onBoard() && src.onBoard() && !dst.equals(src)) {
            possible = Math.abs(dst.getX() - src.getX()) <= 1 && Math.abs(dst.getY() - src.getY()) <= 1;
        }
        if (!possible) {
            throw new ImpossibleMoveException();
        }
        result[0] = src;
        result[1] = dst;
        return result;
    }

    @Override
    Figure copy(Cell dst) {
        return null;
    }
}
