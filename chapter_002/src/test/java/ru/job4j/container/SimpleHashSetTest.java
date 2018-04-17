package ru.job4j.container;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SimpleHashSetTest {
    private SimpleHashSet<Integer> set;

    @Before
    public void initSetAndAddElements() {
        set = new SimpleHashSet<>();
        testAddElement();
    }

    @Test
    public void testAddElement() {
        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
        Iterator iterator = set.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            assertThat(iterator.next(), is(i++));
        }
    }

    @Test
    public void testContains() {
        assertTrue(set.contains(5));
        assertTrue(set.contains(0));
        assertTrue(set.contains(99));
        assertFalse(set.contains(100));
    }

    @Test
    public void testRemoveElement() {
        assertTrue(set.remove(10));
        assertTrue(set.remove(99));
        assertTrue(set.remove(0));
        assertFalse(set.remove(10));
        assertFalse(set.remove(99));
        assertFalse(set.remove(0));
        assertThat(set.getSize(), is(97));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testConcurrentModification() {
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            set.add(101);
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testNoSuchElement() {
        Iterator iterator = set.iterator();
        for (int i = 0; i < 110; i++) {
            iterator.next();
        }
    }
}
