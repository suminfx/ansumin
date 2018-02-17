package ru.job4j.loop;

/**
 * Шахматная доска.
 *
 * @author Andrey Sumin
 * @since 17.02.2018
 */
public class Board {
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        final String line = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(line);
        }
        return screen.toString();
    }
}
