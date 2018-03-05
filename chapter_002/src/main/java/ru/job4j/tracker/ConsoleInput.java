package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private final Scanner in = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.println(question);
        return in.nextLine();
    }

    @Override
    public int ask(String question, int[] range) {
        int result = -1;
        boolean valid = false;
        while (!valid) {
            try {
                result = Integer.parseInt(ask(question));
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter correct input.");
            }
        }
        return result;
    }
}
