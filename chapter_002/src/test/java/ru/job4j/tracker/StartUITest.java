package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Класс для тестирования консольного приложения StartUI.
 *
 * @author Andrey Sumin
 * @since 02.03.2018
 */
public class StartUITest {
    @Test
    public void testAddItem() {
        Tracker tracker = new Tracker();
        StartUI start = new StartUI(new StubInput("0", "name1", "desc1", "6"), tracker);
        start.init();
        int result = tracker.findAll().length;
        int expected = 1;
        assertThat(result, is(expected));
    }

    @Test
    public void testEditItem() {
        Tracker tracker = new Tracker();
        StubInput add = new StubInput("0", "name1", "desc1", "6");
        StartUI startUI = new StartUI(add, tracker);
        startUI.init();
        StubInput edit = new StubInput("2", tracker.findAll()[0].getId(), "newName", "newDesc", "6");
        StartUI editUI = new StartUI(edit, tracker);
        editUI.init();
        int result = tracker.findAll().length;
        int expected = 1;
        assertThat(result, is(expected));
        int result2 = tracker.findByName("newName").length;
        int expected2 = 1;
        assertThat(result2, is(expected2));
        int result3 = tracker.findByName("name").length;
        int expected3 = 0;
        assertThat(result3, is(expected3));
    }

    @Test
    public void testDeleteItem() {
        Tracker tracker = new Tracker();
        StubInput add = new StubInput("0", "name1", "desc1", "0", "name2", "desc2", "0", "name3", "desc3", "6");
        StartUI startUI = new StartUI(add, tracker);
        startUI.init();
        int result = tracker.findAll().length;
        int expected = 3;
        assertThat(result, is(expected));
        int result1 = tracker.findByName("name3").length;
        int expected1 = 1;
        assertThat(result1, is(expected1));
        StubInput delete = new StubInput("3", tracker.findAll()[2].getId(), "6");
        StartUI deleteUI = new StartUI(delete, tracker);
        deleteUI.init();
        int result2 = tracker.findAll().length;
        int expected2 = 2;
        assertThat(result2, is(expected2));
        int result3 = tracker.findByName("name3").length;
        int expected3 = 0;
        assertThat(result3, is(expected3));
    }

    @Test
    public void testFindByID() {
        Tracker tracker = new Tracker();
        StubInput add = new StubInput("0", "name1", "desc1", "0", "name2", "desc2", "0", "name3", "desc3", "6");
        StartUI startUI = new StartUI(add, tracker);
        startUI.init();
        String resultId = tracker.findByName("name1")[0].getId();
        Item resultItem = tracker.findById(resultId);
        String resultDesc = resultItem.getDescription();
        String expectedDesc = "desc1";
        assertThat(resultDesc, is(expectedDesc));
    }

    @Test
    public void testFindByIDNotFound() {
        Tracker tracker = new Tracker();
        StubInput add = new StubInput("0", "name1", "desc1", "0", "name2", "desc2", "0", "name3", "desc3", "6");
        StartUI startUI = new StartUI(add, tracker);
        startUI.init();
        String resultId = "154";
        Item resultItem = tracker.findById(resultId);
        assertNull(resultItem);
    }
}
