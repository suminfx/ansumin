package ru.job4j.container;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ManualArrayListTest {
    private ManualList<Integer> numbers;

    @Before
    public void initAndAddElements() {
        numbers = new ManualArrayList<>();
        for (int i = 0; i < 30; i++) {
            numbers.add(i);
        }
    }

    @Test
    public void testGetElement() {
        int result = numbers.get(28);
        assertThat(result, is(28));
    }

    @Test
    public void testGetElementWhichNotExist() {
        Integer result = numbers.get(35);
        assertNull(result);
    }

    @Test
    public void testIterator() {
        int result = 0;
        for (int i : numbers) {
            if (i % 10 == 0) {
                result += i;
            }
        }
        assertThat(result, is(30));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testIteratorWithConcurrentModification() {
        for (int i : numbers) {
            if (i != 0 && i % 5 == 0) {
                numbers.add(6);
            }
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorWithIndexOutOfRange() {
        Iterator iterator = numbers.iterator();
        for (int i = 0; i < 33; i++) {
            iterator.next();
        }
    }
}
