package ru.job4j.container;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Ручная реализация HashMap.
 *
 * @param <K> - ключ.
 * @param <V> - значение.
 * @author Andrey Sumin.
 * @since 24.04.2018.
 */
public class ManualHashMap<K, V> implements Iterable<K> {
    private static final float LOAD_FACTOR = 0.75f;
    private static final int DEFAULT_SIZE = 16;
    private static final float MUL_FACTOR = 2f;

    private int fullSizeOfArray = DEFAULT_SIZE;
    private int size = 0;
    private int modCount = 0;

    private Node<K, V>[] nodes = (Node<K, V>[]) new Node[DEFAULT_SIZE];

    /**
     * Вставить новый элемент в map.
     *
     * @param key   - ключ.
     * @param value - значение.
     * @return - если такой ключ в массиве уже есть возвращает false, в противном случае true.
     */
    public boolean insert(K key, V value) {
        if (key == null || value == null || containsKey(key)) {
            return false;
        }
        if (size >= fullSizeOfArray * LOAD_FACTOR) {
            increaseArray();
        }
        nodes[hash(key)] = new Node<>(key, value);
        size++;
        modCount++;
        return true;
    }

    /**
     * Получить значение по его ключу.
     *
     * @param key - ключ.
     * @return - значение, соответствующее ключу.
     */
    public V get(K key) {
        return containsKey(key) ? nodes[hash(key)].value : null;
    }

    /**
     * Удалить элемент из map по его ключу.
     *
     * @param key - ключ.
     * @return - возвращает false, если ключ не найден, в противном случае true.
     */
    public boolean delete(K key) {
        if (!containsKey(key)) {
            return false;
        } else {
            nodes[hash(key)] = null;
            modCount++;
            size--;
            return true;
        }
    }

    /**
     * Получить количество добавленных в map элементов.
     *
     * @return - кол-во элементов в map.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Приватный метод - увеличивает размер массива в MUL_FACTOR раз.
     */
    private void increaseArray() {
        fullSizeOfArray *= MUL_FACTOR;
        Node<K, V>[] newArray = (Node<K, V>[]) new Node[fullSizeOfArray];
        for (Node node : nodes) {
            if (node != null) {
                newArray[hash((K) (node.key))] = node;
            }
        }
        this.nodes = newArray;
    }

    /**
     * Проверка на наличие ключа в массиве.
     *
     * @param key - ключ.
     * @return - имеется ли ключ в map.
     */
    private boolean containsKey(K key) {
        return nodes[hash(key)] != null;
    }

    /**
     * Рассчет индекса элемента в массиве по его key.hashCode().
     *
     * @param key - ключ.
     * @return - индекс элемента в массиве.
     */
    private int hash(K key) {
        return Math.abs(key.hashCode() % fullSizeOfArray);
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int currentModCount = modCount;
            int currentPosition = 0;
            int nextPosition = 0;

            @Override
            public boolean hasNext() {
                if (currentModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                boolean result = false;
                for (int i = currentPosition; i < fullSizeOfArray; i++) {
                    if (nodes[i] != null) {
                        result = true;
                        nextPosition = i;
                        break;
                    }
                }
                return result;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                currentPosition = nextPosition + 1;
                return nodes[nextPosition].key;
            }
        };
    }

    /**
     * Приватный внутренний класс для хранения пар ключ-значение.
     *
     * @param <K> - ключ.
     * @param <V> - значение.
     */
    private static class Node<K, V> {
        private final K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
