package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

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
        Item item = new Item("name1", "desc1");
        tracker.add(item);
        List<Item> result = tracker.findAll();
        assertThat(result.get(0), is(item));
    }

    @Test
    public void testDeleteItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "desc1");
        Item item2 = new Item("name2", "desc2");
        Item item3 = new Item("name3", "desc3");
        tracker.add(item1, item2, item3);
        tracker.delete(item2.getId());
        List<Item> result = tracker.findAll();
        assertThat(result.get(0), is(item1));
        assertThat(result.get(1), is(item3));
        assertThat(result.size(), is(2));
    }

    @Test
    public void testReplaceItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "desc1");
        Item item2 = new Item("name2", "desc2");
        Item item3 = new Item("name3", "desc3");
        Item itemNew = new Item("newName", "newDesc");
        tracker.add(item1, item2, item3);
        tracker.replace(item1.getId(), itemNew);
        List<Item> result = tracker.findAll();
        assertThat(result.get(0), is(itemNew));
        assertThat(result.size(), is(3));
    }

    @Test
    public void testFindByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "desc1");
        Item item2 = new Item("name2", "desc2");
        Item item3 = new Item("name3", "desc3");
        Item item4 = new Item("name3", "desc4");
        Item item5 = new Item("name3", "desc5");
        Item item6 = new Item("name4", "desc6");
        Item item7 = new Item("name5", "desc7");
        tracker.add(item1, item2, item3, item4, item5, item6, item7);
        List<Item> result = tracker.findByName("name3");
        assertThat(result.size(), is(3));
        assertThat(result.get(0), is(item3));
        assertThat(result.get(1), is(item4));
        assertThat(result.get(2), is(item5));
    }

    @Test
    public void testFindById() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "desc1");
        Item item2 = new Item("name2", "desc2");
        Item item3 = new Item("name3", "desc3");
        Item item4 = new Item("name3", "desc4");
        Item item5 = new Item("name3", "desc5");
        Item item6 = new Item("name4", "desc6");
        Item item7 = new Item("name5", "desc7");
        tracker.add(item1, item2, item3, item4, item5, item6, item7);
        Item result = tracker.findById(item6.getId());
        assertThat(result, is(item6));
    }

    @Test
    public void testFindByIdNotFound() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "desc1");
        Item item2 = new Item("name2", "desc2");
        Item item3 = new Item("name3", "desc3");
        Item item4 = new Item("name3", "desc4");
        Item item5 = new Item("name3", "desc5");
        Item item6 = new Item("name4", "desc6");
        Item item7 = new Item("name5", "desc7");
        tracker.add(item1, item2, item3, item4, item5, item6, item7);
        Item result = tracker.findById("Not exists id");
        assertNull(result);
    }
}
