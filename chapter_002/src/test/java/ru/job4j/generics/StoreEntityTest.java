package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StoreEntityTest {
    private Store<User> users;
    private Store<Role> roles;

    @Before
    public void initAndAddElements() {
        users = new UserStore();
        roles = new RoleStore();
        for (int i = 0; i < 30; i++) {
            users.add(new User("" + i));
            roles.add(new Role("" + i));
        }
    }

    @Test
    public void testReplaceElement() {
        users.replace("15", new User("115"));
        User resultUser = users.findById("115");
        User resultUserNull = users.findById("15");
        roles.replace("25", new Role("125"));
        Role resultRole = roles.findById("125");
        Role resultRoleNull = roles.findById("25");
        assertThat(resultUser.getId(), is("115"));
        assertNull(resultUserNull);
        assertThat(resultRole.getId(), is("125"));
        assertNull(resultRoleNull);
    }

    @Test
    public void deleteElements() {
        for (int i = 0; i < 5; i++) {
            users.delete("" + i);
            roles.delete("" + (i * 2));
        }
        assertNull(users.findById("1"));
        assertNull(roles.findById("8"));
    }
}
