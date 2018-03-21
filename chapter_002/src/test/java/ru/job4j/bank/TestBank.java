package ru.job4j.bank;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class TestBank {
    private Bank bank;
    private User user1;
    private User user2;
    private User user3;

    @Before
    public void addUsers() {
        this.bank = new Bank();
        user1 = new User("Sergey", "012012");
        user2 = new User("John", "123123");
        user3 = new User("Aleksey", "152152");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addUser(user3);
    }

    @Test
    public void testDeleteUser() {
        assertThat(bank.getClients().size(), is(3));
        bank.deleteUser(user1);
        assertThat(bank.getClients().size(), is(2));
    }

    @Test
    public void testSimilarUserIsNotAdded() {
        assertThat(bank.getClients().size(), is(3));
        bank.addUser(new User("Tom", "012012"));
        assertThat(bank.getClients().size(), is(3));
    }

    @Test
    public void testAddAccountToUser() {
        assertThat(bank.getUserAccounts("123123").size(), is(0));
        bank.addAccountToUser("123123", new Account("123"));
        assertThat(bank.getUserAccounts("123123").size(), is(1));
    }

    @Test
    public void testDeleteAccountFromUser() {
        assertThat(bank.getUserAccounts("152152").size(), is(0));
        bank.addAccountToUser("152152", new Account("123"));
        bank.addAccountToUser("152152", new Account("456"));
        bank.deleteAccountFromUser("152152", new Account("456"));
        assertThat(bank.getUserAccounts("152152").size(), is(1));
    }

    @Test
    public void testTransferMoneySuccess() {
        Account src = new Account("555");
        src.setValue(500);
        Account dst = new Account("777");
        bank.addAccountToUser("012012", src);
        bank.addAccountToUser("123123", dst);
        assertTrue(bank.transferMoney("012012", "555", "123123", "777", 400));
        assertEquals(src.getValue(), 100, 1);
        assertEquals(dst.getValue(), 400, 1);
    }

    @Test
    public void testTransferMoneyNotSuccess() {
        Account src = new Account("555");
        src.setValue(500);
        Account dst = new Account("777");
        bank.addAccountToUser("012012", src);
        bank.addAccountToUser("123123", dst);
        assertFalse(bank.transferMoney("012012", "555", "123123", "777", 1000));
        assertEquals(src.getValue(), 500, 1);
        assertEquals(dst.getValue(), 0, 1);
    }
}
