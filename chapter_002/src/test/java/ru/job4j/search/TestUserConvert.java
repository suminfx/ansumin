package ru.job4j.search;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestUserConvert {
    @Test
    public void testConvertListToHashMap() {
        UserConvert convert = new UserConvert();
        List<User> users = new ArrayList<>();
        users.add(new User(15, "Ivan", "Moscow"));
        users.add(new User(87, "Sergey", "Krasnodar"));
        users.add(new User(24, "Igor", "Volgograd"));
        HashMap<Integer, User> result = convert.process(users);
        assertThat(result.get(87).getName(), is("Sergey"));
    }
}
