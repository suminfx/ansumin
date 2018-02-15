package ru.job4j.calculator;

/**
 * @author Andrey Sumin.
 * @version 1.0
 * @since 15.02.2018
 * <p>
 * class Calculator.
 * Класс для вычисление простейших математических операций:
 * сложение, вычитание, умножение, деление.
 */
public class Calculator {
    private double result;

    /**
     * Геттер на result
     *
     * @return result
     */
    public double getResult() {
        return this.result;
    }

    /**
     * Метод складывает два числа
     *
     * @param first  - первое слагаемое
     * @param second - второе слагаемое
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Метод вычитает из первого аргумента второй
     *
     * @param first  - первый аргумент
     * @param second - второй аргумент
     */
    public void substract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Метод перемножает два аргумента
     *
     * @param first  - первый аргумент
     * @param second - второй аргумент
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Метод делит первый аргумент на второй, если второй аргумент равен нулю,
     * то result присваивается значение 0.
     *
     * @param first  - первый аргумент
     * @param second - второй аргумент
     */
    public void div(double first, double second) {
        if (second != 0) {
            this.result = first / second;
        } else {
            this.result = 0;
        }
    }
}
