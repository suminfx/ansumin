package ru.job4j.words;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Set;

/**
 * Класс позволяет по заданному слову находить все вхождения (позиции) его в файле.
 *
 * @author Andrey Sumin
 * @since 10.05.2018
 */
public class WordIndex {
    private String[] text;
    private TreeWord treeWord = new TreeWord();

    /**
     * Загрузить текст из файла, разбить его на слова и заполнить префиксное дерево значениями из этого текста.
     *
     * @param filename - путь к файлу.
     */
    public void loadFile(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            StringBuilder content = new StringBuilder();
            String separator = System.lineSeparator();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(separator);
            }
            text = content.toString().split(" ");
            for (String s : text) {
                treeWord.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Найти все вхождения искомого слова в файле.
     *
     * @param searchWord - искомое слово.
     * @return - множество отсортированных по возрастанию индексов данного слова в файле или null, если такого слова нет
     * Ищет только слово целиком.
     */
    public Set<Integer> getIndexes4Word(String searchWord) {
        return treeWord.getPositions(searchWord);
    }
}
