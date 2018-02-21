package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест рассчета идеального веса
 */
public class FitTest {
    @Test
    public void manWeight() {
        Fit analyzer = new Fit();
        double result = analyzer.manWeight(180);
        double expected = 92;
        assertThat(result, is(expected));
    }

    @Test
    public void womanWeight() {
        Fit analizer = new Fit();
        double result = analizer.womanWeight(170);
        double expected = 69;
        assertThat(result, is(expected));
    }
}
