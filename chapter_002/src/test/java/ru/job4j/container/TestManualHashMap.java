package ru.job4j.container;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class TestManualHashMap {
    private ManualHashMap<String, String> capitals;

    @Before
    public void initAndFillMap() {
        capitals = new ManualHashMap<>();
        capitals.insert("Russia", "Moscow");
        capitals.insert("England", "London");
        capitals.insert("French", "Paris");
    }

    @Test
    public void testSuccessAddition() {
        assertThat(capitals.getSize(), is(3));
        assertThat(capitals.get("Russia"), is("Moscow"));
        assertThat(capitals.get("England"), is("London"));
        assertThat(capitals.get("French"), is("Paris"));
    }

    @Test
    public void testFailedAddition() {
        capitals.insert("Russia", "Krasnodar");
        assertThat(capitals.getSize(), is(3));
        assertThat(capitals.get("Russia"), is("Moscow"));
    }

    @Test
    public void testSuccessDelete() {
        assertTrue(capitals.delete("Russia"));
        assertTrue(capitals.delete("England"));
        assertThat(capitals.getSize(), is(1));
        assertNull(capitals.get("Russia"));
    }

    @Test
    public void testFailedDelete() {
        assertFalse(capitals.delete("USA"));
        assertTrue(capitals.delete("French"));
        assertFalse(capitals.delete("French"));
    }

    @Test
    public void testIteratorWithoutExceptions() {
        StringBuilder result = new StringBuilder();
        for (String key : capitals) {
            result.append(key);
        }
        assertThat(result.toString(), is("RussiaEnglandFrench"));
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorWithNoSuchElementException() {
        Iterator iterator = capitals.iterator();
        for (int i = 0; i < 5; i++) {
            iterator.next();
        }
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testIteratorWithConcurrentModificationException() {
        for (String s : capitals) {
            capitals.insert("China", "Pekin");
        }
    }
}
