package ru.job4j.bank;

/**
 * Класс - счет клиента, имеет постоянные реквизиты и сумму денег на счету.
 *
 * @author Andrey Sumin
 * @since 20.03.2018
 */
public class Account {
    private String requisites;
    private double value;

    public Account(String requisites) {
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getRequisites() {
        return requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return requisites.equals(account.requisites);
    }

    @Override
    public int hashCode() {
        return requisites.hashCode();
    }
}
