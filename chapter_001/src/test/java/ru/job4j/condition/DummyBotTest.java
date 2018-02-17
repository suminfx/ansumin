package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест глупого бота.
 */
public class DummyBotTest {
    @Test
    public void whenQuestHiThenAnswerHi() {
        DummyBot bot = new DummyBot();
        String result = bot.answer("Привет, Бот!");
        String expected = "Привет, умник.";
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuestByeThenAnswerBye() {
        DummyBot bot = new DummyBot();
        String result = bot.answer("Пока.");
        String expected = "До скорой встречи.";
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuestAnotherThenAnswerDefault() {
        DummyBot bot = new DummyBot();
        String result = bot.answer("Другой вопрос.");
        String expected = "Это ставит меня в тупик. Спросите другой вопрос.";
        assertThat(result, is(expected));
    }
}
