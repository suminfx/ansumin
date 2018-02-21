package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test of StringContains
 *
 * @author Andrey Sumin
 * @since 20.02.2018
 */
public class StringContainsTest {
    @Test
    public void testContainsTrue() {
        StringContains analyzer = new StringContains();
        boolean result = analyzer.contains("Привет", "Пр");
        assertTrue(result);
    }

    @Test
    public void testContainsFalse() {
        StringContains analyzer = new StringContains();
        boolean result = analyzer.contains("Привет", "тевр");
        assertFalse(result);
    }
}
