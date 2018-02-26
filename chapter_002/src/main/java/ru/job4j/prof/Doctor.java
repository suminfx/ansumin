package ru.job4j.prof;

/**
 * Класс доктор - наследует Профессию
 *
 * @author Andrey Sumin
 * @since 26.02.2018
 */
public class Doctor extends Profession {
    public Doctor(String name) {
        super(name, "Доктор");
    }

    /**
     * Метод - лечить пациента.
     *
     * @param patient - Пациент.
     * @return - Диагноз.
     */
    public Diagnose heal(Patient patient) {
        return new Diagnose("Доктор " + this.getName() + " лечит " + patient.getName());
    }
}
