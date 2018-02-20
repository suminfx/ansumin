package ru.job4j.array;

/**
 * Класс для проверки явлется ли одно слово частью другого
 *
 * @author Andrey Sumin
 * @since 20.02.2018
 */
public class StringContains {
    /**
     * Проверяет, что одно слово находится в другом слове.
     * @param origin - origin
     * @param sub - sub
     * @return - является ли sub частью origin
     */
    public boolean contains(String origin, String sub) {
        char[] originArray = origin.toCharArray();
        char[] subArray = sub.toCharArray();
        boolean result = false;
        for (int i = 0; i <= originArray.length - subArray.length; i++) {
            for (int j = 0; j < subArray.length; j++) {
                if (subArray[j] != originArray[j + i]) {
                    result = false;
                    break;
                } else {
                    result = true;
                }
            }
            if (result) {
                break;
            }
        }
        return result;
    }
}
