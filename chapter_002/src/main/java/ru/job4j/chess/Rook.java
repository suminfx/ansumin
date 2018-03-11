package ru.job4j.chess;

import java.util.Arrays;

/**
 * Шахматная ладья - реализация шахматной фигуры.
 *
 * @author Andrey Sumin
 * @since 11.03.2018
 */
public class Rook extends Figure {
    public Rook(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell src, Cell dst) throws ImpossibleMoveException {
        Cell[] result = new Cell[8];
        int position = 0;
        boolean possible = false;
        if (src.onBoard() && dst.onBoard() && src.onOneLineWith(dst)) {
            if (src.isLeftThan(dst)) {
                for (int i = src.getX(); i <= Board.BOARD_MAX_INDEX; i++) {
                    Cell cell = new Cell(i, src.getY());
                    result[position++] = cell;
                    if (cell.equals(dst)) {
                        possible = true;
                        break;
                    }
                }
            } else if (src.isRightThan(dst)) {
                for (int i = src.getX(); i >= 0; i--) {
                    Cell cell = new Cell(i, src.getY());
                    result[position++] = cell;
                    if (cell.equals(dst)) {
                        possible = true;
                        break;
                    }
                }
            } else if (src.isHigherThan(dst)) {
                for (int i = src.getY(); i >= 0; i--) {
                    Cell cell = new Cell(src.getX(), i);
                    result[position++] = cell;
                    if (cell.equals(dst)) {
                        possible = true;
                        break;
                    }
                }
            } else if (src.isLowerThan(dst)) {
                for (int i = src.getY(); i <= Board.BOARD_MAX_INDEX; i++) {
                    Cell cell = new Cell(src.getX(), i);
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
        return new Rook(dst);
    }
}
