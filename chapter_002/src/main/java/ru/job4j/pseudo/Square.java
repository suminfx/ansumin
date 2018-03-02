package ru.job4j.pseudo;

/**
 * Класс квадрат - реализация Shape
 *
 * @author Andrey Sumin
 * @since 02.03.2018
 */
public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder result = new StringBuilder();
        result.append(""
                + "*****\n"
                + "*   *\n"
                + "*   *\n"
                + "*****");
        return result.toString();
    }
}
