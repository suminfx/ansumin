package ru.job4j.generics;

/**
 * Абстрактный класс для храненителей сущностей.
 *
 * @param <T> наследует базовый класс сущностей.
 * @author Andrey Sumin
 * @since 08.04.2018
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    /**
     * Получить позицию элемента в массиве по его id.
     *
     * @param array - массив сущностей.
     * @param id    - id.
     * @return - индекс элемента или -1, если элемент не найден.
     */
    private int getPositionById(SimpleArray<T> array, String id) {
        int result = -1;
        for (int i = 0; i < array.getSize(); i++) {
            if (array.get(i).getId().equals(id)) {
                result = i;
            }
        }
        return result;
    }

    /**
     * Заменить элемент в массиве с идентификатором id новым элементом model.
     *
     * @param array - массив.
     * @param id    - идентификатор элемента.
     * @param model - новый элемент.
     * @return - успешность операции.
     */
    protected boolean replace(SimpleArray<T> array, String id, T model) {
        int position = getPositionById(array, id);
        boolean result = false;
        if (position != -1) {
            result = array.set(position, model);
        }
        return result;
    }

    /**
     * Удалить элемент из массива по его идентификатору.
     *
     * @param array - массив.
     * @param id    - идентификатор.
     * @return - успешность операции.
     */
    protected boolean delete(SimpleArray<T> array, String id) {
        int position = getPositionById(array, id);
        boolean result = false;
        if (position != -1) {
            result = array.delete(position);
        }
        return result;
    }

    /**
     * Поиск элемента в массиве по его id.
     *
     * @param array - массив.
     * @param id    - идентификатор.
     * @return - найденный элемент или null, если элемент не найден.
     */
    protected T findById(SimpleArray<T> array, String id) {
        int position = getPositionById(array, id);
        T result = null;
        if (position != -1) {
            result = array.get(position);
        }
        return result;
    }
}
