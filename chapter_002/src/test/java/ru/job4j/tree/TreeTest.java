package ru.job4j.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Andrey Sumin
 * @version $Id$
 * @since 0.1
 */
public class TreeTest {
    Tree<Integer> tree;

    @Before
    public void initAndAddElementsToTree() {
        tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
    }

    @Test
    public void when6ElFindLastThen6() {
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        assertFalse(tree.add(null, 3));
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void testIterator() {
        int result = 0;
        for (int i : tree) {
            result += i;
        }
        assertThat(result, is(21));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testIteratorWithConcurrentModification() {
        for (int i : tree) {
            tree.add(i, 8);
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorWithNoSuchElement() {
        Iterator iterator = tree.iterator();
        for (int i = 0; i < 10; i++) {
            iterator.next();
        }
    }

    @Test
    public void testTreeIsNotBinary() {
        assertFalse(tree.isBinary());
    }

    @Test
    public void testWhenTreeIsBinary() {
        Tree<Integer> binaryTree = new Tree<>(1);
        binaryTree.add(1, 2);
        binaryTree.add(1, 3);
        binaryTree.add(2, 4);
        binaryTree.add(2, 5);
        binaryTree.add(3, 6);
        binaryTree.add(3, 7);
        binaryTree.add(4, 8);
        assertTrue(binaryTree.isBinary());
        binaryTree.add(3, 9);
        assertFalse(binaryTree.isBinary());
    }
}

