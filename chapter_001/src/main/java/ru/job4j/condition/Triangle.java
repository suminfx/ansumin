package ru.job4j.condition;

/**
 * Треугольник.
 *
 * @author Andrey Sumin
 * @since 17.02.2018
 */
public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Рассчет полупериметра треугольника.
     *
     * @param ab - расстояние от a до b
     * @param ac - расстояние от a до c
     * @param bc - расстояние от b до c
     * @return полупериметр
     */
    private double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    /**
     * Проверка на существование треугольника (любая из сторон должна быть меньше суммы двух других)
     * @param ab - сторона ab
     * @param ac - сторона ac
     * @param bc - сторона bc
     * @return - Существует ли треугольник?
     */
    private boolean exist(double ab, double ac, double bc) {
        return (ab < (ac + bc)) && (ac < (ab + bc)) && (bc < (ab + ac));
    }

    /**
     * Рассчет площади треугольника.
     * Если треугольника не существует возвращает -1
     *
     * @return Площадь
     */
    public double area() {
        double result = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            result = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return result;
    }
}
