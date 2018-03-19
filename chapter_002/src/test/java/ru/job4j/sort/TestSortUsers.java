package ru.job4j.sort;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestSortUsers {
    @Test
    public void testSortUsers() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>();
        users.add(new User("Ivan", 17));
        users.add(new User("Sergey", 12));
        users.add(new User("Roman", 23));
        users.add(new User("Igor", 6));
        Set<User> result = sortUser.sort(users);
        Iterator<User> iterator = result.iterator();
        assertThat(iterator.next().getName(), is("Igor"));
        assertThat(iterator.next().getName(), is("Sergey"));
        assertThat(iterator.next().getName(), is("Ivan"));
        assertThat(iterator.next().getName(), is("Roman"));
    }
}
