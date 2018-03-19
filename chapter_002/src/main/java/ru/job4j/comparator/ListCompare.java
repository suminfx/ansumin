package ru.job4j.comparator;

import java.util.Comparator;

/**
 * Компоратор для строк.
 *
 * @author Andrey Sumin
 * @since 19.03.2018
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        char[] word1 = o1.toCharArray();
        char[] word2 = o2.toCharArray();
        int min = Math.min(word1.length, word2.length);
        for (int i = 0; i < min; i++) {
            if (word1[i] == word2[i]) {
                continue;
            }
            result = word1[i] > word2[i] ? 1 : -1;
            break;
        }
        if (result == 0) {
            result = word1.length - word2.length;
        }
        return result;
    }
}
