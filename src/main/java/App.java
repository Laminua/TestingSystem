import java.util.*;

public class App {
    public static void main(String[] args) {
        QuestionChooseOneVar test1q1 = new QuestionChooseOneVar(
                "В каком году Гагарин полетел в космос?",
                Arrays.asList("1958", "1961", "1967", "1969"),
                "1961");
        QuestionChooseOneVar test1q2 = new QuestionChooseOneVar(
                "На каком языке написана эта программа?",
                Arrays.asList("С++", "Pascal", "Basic", "Java"),
                "Java");
        QuestionChooseOneVar test1q3 = new QuestionChooseOneVar(
                "Что легче - килограмм пуха или килограмм гвоздей?",
                Arrays.asList("Не знаю", "Пуха", "Гвоздей", "Вес одинаковый"),
                        "Вес одинаковый");

        // лист вопросов для первого теста (выбор одного варианта)
        List<Question> tes1questions = Arrays.asList(test1q1, test1q2, test1q3);

        QuestionChooseMultipleVars test2q1 = new QuestionChooseMultipleVars(
                "Что из перечисленного является металлом?",
                Arrays.asList("Водород", "Железо", "Натрий", "Кремний"),
                Arrays.asList("Железо", "Натрий"));
        QuestionChooseMultipleVars test2q2 = new QuestionChooseMultipleVars(
                "Какие из перечисленных животных относятся к отряду собачьих?",
                Arrays.asList("Волк", "Тигр", "Лисица", "Песец", "Мангуст"),
                Arrays.asList("Волк", "Лисица", "Песец")
        );

        // лист вопросов для второго теста (выбор нескольких вариантов)
        List<Question> test2questions = Arrays.asList(test2q1, test2q2);

        QuestionInputAnswer test3q1 = new QuestionInputAnswer(
                "Без ... не вытащишь и рыбки из пруда",
                "труда"
        );
        QuestionInputAnswer test3q2 = new QuestionInputAnswer(
                "... world!",
                "hello"
        );
        QuestionInputAnswer test3q3 = new QuestionInputAnswer(
                "London is the ... of Great Britain",
                "capital"
        );

        // лист вопросов для третьего теста
        List<Question> test3questions = Arrays.asList(test3q1, test3q2, test3q3);

        // в классе Test конструктор принимает List вопросов и размещает
        // его в Map<Integer, Question>
        Test test1 = new Test("1-й тест - выбор одного варианта", tes1questions);
        Test test2 = new Test("2-й тест - выбор нескольких вариантов", test2questions);
        Test test3 = new Test("3-й тест - ввод пропущенного слова", test3questions);

        // создаём список тестов для показа
        List<Test> testList = Arrays.asList(test1, test2, test3);

        TestService ts = new TestService(testList);
        ts.showTests();

    }
}
