package ru.job4j.condition;

/**
 * Точка имеет координаты и может рассчитывать расстояние до другой точки.
 *
 * @author Andrey Sumin
 * @since 16.02.2018
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Метод рассчитывает расстояние от текущей точки до целевой.
     *
     * @param destPoint - точка назначения
     * @return расстояние до точки назначения
     */
    public double distanceTo(Point destPoint) {
        return Math.sqrt(Math.pow(destPoint.x - this.x, 2) + Math.pow(destPoint.y - this.y, 2));
    }
}
