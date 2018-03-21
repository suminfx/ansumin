package ru.job4j.bank;

import java.util.*;

/**
 * Класс Bank для проведения банковских операций.
 *
 * @author Andrey Sumin
 * @since 21.03.2018
 */
public class Bank {
    private Map<User, List<Account>> clients = new HashMap<>();

    public Map<User, List<Account>> getClients() {
        return clients;
    }

    /**
     * Добавить нового клиента в список клиентов.
     *
     * @param user - новый клиент.
     */
    public void addUser(User user) {
        clients.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удалить клиента из списка клиентов.
     *
     * @param user - удаляемый клиент.
     */
    public void deleteUser(User user) {
        if (clients.containsKey(user)) {
            clients.remove(user);
        }
    }

    /**
     * Добавить новый счет существующему клиенту.
     *
     * @param passport - пасспорт клиента.
     * @param account  - новый счет.
     */
    public void addAccountToUser(String passport, Account account) {
        getUserAccounts(passport).add(account);
    }

    /**
     * Удалить счет у клиента.
     *
     * @param passport - пасспорт клиента.
     * @param account  - удаляемый счет.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        List<Account> accounts = getUserAccounts(passport);
        if (accounts.contains(account)) {
            accounts.remove(account);
        }
    }

    /**
     * Получить список всех счетов клиента.
     *
     * @param passport - пасспорт клиента.
     * @return - List счетов клиента.
     */
    public List<Account> getUserAccounts(String passport) {
        return clients.get(getUserByPassport(passport));
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт:
     * если счёт не найден или не хватает денег на счёте srcAccount
     * (с которого переводят) должен вернуть false
     *
     * @param srcPassport  - паспорт отправителя.
     * @param srcRequisite - реквизиты счета отправителя.
     * @param destPassport - паспорт получателя.
     * @param dstRequisite - реквизиты счета получателя.
     * @param amount       - сумма.
     * @return - успешность операции перевода.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        Account srcAccount = getAccountByPassportAndRequsite(srcPassport, srcRequisite);
        Account dstAccount = getAccountByPassportAndRequsite(destPassport, dstRequisite);
        return transferMoney(srcAccount, dstAccount, amount);
    }

    /**
     * Перегруженный приватный метод transferMoney, переводит деньги со счета
     * отправителя на счет получателя.
     *
     * @param src    - счет отправителя.
     * @param dst    - счет получателя.
     * @param amount - сумма.
     * @return - успешность операции.
     */
    private boolean transferMoney(Account src, Account dst, double amount) {
        boolean result = false;
        if (src != null && dst != null && src.getValue() >= amount && amount > 0) {
            dst.setValue(dst.getValue() + amount);
            src.setValue(src.getValue() - amount);
            result = true;
        }
        return result;
    }

    /**
     * Приватный метод - получить пользователя по его паспорту.
     *
     * @param passport - паспорт клиента.
     * @return - клиент или null, если клиент не найден.
     */
    private User getUserByPassport(String passport) {
        Set<User> users = clients.keySet();
        User result = null;
        for (User user : users) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Приватный метод - получить счет по паспорту клиента и реквизитам счета.
     *
     * @param passport  - паспорт клиента.
     * @param requisite - реквизиты счета.
     * @return счет или null, если счет не найден.
     */
    private Account getAccountByPassportAndRequsite(String passport, String requisite) {
        Account result = null;
        List<Account> accounts = getUserAccounts(passport);
        for (Account account : accounts) {
            if (account.getRequisites().equals(requisite)) {
                result = account;
            }
        }
        return result;
    }
}
