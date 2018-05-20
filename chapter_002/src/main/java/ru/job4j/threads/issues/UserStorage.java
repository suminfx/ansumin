package ru.job4j.threads.issues;

import net.jcip.annotations.ThreadSafe;

import java.util.HashSet;

@ThreadSafe
public class UserStorage {
    private final HashSet<User> users = new HashSet<>();

    /**
     * Добавить нового пользователя в список.
     *
     * @param user - новый пользователь.
     * @return - успешность операции.
     */
    public synchronized boolean add(User user) {
        return this.users.add(user);
    }

    /**
     * Что должен делать этот метод?
     *
     * @param user - пользователь.
     * @return - ?
     */
    public synchronized boolean update(User user) {
        return true;
    }

    /**
     * Удалить пользователя из коллекции.
     *
     * @param user - удаляемый пользователь.
     * @return - успешность операции.
     */
    public synchronized boolean delete(User user) {
        return users.remove(user);
    }

    /**
     * Перевести деньги с одного счета на другой по id пользователей.
     *
     * @param fromId - откуда.
     * @param toId   - куда.
     * @param amount - сумма.
     * @return - успешность операции.
     */
    synchronized boolean transfer(int fromId, int toId, int amount) {
        User src = null;
        User dst = null;
        for (User user : users) {
            if (user.getId() == fromId) {
                src = user;
            }
            if (user.getId() == toId) {
                dst = user;
            }
            if (src != null && dst != null) {
                break;
            }
        }
        return transfer(src, dst, amount);
    }

    /**
     * Приватный метод для перевода денег от одного пользователя к другому.
     *
     * @param src    - откуда.
     * @param dst    - куда.
     * @param amount - количество.
     * @return - успешность операции.
     */
    private synchronized boolean transfer(User src, User dst, int amount) {
        if (src == null || dst == null || src.getAmount() < amount) {
            return false;
        }
        dst.setAmount(dst.getAmount() + amount);
        src.setAmount(src.getAmount() - amount);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String separator = System.lineSeparator();
        for (User user : users) {
            result.append(user.getId()).append(" ").append(user.getAmount()).append(separator);
        }
        return result.toString();
    }
}
