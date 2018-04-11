package ru.job4j.container;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SimpleStackTest {
    private SimpleStack<Integer> numbers;

    @Before
    public void initAndFillQueue() {
        numbers = new SimpleStack<>();
        for (int i = 0; i < 10; i++) {
            numbers.push(i);
        }
    }

    @Test
    public void testPollElements() {
        for (int i = 0; i < 10; i++) {
            assertThat(numbers.poll(), is(9 - i));
        }
    }
}
