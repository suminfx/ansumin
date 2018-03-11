package ru.job4j.chess;

/**
 * Шахматный конь - реализация шахматной фигуры.
 *
 * @author Andrey Sumin
 * @since 11.03.2018
 */
public class Knight extends Figure {
    public Knight(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell src, Cell dst) throws ImpossibleMoveException {
        Cell[] result = new Cell[2];
        boolean possible = false;
        if (src.onBoard() && dst.onBoard()) {
            if (src.isHigherAndRightThan(dst)) {
                possible = (dst.getX() == src.getX() - 1 && dst.getY() == src.getY() - 2) || (dst.getX() == src.getX() - 2 && dst.getY() == src.getY() - 1);
            } else if (src.isHigherAndLeftThan(dst)) {
                possible = (dst.getX() == src.getX() + 1 && dst.getY() == src.getY() - 2) || (dst.getX() == src.getX() + 2 && dst.getY() == src.getY() - 1);
            } else if (src.isLowerAndLeftThan(dst)) {
                possible = (dst.getX() == src.getX() + 1 && dst.getY() == src.getY() + 2) || (dst.getX() == src.getX() + 2 && dst.getY() == src.getY() + 1);
            } else if (src.isLowerAndRightThan(dst)) {
                possible = (dst.getX() == src.getX() - 1 && dst.getY() == src.getY() + 2) || (dst.getX() == src.getX() - 2 && dst.getY() == src.getY() + 1);
            }
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
