package ru.job4j.loop;

/**
 * Класс для рисования пирамиды
 * @author Andrey Sumin
 * @since 17.02.2018
 */
public class Paint {
    public String paint(int height) {
        StringBuilder screen = new StringBuilder();
        String line = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 1; j <= height * 2 - 1; j++) {
                if (j >= height - i && j <= height + i) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(line);
        }
        return screen.toString();
    }
}
