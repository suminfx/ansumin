package ru.job4j.container;

/**
 * Класс Node содержит значение и ссылку на следующий элемент.
 * Имеет статический метод поиска зацикленности.
 *
 * @param <T> - тип объекта.
 * @author Andrey Sumin
 * @since 12.04.2018
 */
public class Node<T> {
    private T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    /**
     * Проверка зацикленности списка.
     *
     * @param first - первый элемент списка, с которого начинается проверка.
     * @return - имеются ли зацикленности в списке.
     */
    public static boolean hasCycle(Node first) {
        if (first == null) {
            return false;
        }
        Node slow, fast;
        slow = first;
        fast = first;
        while (true) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
            if (slow == null || fast == null) {
                return false;
            }
            if (slow == fast) {
                return true;
            }
        }
    }
}
