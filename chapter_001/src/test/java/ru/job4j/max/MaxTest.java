package ru.job4j.max;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Test Max.
 *
 * @author Andrey Sumin
 * @since 17.02.2018
 */
public class MaxTest {
    @Test
    public void testMax() {
        Max calculator = new Max();
        int result1 = calculator.max(1, 10);
        int expected1 = 10;
        int result2 = calculator.max(-15, 3);
        int expected2 = 3;
        int result3 = calculator.max(4, 100);
        int expected3 = 100;
        assertArrayEquals(new int[]{expected1, expected2, expected3}, new int[]{result1, result2, result3});
    }

    @Test
    public void testMaxWithThreeParams() {
        Max calculator = new Max();
        int result1 = calculator.max(1, 10, 14);
        int expected1 = 14;
        int result2 = calculator.max(-15, 3, 27);
        int expected2 = 27;
        int result3 = calculator.max(4, 100, -23);
        int expected3 = 100;
        assertArrayEquals(new int[]{expected1, expected2, expected3}, new int[]{result1, result2, result3});
    }
}
