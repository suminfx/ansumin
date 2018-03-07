package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test of SartArray
 *
 * @author Andrey Sumin
 * @since 07.03.2018
 */
public class SortArrayTest {
    @Test
    public void testSort() {
        SortArray sort = new SortArray();
        int[] first = new int[]{1, 16, 25, 44, 96};
        int[] second = new int[]{-3, 8, 15, 27};
        int[] result = sort.sort(first, second);
        int[] expected = new int[]{-3, 1, 8, 15, 16, 25, 27, 44, 96};
        assertArrayEquals(result, expected);
    }
}
