package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс - телефонный справочник, в который можно добавлять
 * записи и осуществлять поиск в записях по ключу.
 *
 * @author Andrey Sumin
 * @since 17.03.2018
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    /**
     * Добавление новой записи в справочник.
     *
     * @param person - новая персона.
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Поиск в справочнике по ключу. Проверются все поля справочника.
     *
     * @param key - ключ.
     * @return - лист персон, содержащих ключ.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getName().contains(key) || person.getSurname().contains(key) || person.getPhone().contains(key) || person.getAddress().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}
