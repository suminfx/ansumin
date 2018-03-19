package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class TestConvertList {
    @Test
    public void testConvertToList() {
        ConvertList convert = new ConvertList();
        int[][] array = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> result = convert.toList(array);
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < expected.length; i++) {
            assertThat(result.get(i), is(expected[i]));
        }
    }

    @Test
    public void testConvertToArray() {
        ConvertList convert = new ConvertList();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        int[][] result = convert.toArray(list, 3);
        int[][] expected = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        assertArrayEquals(result, expected);
    }

    @Test
    public void testConvertListOfArraysToGeneralList() {
        ConvertList convert = new ConvertList();
        List<int[]> arrays = new ArrayList<>();
        arrays.add(new int[]{1, 2, 3, 4, 5});
        arrays.add(new int[]{6, 7, 8});
        arrays.add(new int[]{9, 10});
        List<Integer> result = convert.convert(arrays);
        List<Integer> expected = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            expected.add(i);
        }
        assertThat(result, is(expected));
    }
}
