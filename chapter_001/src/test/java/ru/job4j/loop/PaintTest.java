package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test of Paint
 *
 * @author Andrey Sumin
 * @since 17.02.2018
 */
public class PaintTest {
    @Test
    public void testPaintWithHeightFive() {
        String line = System.lineSeparator();
        Paint paint = new Paint();
        String result = paint.paint(5);
        String expected = ""
                        + "    ^    " + line
                        + "   ^^^   " + line
                        + "  ^^^^^  " + line
                        + " ^^^^^^^ " + line
                        + "^^^^^^^^^" + line;
        assertThat(result, is(expected));
    }

    @Test
    public void testPaintWithHeightEight() {
        String line = System.lineSeparator();
        Paint paint = new Paint();
        String result = paint.paint(8);
        String expected = ""
                        + "       ^       " + line
                        + "      ^^^      " + line
                        + "     ^^^^^     " + line
                        + "    ^^^^^^^    " + line
                        + "   ^^^^^^^^^   " + line
                        + "  ^^^^^^^^^^^  " + line
                        + " ^^^^^^^^^^^^^ " + line
                        + "^^^^^^^^^^^^^^^" + line;
        assertThat(result, is(expected));
    }
}
