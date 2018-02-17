package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест шахматной доски
 *
 * @author Andrey Sumin
 * @since 17.02.2018
 */
public class BoardTest {
    @Test
    public void whenPaintBoardWithWidthThreeAndHeightThreeThenStringWithThreeColsAndThreeRows() {
        Board board = new Board();
        final String line = System.lineSeparator();
        String result = board.paint(3, 3);
        String expected = String.format("X X%s X %sX X%s", line, line, line);
        assertThat(result, is(expected));
    }

    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {
        Board board = new Board();
        final String line = System.lineSeparator();
        String result = board.paint(5, 4);
        String expected = String.format("X X X%s X X %sX X X%s X X %s", line, line, line, line);
        assertThat(result, is(expected));
    }
}
