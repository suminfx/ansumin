package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test of Turn
 *
 * @author Andrey Sumin
 * @since 18.02.2018
 */
public class TurnTest {
    @Test
    public void testEvenArray() {
        Turn turner = new Turn();
        int[] result = new int[]{1, 5, 6, 9, 8, 13};
        turner.back(result);
        int[] expected = new int[]{13, 8, 9, 6, 5, 1};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testOddArray() {
        Turn turner = new Turn();
        int[] result = new int[]{1, 5, 6, 9, 8, 13, 9, 11, 6};
        turner.back(result);
        int[] expected = new int[]{6, 11, 9, 13, 8, 9, 6, 5, 1};
        assertArrayEquals(expected, result);
    }
}
