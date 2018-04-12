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
        boolean result = false;
        Node nextNode = first;
        int index = 0;
        while ((nextNode = nextNode.next) != null) {
            index++;
            Node current = first;
            for (int i = 0; i < index; i++) {
                if (current.value == nextNode.value) {
                    result = true;
                    break;
                }
                current = current.next;
            }
            if (result) {
                break;
            }
        }
        return result;
    }
}
