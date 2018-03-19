package ru.job4j.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
}
