package ru.job4j.prof;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ProfessionTest {
    @Test
    public void testProfessionDoctor() {
        Doctor doctor = new Doctor("Дмитрий");
        Patient patient = new Patient("Сергей");
        Diagnose diagnose = doctor.heal(patient);
        String result = diagnose.getName();
        String expected = "Доктор Дмитрий лечит Сергей";
        assertThat(result, is(expected));
    }

    @Test
    public void testProfessionEngineer() {
        Engineer engineer = new Engineer("Анатолий");
        House house = new House("Промышленное");
        String result = engineer.build(house);
        String expected = "Инженер Анатолий строит здание типа Промышленное";
        assertThat(result, is(expected));
    }

    @Test
    public void testProfessionTeacher() {
        Teacher teacher = new Teacher("Елена");
        Student student = new Student("Алексей");
        String result = teacher.teach(student);
        String expected = "Учитель Елена обучает Алексей";
        assertThat(result, is(expected));
    }
}
