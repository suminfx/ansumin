package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Тест конвертера валют
 */
public class ConverterTest {
    @Test
    public void when60RoubleToDollarThen1() {
        Converter converter = new Converter();
        double result = converter.roubleToDollar(60);
        double expected = 1D;
        assertThat(result, is(expected));
    }

    @Test
    public void when70RoubleToEuroThen1() {
        Converter converter = new Converter();
        double result = converter.roubleToEuro(70);
        double expected = 1D;
        assertThat(result, is(expected));
    }

    @Test
    public void when35WithHalfEuroToRoubleThen2485() {
        Converter converter = new Converter();
        double result = converter.euroToRouble(35.5);
        double expected = 2485;
        assertThat(result, is(expected));
    }

    @Test
    public void when7DollarsToRoubleThen420() {
        Converter converter = new Converter();
        double result = converter.dollarToRouble(7);
        double expected = 420;
        assertThat(result, is(expected));
    }
}
