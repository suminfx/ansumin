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
        Max max = new Max();
        int result1 = max.max(1, 10);
        int expected1 = 10;
        int result2 = max.max(-15, 3);
        int expected2 = 3;
        int result3 = max.max(4, 100);
        int expected3 = 100;
        assertArrayEquals(new int[]{expected1, expected2, expected3}, new int[]{result1, result2, result3});
    }
}
