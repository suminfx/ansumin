package ru.job4j.chess;

import java.util.Arrays;

/**
 * Шахматный слон - реализация шахматной фигуры.
 *
 * @author Andrey Sumin
 * @since 11.03.2018
 */
public class Bishop extends Figure {
    public Bishop(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell src, Cell dst) throws ImpossibleMoveException {
        Cell[] result = new Cell[8];
        int position = 0;
        boolean possible = false;
        if (src.onBoard() && dst.onBoard()) {
            if (src.isLowerAndLeftThan(dst)) {
                for (int i = src.getX(), j = src.getY(); i <= Board.BOARD_MAX_INDEX || j <= Board.BOARD_MAX_INDEX; i++, j++) {
                    Cell cell = new Cell(i, j);
                    result[position++] = cell;
                    if (cell.equals(dst)) {
                        possible = true;
                        break;
                    }
                }
            } else if (src.isHigherAndLeftThan(dst)) {
                for (int i = src.getX(), j = src.getY(); i <= Board.BOARD_MAX_INDEX || j <= 0; i++, j--) {
                    Cell cell = new Cell(i, j);
                    result[position++] = cell;
                    if (cell.equals(dst)) {
                        possible = true;
                        break;
                    }
                }
            } else if (src.isLowerAndRightThan(dst)) {
                for (int i = src.getX(), j = src.getY(); i >= 0 || j >= Board.BOARD_MAX_INDEX; i--, j++) {
                    Cell cell = new Cell(i, j);
                    result[position++] = cell;
                    if (cell.equals(dst)) {
                        possible = true;
                        break;
                    }
                }
            } else if (src.isHigherAndRightThan(dst)) {
                for (int i = src.getX(), j = src.getY(); i >= 0 || j >= 0; i--, j--) {
                    Cell cell = new Cell(i, j);
                    result[position++] = cell;
                    if (cell.equals(dst)) {
                        possible = true;
                        break;
                    }
                }
            }
        }
        if (!possible) {
            throw new ImpossibleMoveException();
        }
        return Arrays.copyOf(result, position);
    }

    @Override
    Figure copy(Cell dst) {
        return new Bishop(dst);
    }
}
