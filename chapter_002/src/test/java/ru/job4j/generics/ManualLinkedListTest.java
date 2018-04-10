package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.container.ManualLinkedList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ManualLinkedListTest {
    private ManualLinkedList<Integer> list;

    @Before
    public void initListAndFillElements() {
        list = new ManualLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
    }

    @Test
    public void testAddAndGetElements() {
        assertThat(list.get(37), is(37));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetElementWithIndexOutOfBounds() {
        list.get(100);
    }

    @Test
    public void testIteratorWorksProperly() {
        Iterator<Integer> iterator = list.iterator();
        int temp = 0;
        while (iterator.hasNext()) {
            if (iterator.next() % 99 == 0) {
                temp = 99;
            }
        }
        assertThat(temp, is(99));
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNoSuchElement() {
        Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i < 101; i++) {
            iterator.next();
        }
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testIteratorConcurrentModification() {
        for (int i : list) {
            list.add(6);
        }
    }
}
