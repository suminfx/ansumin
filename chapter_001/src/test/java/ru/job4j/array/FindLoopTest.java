package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест класса FindLoop
 *
 * @author Andrey Sumin
 * @since 18.02.2018
 */
public class FindLoopTest {
    @Test
    public void indexOfExistElement() {
        FindLoop searcher = new FindLoop();
        int[] data = new int[]{1, 15, 85, 42, 9, -6, 16, 4};
        int element = 42;
        int result = searcher.indexOf(data, element);
        int expected = 3;
        assertThat(result, is(expected));
    }

    @Test
    public void indexOfNotExistElement() {
        FindLoop searcher = new FindLoop();
        int[] data = new int[]{1, 15, 85, 42, 9, -6, 16, 4};
        int element = 188;
        int result = searcher.indexOf(data, element);
        int expected = -1;
        assertThat(result, is(expected));
    }
}
