package ru.job4j.tree;

import java.util.*;

/**
 * Реализация структуры tree.
 *
 * @param <E> - тип данных в дереве.
 * @author Andrey Sumin
 * @since 26.04.2018
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private int modCount = 0;

    public Tree(E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> result;
        result = parent != null ? findBy(parent) : Optional.empty();
        if (child == null || !(result.isPresent())) {
            return false;
        }
        result.get().leaves().add(new Node<>(child));
        modCount++;
        return true;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                result = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        Queue<Node<E>> data = new LinkedList<>();
        int current = modCount;
        data.offer(root);
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                if (current != modCount) {
                    throw new ConcurrentModificationException();
                }
                return !data.isEmpty();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> node = data.poll();
                for (Node<E> child : node.leaves()) {
                    data.offer(child);
                }
                return node.getValue();
            }
        };
    }
}
