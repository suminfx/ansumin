package ru.job4j.generics;

/**
 * Абстрактный класс для храненителей сущностей.
 *
 * @param <T> наследует базовый класс сущностей.
 * @author Andrey Sumin
 * @since 08.04.2018
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> array;

    public AbstractStore(SimpleArray<T> array) {
        this.array = array;
    }

    @Override
    public void add(T model) {
        array.add(model);
    }

    /**
     * Получить позицию элемента в массиве по его id.
     *
     * @param id - id.
     * @return - индекс элемента или -1, если элемент не найден.
     */
    private int getPositionById(String id) {
        int result = -1;
        for (int i = 0; i < this.array.getSize(); i++) {
            if (this.array.get(i).getId().equals(id)) {
                result = i;
            }
        }
        return result;
    }

    /**
     * Заменить элемент в массиве с идентификатором id новым элементом model.
     *
     * @param id    - идентификатор элемента.
     * @param model - новый элемент.
     * @return - успешность операции.
     */
    @Override
    public boolean replace(String id, T model) {
        int position = getPositionById(id);
        boolean result = false;
        if (position != -1) {
            result = this.array.set(position, model);
        }
        return result;
    }

    /**
     * Удалить элемент из массива по его идентификатору.
     *
     * @param id - идентификатор.
     * @return - успешность операции.
     */
    @Override
    public boolean delete(String id) {
        int position = getPositionById(id);
        boolean result = false;
        if (position != -1) {
            result = this.array.delete(position);
        }
        return result;
    }

    /**
     * Поиск элемента в массиве по его id.
     *
     * @param id - идентификатор.
     * @return - найденный элемент или null, если элемент не найден.
     */
    @Override
    public T findById(String id) {
        int position = getPositionById(id);
        T result = null;
        if (position != -1) {
            result = this.array.get(position);
        }
        return result;
    }
}
