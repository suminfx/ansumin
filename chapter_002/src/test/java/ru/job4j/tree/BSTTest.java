package ru.job4j.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class BSTTest {
    BST<Integer> tree;

    @Before
    public void initAndAddElements() {
        tree = new BST<>();
        tree.add(15);
        tree.add(10);
        tree.add(27);
        tree.add(1);
        tree.add(42);
        tree.add(12);
        tree.add(47);
        tree.add(22);
        tree.add(22);
    }

    @Test
    public void testSizeMustBeEight() {
        assertThat(tree.getSize(), is(9));
    }

    @Test
    public void testIteratorMustExtractAscendingNumbers() {
        int preNumber = 0;
        for (int i : tree) {
            assertTrue(i >= preNumber);
            preNumber = i;
        }
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testIteratorWithConcurrentModification() {
        for (int i : tree) {
            tree.add(i * 2);
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorWithNoSuchElement() {
        Iterator iterator = tree.iterator();
        for (int i = 0; i < 10; i++) {
            iterator.next();
        }
    }
}
