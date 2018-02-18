package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Тест сортировки пузырьком.
 *
 * @author Andrey Sumin
 * @since 18.02.2018
 */
public class BubbleSortTest {
    @Test
    public void testSort() {
        BubbleSort sort = new BubbleSort();
        int[] result = new int[]{8, 9, 5, 3, 1, 14, 96, 5, -3};
        sort.sort(result);
        int[] expected = new int[]{-3, 1, 3, 5, 5, 8, 9, 14, 96};
        assertArrayEquals(expected, result);
    }
}
