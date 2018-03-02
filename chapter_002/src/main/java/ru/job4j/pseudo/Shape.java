package ru.job4j.pseudo;

/**
 * Интерфейс фигура (реализация паттерна Стратегия)
 *
 * @author Andrey Sumin
 * @since 02.03.2018
 */
public interface Shape {
    /**
     * Прорисовка фигуры в консоли.
     *
     * @return - рисунок фигуры в виде строки.
     */
    String draw();
}
