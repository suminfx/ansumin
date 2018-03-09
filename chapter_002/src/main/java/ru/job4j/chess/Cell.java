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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Cell cell = (Cell) obj;
        return cell.x == this.x && cell.y == this.y;
    }
}
