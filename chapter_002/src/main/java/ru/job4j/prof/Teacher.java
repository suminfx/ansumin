package ru.job4j.prof;

/**
 * Класс учитель - наследует Профессию
 *
 * @author Andrey Sumin
 * @since 26.02.2018
 */
public class Teacher extends Profession {
    public Teacher(String name) {
        super(name, "Учитель");
    }
    /**
     * Метод - учить студента.
     *
     * @param student - студент.
     * @return - Имя учителя + имя студента.
     */
    public String teach(Student student) {
        return "Учитель " + this.getName() + " обучает " + student.getName();
    }
}
