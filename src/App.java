import java.util.*;

public class App {
    public static void main(String[] args) {
        Question test1q1 = new Question(
                "В каком году Гагарин полетел в космос?",
                Arrays.asList("1958", "1961", "1967", "1969"),
                "1961");
        Question test1q2 = new Question(
                "На каком языке написана эта программа?",
                Arrays.asList("С++", "Pascal", "Basic", "Java"),
                "Java");
        Question test1q3 = new Question(
                "Что легче - килограмм пуха или килограмм гвоздей?",
                Arrays.asList("Не знаю", "Пуха", "Гвоздей", "Вес одинаковый"),
                        "Вес одинаковый");

        // лист вопросов для одного теста
        List<Question> test1questions = Arrays.asList(test1q1, test1q2, test1q3);

        // в классе Test конструктор принимает List вопросов и размещает
        // его в Map<Integer, Question>
        Test test1 = new Test("1-й тест - всякие разные вопросы", test1questions);
        Test test2 = new Test("Описание второго теста", test1questions);

        // создаём список тестов для показа
        List<Test> testList = Arrays.asList(test1, test2);

        TestService ts = new TestService(testList);
        ts.showTests();

    }
}
