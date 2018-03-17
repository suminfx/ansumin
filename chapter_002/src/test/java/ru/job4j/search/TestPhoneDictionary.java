package ru.job4j.search;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class TestPhoneDictionary {
    @Test
    public void testSearchInDictionary() {
        PhoneDictionary dictionary = new PhoneDictionary();
        dictionary.add(new Person("Petr", "Ivanov", "+7-928-928-92-89", "Moscow"));
        List<Person> result = dictionary.find("928");
        assertThat(result.iterator().next().getName(), is("Petr"));
    }
}
