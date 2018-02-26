package ru.job4j.prof;

/**
 * Класс Инженер - наследует Профессию
 *
 * @author Andrey Sumin
 * @since 26.02.2018
 */
public class Engineer extends Profession {
    public Engineer(String name) {
        super(name, "Инженер");
    }

    /**
     * Метод - построить здание.
     *
     * @param house - Здание.
     * @return Имя инженера + тип здания.
     */
    public String build(House house) {
        return "Инженер " + this.getName() + " строит здание типа " + house.getType();
    }
}
