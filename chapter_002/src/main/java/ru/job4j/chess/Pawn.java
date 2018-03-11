package ru.job4j.chess;

import java.util.Arrays;

/**
 * Шахматная пешка - реализация шахматной фигуры.
 *
 * @author Andrey Sumin
 * @since 11.03.2018
 */
public class Pawn extends Figure {
    public Pawn(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell src, Cell dst) throws ImpossibleMoveException {
        Cell[] result = new Cell[3];
        int position = 0;
        boolean possible = false;
        if (src.onBoard() && dst.onBoard() && src.getY() >= 1 && src.onOneLineWith(dst)) {
            if (dst.getY() - src.getY() == 1) {
                possible = true;
                result[position++] = src;
                result[position++] = dst;
            } else if (dst.getY() - src.getY() == 2 && src.getY() == 1) {
                possible = true;
                result[position++] = src;
                result[position++] = new Cell(src.getX(), src.getY() + 1);
                result[position++] = dst;
            }
        }
        if (!possible) {
            throw new ImpossibleMoveException();
        }
        return Arrays.copyOf(result, position);
    }

    @Override
    Figure copy(Cell dst) {
        return new Pawn(dst);
    }
}
