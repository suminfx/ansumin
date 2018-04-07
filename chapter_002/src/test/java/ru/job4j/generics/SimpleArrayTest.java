package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SimpleArrayTest {
    private SimpleArray<Integer> array;

    @Before
    public void initAndAddElements() {
        array = new SimpleArray<>();
        for (int i = 0; i < 30; i++) {
            array.add(i);
        }
    }

    @Test
    public void testGetElement() {
        int result = array.get(15);
        int expected = 15;
        assertThat(result, is(expected));
    }

    @Test
    public void testSetElement() {
        array.set(15, 0);
        int result = array.get(15);
        int expected = 0;
        assertThat(result, is(expected));
    }

    @Test
    public void deleteElements() {
        for (int i = 0; i < 5; i++) {
            array.delete(0);
        }
        assertThat(array.getSize(), is(25));
    }

    @Test
    public void testIterator() {
        int result = 0;
        for (int i : array) {
            if (i > 28) {
                result += i;
            }
        }
        assertThat(result, is(29));
    }

}
