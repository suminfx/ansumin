package ru.job4j.search;

import java.util.HashMap;
import java.util.List;

/**
 * Класс для преобразования листа пользователей в HashMap с ключом id и значением value
 *
 * @author Andrey Sumin
 * @since 19.03.2018
 */
public class UserConvert {
    /**
     * Принимает в себя список пользователей и конвертирует его в Map с ключом Integer id и соответствующим ему User
     *
     * @param list - лист пользователей.
     * @return - HashMap с ключом id и значением User
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}
