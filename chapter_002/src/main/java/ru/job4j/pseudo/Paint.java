package ru.job4j.pseudo;

/**
 * Класс Context - реализация паттерна Strategy
 *
 * @author Andrey Sumin
 * @since 02.03.2018
 */
public class Paint {
    /**
     * Нарисовать фигуру в консоли.
     *
     * @param shape - фигура
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}
