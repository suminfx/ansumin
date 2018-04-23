package ru.job4j.container.map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class TestMap {
    private Map<User, Object> users;
    private Calendar birthday = new Calendar.Builder().setDate(1993, 12, 22).build();

    @Before
    public void initMapAndAddElements() {
        users = new HashMap<>();
        Object object = new Object();
        users.put(new User("John", 3, birthday), object);
        users.put(new User("John", 3, birthday), object);
    }

    @Test
    public void sizeOfMapMustBeTwo() {
        System.out.println(users);
        assertThat(users.size(), is(1));
    }
}
