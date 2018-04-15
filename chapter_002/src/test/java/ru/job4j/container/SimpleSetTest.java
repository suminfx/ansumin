package ru.job4j.container;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {
    private SimpleArraySet<Integer> arrayNumbers;
    private SimpleLinkedSet<Integer> linkedNumbers;

    @Before
    public void initAndAddElements() {
        arrayNumbers = new SimpleArraySet<>();
        linkedNumbers = new SimpleLinkedSet<>();
        for (int i = 0; i < 30; i++) {
            arrayNumbers.add(i);
            linkedNumbers.add(i);
        }
    }

    @Test
    public void testNotAddSameObjects() {
        assertThat(arrayNumbers.getSize(), is(30));
        assertThat(linkedNumbers.getSize(), is(30));
        for (int i = 10; i < 20; i++) {
            arrayNumbers.add(i);
            linkedNumbers.add(i);
        }
        assertThat(arrayNumbers.getSize(), is(30));
        assertThat(linkedNumbers.getSize(), is(30));
    }
}
