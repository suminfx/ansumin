package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOneToOneThenTwo() {
        Calculator calculator = new Calculator();
        calculator.add(1D, 1D);
        double result = calculator.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenTenSubstractSixThenFour() {
        Calculator calculator = new Calculator();
        calculator.substract(10D, 6D);
        double result = calculator.getResult();
        double expected = 4D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenMultipleTwoAndFourThenEight() {
        Calculator calculator = new Calculator();
        calculator.multiple(2D, 4D);
        double result = calculator.getResult();
        double expected = 8D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenNineDivThreeThenThree() {
        Calculator calculator = new Calculator();
        calculator.div(9D, 3D);
        double result = calculator.getResult();
        double expected = 3D;
        assertThat(result, is(expected));
    }
}
