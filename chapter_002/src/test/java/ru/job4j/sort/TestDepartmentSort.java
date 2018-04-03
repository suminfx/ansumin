package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class TestDepartmentSort {
    @Test
    public void testDepartmentSortAscending() {
        List<String> departments = new ArrayList<>();
        departments.add("K1\\SK1");
        departments.add("K1\\SK2");
        departments.add("K1\\SK1\\SSK1");
        departments.add("K1\\SK1\\SSK2");
        departments.add("K2");
        departments.add("K2\\SK1\\SSK1");
        departments.add("K2\\SK1\\SSK2");
        DepartmentSort sort = new DepartmentSort();
        Set<String> expected = sort.ascendingSort(departments);
        List<String> result = new ArrayList<>();
        result.add("K1");
        result.add("K1\\SK1");
        result.add("K1\\SK1\\SSK1");
        result.add("K1\\SK1\\SSK2");
        result.add("K1\\SK2");
        result.add("K2");
        result.add("K2\\SK1");
        result.add("K2\\SK1\\SSK1");
        result.add("K2\\SK1\\SSK2");
        assertArrayEquals(result.toArray(), expected.toArray());
    }

    @Test
    public void testDepartmentSortDescending() {
        List<String> departments = new ArrayList<>();
        departments.add("K1\\SK1");
        departments.add("K1\\SK2");
        departments.add("K1\\SK1\\SSK1");
        departments.add("K1\\SK1\\SSK2");
        departments.add("K2");
        departments.add("K2\\SK1\\SSK1");
        departments.add("K2\\SK1\\SSK2");
        DepartmentSort sort = new DepartmentSort();
        Set<String> expected = sort.descendingSort(departments);
        List<String> result = new ArrayList<>();
        result.add("K2");
        result.add("K2\\SK1");
        result.add("K2\\SK1\\SSK2");
        result.add("K2\\SK1\\SSK1");
        result.add("K1");
        result.add("K1\\SK2");
        result.add("K1\\SK1");
        result.add("K1\\SK1\\SSK2");
        result.add("K1\\SK1\\SSK1");
        assertArrayEquals(result.toArray(), expected.toArray());
    }

}
