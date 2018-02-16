package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест Point
 */
public class PointTest {
    @Test
    public void testDistanceTo() {
        Point p1 = new Point(5, 5);
        Point p2 = new Point(9, 8);
        double result = p1.distanceTo(p2);
        double expected = 5;
        assertThat(result, is(expected));
    }
}
