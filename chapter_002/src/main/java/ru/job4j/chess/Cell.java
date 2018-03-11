package ru.job4j.chess;

/**
 * Класс содержит координаты шахматной клетки.
 *
 * @author Andrey Sumin
 * @since 09.03.2018
 */
public class Cell {
    private int x;
    private int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Проверка, что клетка находится на доске.
     *
     * @return - клетка в пределах шахматной доски.
     */
    public boolean onBoard() {
        return getX() >= 0 && getX() <= Board.BOARD_MAX_INDEX && getY() >= 0 && getY() <= Board.BOARD_MAX_INDEX;
    }

    /**
     * Проверка, что клетка src находится выше, чем клетка dst
     *
     * @param dst - точка назначения.
     * @return - src выше, чем dst?
     */
    public boolean isHigherThan(Cell dst) {
        return this.y > dst.y;
    }

    /**
     * Проверка, что клетка src находится ниже, чем клетка dst
     *
     * @param dst - точка назначения.
     * @return - src ниже, чем dst?
     */
    public boolean isLowerThan(Cell dst) {
        return this.y < dst.y;
    }

    /**
     * Проверка, что клетка src находится левее, чем клетка dst
     *
     * @param dst - точка назначения.
     * @return - src левее, чем dst?
     */
    public boolean isLeftThan(Cell dst) {
        return this.x < dst.x;
    }

    /**
     * Проверка, что клетка src находится правее, чем клетка dst
     *
     * @param dst - точка назначения.
     * @return - src правее, чем dst?
     */
    public boolean isRightThan(Cell dst) {
        return this.x > dst.x;
    }

    /**
     * Проверка, что клетка src находится на одной линии
     * (горизонтальной или вертикальной) с dst
     *
     * @param dst - точка назначения.
     * @return - src выше, чем dst?
     */
    public boolean onOneLineWith(Cell dst) {
        return this.x == dst.x || this.y == dst.y;
    }

    /**
     * Проверка, что клетка src находится выше и левее, чем клетка dst
     *
     * @param dst - точка назначения.
     * @return - src выше и левее, чем dst?
     */
    public boolean isHigherAndLeftThan(Cell dst) {
        return this.isHigherThan(dst) && this.isLeftThan(dst);
    }

    /**
     * Проверка, что клетка src находится выше и правее, чем клетка dst
     *
     * @param dst - точка назначения.
     * @return - src выше и правее, чем dst?
     */
    public boolean isHigherAndRightThan(Cell dst) {
        return this.isHigherThan(dst) && this.isRightThan(dst);
    }

    /**
     * Проверка, что клетка src находится ниже и левее, чем клетка dst
     *
     * @param dst - точка назначения.
     * @return - src ниже и левее, чем dst?
     */
    public boolean isLowerAndLeftThan(Cell dst) {
        return this.isLowerThan(dst) && this.isLeftThan(dst);
    }

    /**
     * Проверка, что клетка src находится ниже и правее, чем клетка dst
     *
     * @param dst - точка назначения.
     * @return - src ниже и правее, чем dst?
     */
    public boolean isLowerAndRightThan(Cell dst) {
        return this.isLowerThan(dst) && this.isRightThan(dst);
    }

    /**
     * Геттер на координату X
     *
     * @return - X
     */
    public int getX() {
        return x;
    }

    /**
     * Геттер на координату Y
     *
     * @return - Y
     */
    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Cell) {
            Cell cell = (Cell) obj;
            result = cell.x == this.x && cell.y == this.y;
        }
        return result;
    }
}
