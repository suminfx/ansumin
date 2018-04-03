package ru.job4j.sort;

import java.util.*;

/**
 * В организации было решено ввести справочник подразделений.
 * Коды подразделений представлены в виде массива строк.
 * Задача:
 * Реализовать возможность сортировки массива кодов подразделений по возрастанию
 * и убыванию, при которых сохранялась бы иерархическая структура.
 *
 * @author Andrey Sumin
 * @since 03.04.2018
 */
public class DepartmentSort {
    /**
     * Приватный метод для сортировки с использованием различных
     * методов сравнения, а также для создания иерархической структуры
     * подразделений, используется коллекция Set для исключения дубликатов.
     *
     * @param src        - исходная коллекция подразделений.
     * @param comparator - способ сортировки.
     * @return - отсортированная коллекция Set.
     */
    private Set<String> sort(Collection<String> src, Comparator<String> comparator) {
        Set<String> departments = new TreeSet<>(comparator);
        for (String s : src) {
            String[] temp = s.split("\\\\");
            departments.add(temp[0]);
            for (int i = 1; i < temp.length; i++) {
                temp[i] = temp[i - 1] + "\\" + temp[i];
                departments.add(temp[i]);
            }
        }
        return departments;
    }

    /**
     * Сортировка по возрастанию.
     *
     * @param src - исходная коллекция подразделений.
     * @return - отсортированная коллекция.
     */
    public Set<String> ascendingSort(Collection<String> src) {
        return this.sort(src, new AscendingComparator());
    }

    /**
     * Сортировка по убыванию.
     *
     * @param src - исходная коллекция подразделений.
     * @return - отсортированная коллекция.
     */
    public Set<String> descendingSort(Collection<String> src) {
        return this.sort(src, new DescendingComparator());
    }

    /**
     * Класс реализует компоратор для сортировки по возрастанию.
     */
    private class AscendingComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

    /**
     * Класс реализует компоратор для сортировки по убыванию.
     */
    private class DescendingComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            int result;
            if (o1.startsWith(o2) || o2.startsWith(o1)) {
                result = o1.compareTo(o2);
            } else {
                result = -o1.compareTo(o2);
            }
            return result;
        }
    }
}
