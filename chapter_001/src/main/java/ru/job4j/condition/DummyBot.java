package ru.job4j.condition;

/**
 * Глупый бот.
 *
 * @author Andrey Sumin
 * @since 17.02.2018
 */
public class DummyBot {
    /**
     * Отвечает на вопросы.
     *
     * @param question - Вопрос.
     * @return Ответ.
     */
    public String answer(String question) {
        String result = "Это ставит меня в тупик. Спросите другой вопрос.";

        if (question.equals("Привет, Бот!")) {
            result = "Привет, умник.";
        } else if (question.equals("Пока.")) {
            result = "До скорой встречи.";
        }
        return result;
    }
}
