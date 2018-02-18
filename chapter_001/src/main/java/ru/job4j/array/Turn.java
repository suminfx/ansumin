package ru.job4j.array;

/**
 * Класс для разворота массива.
 *
 * @author Andrey Sumin
 * @since 18.02.2018
 */
public class Turn {
    public int[] back(int[] srcArray) {
        int end = srcArray.length - 1;
        for (int i = 0; i < srcArray.length / 2; i++) {
            int temp = srcArray[i];
            srcArray[i] = srcArray[end - i];
            srcArray[end - i] = temp;
        }
        return srcArray;
    }
}
