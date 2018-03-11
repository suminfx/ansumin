package ru.job4j.chess;

/**
 * Шахматный ферзь - реализация шахматной фигуры.
 *
 * @author Andrey Sumin
 * @since 11.03.2018
 */
public class Queen extends Figure {
    public Queen(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell src, Cell dst) throws ImpossibleMoveException {
        Cell[] result = null;
        if (src.onBoard() && dst.onBoard()) {
            if (src.onOneLineWith(dst)) {
                Rook asRook = new Rook(src);
                result = asRook.way(src, dst);
            } else {
                Bishop asBishop = new Bishop(src);
                result = asBishop.way(src, dst);
            }
        }
        return result;
    }

    @Override
    Figure copy(Cell dst) {
        return new Queen(dst);
    }
}
