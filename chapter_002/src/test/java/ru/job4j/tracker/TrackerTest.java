package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Test of Tracker
 *
 * @author Andrey Sumin
 * @since 26.02.2018
 */
public class TrackerTest {
    @Test
    public void testAddItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("name1", "desc1", "12345");
        tracker.add(item);
        Item[] result = tracker.findAll();
        assertThat(result[0], is(item));
    }

    @Test
    public void testDeleteItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "desc1", "1");
        Item item2 = new Item("name2", "desc2", "2");
        Item item3 = new Item("name3", "desc3", "3");
        tracker.add(item1, item2, item3);
        tracker.delete(item2.getId());
        Item[] result = tracker.findAll();
        assertThat(result[0], is(item1));
        assertThat(result[1], is(item3));
        assertThat(result.length, is(2));
    }

    @Test
    public void testReplaceItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "desc1", "1");
        Item item2 = new Item("name2", "desc2", "2");
        Item item3 = new Item("name3", "desc3", "3");
        Item itemNew = new Item("newName", "newDesc", "newId");
        tracker.add(item1, item2, item3);
        tracker.replace(item1.getId(), itemNew);
        Item[] result = tracker.findAll();
        assertThat(result[0], is(itemNew));
        assertThat(result.length, is(3));
    }

    @Test
    public void testFindByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "desc1", "1");
        Item item2 = new Item("name2", "desc2", "2");
        Item item3 = new Item("name3", "desc3", "3");
        Item item4 = new Item("name3", "desc4", "4");
        Item item5 = new Item("name3", "desc5", "5");
        Item item6 = new Item("name4", "desc6", "6");
        Item item7 = new Item("name5", "desc7", "7");
        tracker.add(item1, item2, item3, item4, item5, item6, item7);
        Item[] result = tracker.findByName("name3");
        assertThat(result.length, is(3));
        assertThat(result[0], is(item3));
        assertThat(result[1], is(item4));
        assertThat(result[2], is(item5));
    }

    @Test
    public void testFindById() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "desc1", "1");
        Item item2 = new Item("name2", "desc2", "2");
        Item item3 = new Item("name3", "desc3", "3");
        Item item4 = new Item("name3", "desc4", "4");
        Item item5 = new Item("name3", "desc5", "5");
        Item item6 = new Item("name4", "desc6", "6");
        Item item7 = new Item("name5", "desc7", "7");
        tracker.add(item1, item2, item3, item4, item5, item6, item7);
        Item result = tracker.findById(item6.getId());
        assertThat(result, is(item6));
    }

    @Test
    public void testFindByIdNotFound() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "desc1", "1");
        Item item2 = new Item("name2", "desc2", "2");
        Item item3 = new Item("name3", "desc3", "3");
        Item item4 = new Item("name3", "desc4", "4");
        Item item5 = new Item("name3", "desc5", "5");
        Item item6 = new Item("name4", "desc6", "6");
        Item item7 = new Item("name5", "desc7", "7");
        tracker.add(item1, item2, item3, item4, item5, item6, item7);
        Item result = tracker.findById("Not exists id");
        assertNull(result);
    }
}
