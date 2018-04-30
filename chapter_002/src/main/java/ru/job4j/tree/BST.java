package ru.job4j.tree;

import java.util.*;

/**
 * Собственная реализация Binary search tree.
 *
 * @param <E> - тип данных в дереве.
 * @author Andrey Sumin.
 * @since 30.04.2018.
 */
public class BST<E extends Comparable<E>> implements Iterable<E> {
    private Node<E> root = null;
    private int size = 0;
    private int modCount = 0;

    /**
     * Добавляет элемент в дерево, если элемент меньше или равен корню,
     * то добавляет его слева от корня, в противном случае - справа.
     *
     * @param element - новый элемент.
     */
    public void add(E element) {
        size++;
        modCount++;
        if (root == null) {
            root = new Node<>(element);
            return;
        }
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            Node<E> node = data.poll();
            if (element.compareTo(node.value) <= 0) {
                if (node.left != null) {
                    data.offer(node.left);
                } else {
                    node.left = new Node<>(element);
                }
            } else {
                if (node.right != null) {
                    data.offer(node.right);
                } else {
                    node.right = new Node<>(element);
                }
            }
        }
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int current = modCount;
            Stack<Node<E>> stack = new Stack<>();
            boolean init = false;
            boolean checkLeft = false;
            boolean checkParent = false;

            @Override
            public boolean hasNext() {
                if (current != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!init) {
                    stack.push(root);
                    init = true;
                }
                return !stack.empty();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> result = null;
                if (!checkLeft) {
                    while (stack.peek().left != null) {
                        stack.push(stack.peek().left);
                    }
                    result = stack.pop();
                    checkLeft = true;
                    checkParent = false;
                } else if (!checkParent) {
                    result = stack.pop();
                    if (result.right != null) {
                        stack.push(result.right);
                        checkLeft = false;
                    }
                }
                return result != null ? result.value : null;
            }
        };
    }

    private class Node<T> {
        private final T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T value) {
            this.value = value;
        }
    }
}
