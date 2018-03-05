package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Класс для тестирования консольного приложения StartUI.
 *
 * @author Andrey Sumin
 * @since 02.03.2018
 */
public class StartUITest {
    private final PrintStream stdOut = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Tracker tracker = new Tracker();
    private final int menuLength = 9;

    /**
     * Перед тестом в трекер добавляется одна заявка для дальнейших тестов
     */
    @Before
    public void loadOutput() {
        System.out.println("Method before Test");
        System.setOut(new PrintStream(this.out));
        StubInput add = new StubInput("0", "name1", "desc1", "6");
        StartUI startUI = new StartUI(add, tracker);
        startUI.init();
    }

    @After
    public void backOutput() {
        System.setOut(this.stdOut);
        System.out.println("Method after Test");
    }

    @Test
    public void testAddItem() {
        int result = tracker.findAll().length;
        int expected = 1;
        assertThat(result, is(expected));
    }

    @Test
    public void testEditItem() {
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
        StubInput add = new StubInput("0", "name2", "desc2", "0", "name3", "desc3", "6");
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
        StubInput add = new StubInput("0", "name2", "desc2", "0", "name3", "desc3", "6");
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
        StubInput add = new StubInput("0", "name2", "desc2", "0", "name3", "desc3", "6");
        StartUI startUI = new StartUI(add, tracker);
        startUI.init();
        String resultId = "154";
        Item resultItem = tracker.findById(resultId);
        assertNull(resultItem);
    }

    @Test
    public void testConsoleOutputWhenSelectedAdd() {
        String[] result = out.toString().split(System.lineSeparator());
        String expected = "Заявка добавлена успешно!";
        assertThat(result[result.length - this.menuLength], is(expected));
    }

    @Test
    public void testConsoleOutputWhenSelectedShowAll() {
        StubInput showAll = new StubInput("1", "6");
        StartUI startUI = new StartUI(showAll, tracker);
        startUI.init();
        String[] result = out.toString().split(System.lineSeparator());
        String expected = "id: " + tracker.findAll()[0].getId() + "\tname: name1\tdesc: desc1";
        assertThat(result[result.length - this.menuLength], is(expected));
    }

    @Test
    public void testConsoleOutputWhenSelectedEdit() {
        StubInput showAll = new StubInput("2", tracker.findAll()[0].getId(), "newName", "newDesc", "6");
        StartUI startUI = new StartUI(showAll, tracker);
        startUI.init();
        String[] result = out.toString().split(System.lineSeparator());
        String expected = "Заявка отредактирована успешно!";
        assertThat(result[result.length - this.menuLength], is(expected));
    }

    @Test
    public void testConsoleOutputWhenSelectedDelete() {
        StubInput delete = new StubInput("3", tracker.findAll()[0].getId(), "6");
        StartUI startUI = new StartUI(delete, tracker);
        startUI.init();
        String[] result = out.toString().split(System.lineSeparator());
        String expected = "Заявка удалена успешно!";
        assertThat(result[result.length - this.menuLength], is(expected));
    }

    @Test
    public void testConsoleOutputWhenSelectedFindById() {
        StubInput findById = new StubInput("4", tracker.findAll()[0].getId(), "6");
        StartUI startUI = new StartUI(findById, tracker);
        startUI.init();
        String[] result = out.toString().split(System.lineSeparator());
        String expected = "name: name1 desc: desc1";
        assertThat(result[result.length - this.menuLength], is(expected));
    }

    @Test
    public void testConsoleOutputWhenSelectedFindByName() {
        StubInput findByName = new StubInput("5", "name1", "6");
        StartUI startUI = new StartUI(findByName, tracker);
        startUI.init();
        String[] result = out.toString().split(System.lineSeparator());
        String expected = "id: " + tracker.findAll()[0].getId() + " name: name1 desc: desc1";
        assertThat(result[result.length - this.menuLength], is(expected));
    }

    @Test
    public void testConsoleOutputWhenSelectedIncorrectItemMenu() {
        StubInput incorrect = new StubInput("a", "6");
        StartUI startUI = new StartUI(incorrect, tracker);
        startUI.init();
        String[] result = out.toString().split(System.lineSeparator());
        String expected = "Please enter correct input.";
        assertThat(result[result.length - this.menuLength], is(expected));
    }
}
