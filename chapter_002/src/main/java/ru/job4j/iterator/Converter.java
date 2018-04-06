package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс преобразует итератор итераторов целочисленных значений
 * в один общий итератор.
 *
 * @author Andrey Sumin
 * @since 06.04.2018
 */
public class Converter {
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> current;

            @Override
            public boolean hasNext() {
                if (current == null || !current.hasNext()) {
                    if (it.hasNext()) {
                        current = it.next();
                    }
                }
                return current != null && current.hasNext();
            }

            @Override
            public Integer next() {
                int result;
                if (this.hasNext()) {
                    result = current.next();
                } else {
                    throw new NoSuchElementException();
                }
                return result;
            }
        };
    }
}
