package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private final Scanner in = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.println(question);
        return in.nextLine();
    }
}
