package ru.job4j.sort;

import java.util.*;

/**
 * Класс для сортировки пользователей по возрасту в порядке возрастания.
 *
 * @author Andrey Sumin
 * @since 19.03.2018
 */
public class SortUser {
    /**
     * Отсортировать лист пользователей в порядке возрастания
     * и добавить их в TreeSet.
     *
     * @param users - лист пользователей.
     * @return - Set пользователей, отстортированных по возрасту в порядке возрастания.
     */
    Set<User> sort(List<User> users) {
        TreeSet<User> result = new TreeSet<>();
        result.addAll(users);
        return result;
    }

    /**
     * Сортировка списка пользователей по имени.
     *
     * @param users - список пользователей.
     * @return - отсортированный список.
     */
    public List<User> sortNameLength(List<User> users) {
        users.sort(new NameComparator());
        return users;
    }

    /**
     * Сортировка списка пользователей по имени, а в случае, если имена одинаковые,
     * то сортировка происходит по возрасту, в порядке возрастания.
     *
     * @param users - список пользователей.
     * @return - отсортированный список.
     */
    public List<User> sortByAllFields(List<User> users) {
        users.sort(new AllFieldsComparator());
        return users;
    }

    /**
     * Класс компоратор - сравнивает двух пользователей по имени.
     */
    private class NameComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            return (o1 != null && o2 != null) ? o1.getName().compareTo(o2.getName()) : 0;
        }
    }

    /**
     * Класс компоратор - сравнивает двух пользователей сначала по имени,
     * а если имена одинаковые, то по возрасту.
     */
    private class AllFieldsComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            int result = 0;
            if (o1 != null && o2 != null) {
                if (o1.getName().equals(o2.getName())) {
                    result = o1.getAge() - o2.getAge();
                } else {
                    result = o1.getName().compareTo(o2.getName());
                }
            }
            return result;
        }
    }
}
