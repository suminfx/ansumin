package ru.job4j.calculator;

/**
 * Рассчет идеального веса в зависимости от роста
 */
public class Fit {
    /**
     * Идеальный вес для мужчин.
     *
     * @param height - Рост
     * @return - Идеальный вес
     */
    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * Идеальный вес для женщин.
     *
     * @param height - Рост
     * @return - Идеальный вес
     */
    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
}
