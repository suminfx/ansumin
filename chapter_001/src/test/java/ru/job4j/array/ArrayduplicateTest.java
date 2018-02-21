package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test of ArrayDuplicate
 *
 * @author Andrey Sumin
 * @since 19.02.2018
 */
public class ArrayduplicateTest {
    @Test
    public void testRemoveDuplicate() {
        ArrayDuplicate converter = new ArrayDuplicate();
        String[] result = new String[]{"Страна", "Привет", "Страна", "Мир", "Привет", "Супер", "Мир"};
        result = converter.remove(result);
        String[] expected = new String[]{"Страна", "Привет", "Мир", "Супер"};
        assertArrayEquals(expected, result);
    }
}
