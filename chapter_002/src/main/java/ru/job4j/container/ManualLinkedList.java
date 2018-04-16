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
        Node<E> preLast = this.last;
        Node<E> newNode = new Node(preLast, value, null);
        this.last = newNode;
        if (preLast == null) {
            first = newNode;
        } else {
            preLast.next = this.last;
        }
        size++;
        modCount++;
    }

    public E remove(int index) {
        Node<E> node = getNodeByIndex(index);
        if (isOnlyNode()) {
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

    private boolean isOnlyNode() {
        return this.size == 1;
    }

    private Node<E> getNodeByIndex(int index) {
        Node<E> node = first;
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
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
                if (current != modCount) {
                    throw new ConcurrentModificationException();
                }
                return node != null && node.next != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E result = node.current;
                node = node.next;
                return result;
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
