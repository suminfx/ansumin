package ru.job4j.container;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {
    private SimpleSet<Integer> numbers;

    @Before
    public void initAndAddElements() {
        numbers = new SimpleSet<>();
        for (int i = 0; i < 30; i++) {
            numbers.add(i);
        }
    }

    @Test
    public void testNotAddSameObjects() {
        assertThat(numbers.getSize(), is(30));
        for (int i = 10; i < 20; i++) {
            numbers.add(i);
        }
        assertThat(numbers.getSize(), is(30));
    }
}
