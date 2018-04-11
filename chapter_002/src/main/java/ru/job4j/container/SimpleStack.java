package ru.job4j.container;

public class SimpleStack<T> {
    private ManualLinkedList<T> list = new ManualLinkedList<>();
    private int head = -1;

    public T poll() {
        if (head >= 0) {
            return list.remove(head--);
        } else {
            return null;
        }
    }

    public void push(T value) {
        list.add(value);
        head++;
    }
}
