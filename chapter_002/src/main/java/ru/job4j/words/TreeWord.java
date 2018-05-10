package ru.job4j.words;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * Вспомогательный класс - нагруженное (префиксное) дерево.
 * В данном классе хранятся все слова из данного текста в виде дерева, где
 * в каждый узел является парой: ключ (буква) - значение (массив дочерних элементов)
 *
 * @author Andrey Sumin
 * @since 10.05.2018
 */
class TreeWord {
    private final Node root = new Node(' ');
    private int position = -1;

    /**
     * Добавить новое слово в дерево, предварительно отрезав от него небуквенные значения
     *
     * @param word - добавляемое слово.
     */
    void add(String word) {
        char[] keys = word.toCharArray();
        int start = 0;
        int finish = keys.length;
        int difference = 0;
        boolean isWord = false;
        for (char key : keys) {
            if (!Character.isLetter(key)) {
                start++;
                position++;
            } else {
                isWord = true;
                break;
            }
        }
        for (int i = keys.length - 1; i >= 0; i--) {
            if (isWord && Character.isLetter(keys[i])) {
                break;
            } else {
                finish--;
                difference++;
            }
        }
        if (isWord) {
            Node current = root;
            for (int i = start; i < finish; i++) {
                position++;
                Node next = getNodeByChar(current.children, keys[i]);
                if (next == null) {
                    next = new Node(keys[i]);
                }
                if (i == finish - 1) {
                    next.positions.add(position - finish + start + 1);
                    next.isIntermediate = false;
                    position++;
                }
                if (!current.children.contains(next)) {
                    current.children.add(next);
                }
                current = next;
            }
            position += difference;
        }
    }

    /**
     * Получить все позиции в тексте нужного слова.
     *
     * @param word - искомое слово.
     * @return - отсортированное множество позиций, или null, если слово не найдено
     */
    TreeSet<Integer> getPositions(String word) {
        TreeSet<Integer> result = null;
        char[] keys = word.toCharArray();
        Node current = root;
        boolean found = true;
        for (char key : keys) {
            if (current.children.contains(new Node(key))) {
                for (Node node : current.children) {
                    if (node.value == key) {
                        current = node;
                    }
                }
            } else {
                found = false;
                break;
            }
        }
        if (found && !current.isIntermediate) {
            result = current.positions;
        }
        return result;
    }

    /**
     * Получить узел в списке узлов по его значению (char).
     *
     * @param nodes   - списко узлов.
     * @param element - значение узла.
     * @return - узел со значениес element или null, если узел не найден.
     */
    private Node getNodeByChar(HashSet<Node> nodes, char element) {
        for (Node node : nodes) {
            if (node.value == element) {
                return node;
            }
        }
        return null;
    }

    /**
     * Внутренний приватный класс - узел дерева, содержит значение value (буква), список дочерних узлов children,
     * список позиций данного узла в тексте (если узел не является промежуточным) positions,
     * булево значение isIntermediate - является ли узел промежуточным.
     */
    private class Node {
        private char value;
        private HashSet<Node> children = new HashSet<>();
        private TreeSet<Integer> positions = new TreeSet<>();
        private boolean isIntermediate = true;

        private Node(char value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Node node = (Node) o;

            return value == node.value;
        }

        @Override
        public int hashCode() {
            return (int) value;
        }
    }
}
