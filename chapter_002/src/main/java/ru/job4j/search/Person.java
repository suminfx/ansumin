package ru.job4j.search;

/**
 * Класс, описывающий личность, содержит имя, фамилию, телефон и адрес.
 *
 * @author Andrey Sumin
 * @since 17.03.2018
 */
public class Person {
    private String name;
    private String surname;
    private String phone;
    private String address;

    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
