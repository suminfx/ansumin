package ru.job4j.container;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Ручная реализация упрощенного LinkedList, есть возможность добавлять элементы
 * в конец списка и получать элемент по его индексу.
 *
 * @param <E> - тип данных в коллекции.
 * @author Andrey Sumin
 * @since 10.04.2018
 */
public class ManualLinkedList<E> implements ManualList<E> {
    private int size = 0;
    private int modCount = 0;
    private Node<E> first = null;
    private Node<E> last = null;

    @Override
    public void add(E value) {
        Node<E> l = last;
        Node<E> newNode = new Node(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = last;
        }
        size++;
        modCount++;
    }

    public E remove(int index) {
        Node<E> node = getNodeByIndex(index);
        if (isOnlyNode(node)) {
            node.next = null;
            node.previous = null;
        } else if (node == first) {
            node.next.previous = null;
            first = node.next;
        } else if (node == last) {
            node.previous.next = null;
            last = node.previous;
        } else {
            node.next.previous = node.previous;
            node.previous.next = node.next;
        }
        size--;
        modCount++;
        return node.current;
    }

    private boolean isOnlyNode(Node<E> node) {
        return node == first && node == last;
    }

    private Node<E> getNodeByIndex(int index) {
        Node<E> x = first;
        if (index >= 0 && index < this.size) {
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
        return x;
    }

    @Override
    public E get(int index) {
        return getNodeByIndex(index).current;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int current = modCount;
            Node<E> node = first;

            @Override
            public boolean hasNext() {
                if (current == modCount) {
                    return node.next != null;
                } else {
                    throw new ConcurrentModificationException();
                }
            }

            @Override
            public E next() {
                if (hasNext()) {
                    E result = node.current;
                    node = node.next;
                    return result;
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    /**
     * Приватный класс для хранения ссылок на предыдущий и следующий Node и на текущий элемент.
     *
     * @param <T> - тип текущего элемента.
     */
    private class Node<T> {
        Node<T> previous;
        T current;
        Node<T> next;

        public Node(Node<T> previous, T current, Node<T> next) {
            this.previous = previous;
            this.current = current;
            this.next = next;
        }
    }
}
