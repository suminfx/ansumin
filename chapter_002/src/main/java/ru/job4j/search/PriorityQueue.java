package ru.job4j.search;

import java.util.LinkedList;

/**
 * Лист заданий с приоритетом.
 *
 * @author Andre Sumin
 * @since 18.03.2018
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Добавление задачи в список. В зависимости от приоритета задачи
     * выбирается индекс ее размещения.
     *
     * @param task - задача
     */
    public void put(Task task) {
        boolean isPutted = false;
        for (int i = 0; i < tasks.size(); i++) {
            if (task.getPriority() <= tasks.get(i).getPriority()) {
                tasks.add(i, task);
                isPutted = true;
                break;
            }
        }
        if (!isPutted) {
            tasks.addLast(task);
        }
    }

    /**
     * Извлечь первоочередную задачу.
     *
     * @return первоочередная задача.
     */
    public Task take() {
        return this.tasks.poll();
    }
}
