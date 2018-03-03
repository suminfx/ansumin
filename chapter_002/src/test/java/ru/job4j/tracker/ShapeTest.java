package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.pseudo.Paint;
import ru.job4j.pseudo.Square;
import ru.job4j.pseudo.Triangle;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Тест классов для прорисовки фигуры в консоли.
 *
 * @author Andrey Sumin
 * @since 02.03.2018
 */
public class ShapeTest {
    @Test
    public void testSquareDraw() {
        Square square = new Square();
        StringBuilder expected = new StringBuilder();
        String line = System.lineSeparator();
        expected.append("*****" + line);
        expected.append("*   *" + line);
        expected.append("*   *" + line);
        expected.append("*****");
        assertThat(square.draw(), is(expected.toString()));
    }

    @Test
    public void testTriangleDraw() {
        Triangle triangle = new Triangle();
        StringBuilder expected = new StringBuilder();
        String line = System.lineSeparator();
        expected.append("   *   " + line);
        expected.append("  ***  " + line);
        expected.append(" ***** " + line);
        expected.append("*******");
        assertThat(triangle.draw(), is(expected.toString()));
    }

    @Test
    public void testPaintSquare() {
        String line = System.lineSeparator();
        PrintStream stdOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        StringBuilder expected = new StringBuilder();
        expected.append("*****" + line);
        expected.append("*   *" + line);
        expected.append("*   *" + line);
        expected.append("*****" + line);
        assertThat(out.toString(), is(expected.toString()));
        System.setOut(stdOut);
    }

    @Test
    public void testPaintTriangle() {
        String line = System.lineSeparator();
        PrintStream stdOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        StringBuilder expected = new StringBuilder();
        expected.append("   *   " + line);
        expected.append("  ***  " + line);
        expected.append(" ***** " + line);
        expected.append("*******" + line);
        assertThat(out.toString(), is(expected.toString()));
        System.setOut(stdOut);
    }
}
