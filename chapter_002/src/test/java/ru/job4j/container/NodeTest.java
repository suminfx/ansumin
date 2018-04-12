package ru.job4j.container;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
    private Node<Integer> first;
    private Node<Integer> two;
    private Node<Integer> third;
    private Node<Integer> four;

    @Before
    public void initNodes() {
        first = new Node<>(1);
        two = new Node<>(2);
        third = new Node<>(3);
        four = new Node<>(4);
    }

    @Test
    public void testSearchCycleTrueFullCycle() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertTrue(Node.hasCycle(first));
    }

    @Test
    public void testSearchCycleTruePartCycle() {
        first.next = two;
        two.next = third;
        third.next = two;
        four.next = first;
        assertTrue(Node.hasCycle(first));
    }

    @Test
    public void testSearchCycleFalse() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;
        assertFalse(Node.hasCycle(first));
    }
}
