package ru.job4j.words;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import java.util.Set;
import java.util.TreeSet;

public class TestWordIndex {
    private WordIndex wordIndex = new WordIndex();

    @Before
    public void loadText() {
        wordIndex.loadFile("src\\\\main\\\\java\\\\ru\\\\job4j\\\\words\\\\testText.txt");
    }

    @Test
    public void testFoundWords() {
        Set<Integer> resultOne = wordIndex.getIndexes4Word("Один");
        Set<Integer> resultTwo = wordIndex.getIndexes4Word("Два");
        Set<Integer> resultThree = wordIndex.getIndexes4Word("Три");
        Set<Integer> resultFour = wordIndex.getIndexes4Word("Четыре");
        Set<Integer> resultFive = wordIndex.getIndexes4Word("Пять");
        Set<Integer> resultSix = wordIndex.getIndexes4Word("Шесть");
        Set<Integer> resultSeven = wordIndex.getIndexes4Word("Семь");
        Set<Integer> expectedOne = new TreeSet<>();
        expectedOne.add(0);
        Set<Integer> expectedTwo = new TreeSet<>();
        expectedTwo.add(6);
        Set<Integer> expectedThree = new TreeSet<>();
        expectedThree.add(11);
        expectedThree.add(16);
        Set<Integer> expectedFour = new TreeSet<>();
        expectedFour.add(21);
        expectedFour.add(35);
        Set<Integer> expectedFive = new TreeSet<>();
        expectedFive.add(29);
        Set<Integer> expectedSix = new TreeSet<>();
        expectedSix.add(43);
        Set<Integer> expectedSeven = new TreeSet<>();
        expectedSeven.add(54);
        expectedSeven.add(64);
        assertThat(resultOne, is(expectedOne));
        assertThat(resultTwo, is(expectedTwo));
        assertThat(resultThree, is(expectedThree));
        assertThat(resultFour, is(expectedFour));
        assertThat(resultFive, is(expectedFive));
        assertThat(resultSix, is(expectedSix));
        assertThat(resultSeven, is(expectedSeven));
    }

    @Test
    public void testNotFoundWords() {
        assertNull(wordIndex.getIndexes4Word("Восемь"));
        assertNull(wordIndex.getIndexes4Word("Оди"));
    }
}
