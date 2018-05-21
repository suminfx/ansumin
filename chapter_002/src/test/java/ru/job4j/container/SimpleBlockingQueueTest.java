package ru.job4j.container;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SimpleBlockingQueueTest {
    private final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();

    @Test
    public void testProducerAndConsumer() {
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    queue.offer(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 990; i++) {
                try {
                    queue.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();
        consumer.start();
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(queue.getSize(), is(10));
        for (int i = 990; i < 1000; i++) {
            try {
                assertThat(queue.poll(), is(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
