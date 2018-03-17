package ru.job4j.search;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestPriorityQueue {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("Level Five", 5));
        queue.put(new Task("Level Six", 6));
        queue.put(new Task("Level Two", 2));
        queue.put(new Task("Level Four", 4));
        queue.put(new Task("Level Seven", 7));
        queue.put(new Task("Level One", 1));
        queue.put(new Task("Level Three", 3));
        assertThat(queue.take().getDesk(), is("Level One"));
        assertThat(queue.take().getDesk(), is("Level Two"));
        assertThat(queue.take().getDesk(), is("Level Three"));
        assertThat(queue.take().getDesk(), is("Level Four"));
        assertThat(queue.take().getDesk(), is("Level Five"));
        assertThat(queue.take().getDesk(), is("Level Six"));
        assertThat(queue.take().getDesk(), is("Level Seven"));
    }
}
