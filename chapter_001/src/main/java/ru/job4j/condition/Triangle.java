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
    private boolean exist;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        exist = !(a.equals(b) || a.equals(c) || b.equals(c));
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
     * Рассчет площади треугольника.
     * Если треугольника не существует возвращает -1
     *
     * @return Площадь
     */
    public double area() {
        double result = -1;

        if (exist) {
            double ab = this.a.distanceTo(this.b);
            double ac = this.a.distanceTo(this.c);
            double bc = this.b.distanceTo(this.c);
            double p = period(ab, ac, bc);
            result = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }

        return result;
    }
}
