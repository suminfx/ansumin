package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Класс для тестирования Square
 *
 * @author Andrey Sumin
 * @since 18.02.2018
 */
public class SquareTest {
    @Test
    public void calcTestWithBoundFive() {
        Square square = new Square();
        int[] result = square.calculate(5);
        int[] expected = new int[]{1, 4, 9, 16, 25};
        assertArrayEquals(expected, result);
    }

    @Test
    public void calcTestWithBoundNine() {
        Square square = new Square();
        int[] result = square.calculate(9);
        int[] expected = new int[]{1, 4, 9, 16, 25, 36, 49, 64, 81};
        assertArrayEquals(expected, result);
    }

    @Test
    public void calcTestWithBoundOne() {
        Square square = new Square();
        int[] result = square.calculate(1);
        int[] expected = new int[]{1};
        assertArrayEquals(expected, result);
    }
}
