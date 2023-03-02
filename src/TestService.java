import java.util.*;
import java.util.stream.Stream;

public class TestService {
    List<String> messages = Arrays.asList(
            "Выбрать тест",
            "Доступные тесты",
            "Правильный ответ",
            "Неправильный ответ"
    );
    Map<Integer, Test> tests;
    Scanner scanner = new Scanner(System.in);
    Stats stats = new Stats();

    public TestService(List<Test> loT) {
        if (tests == null) {
            tests = new HashMap<>();
            loT.forEach(a -> tests.put(loT.indexOf(a) + 1, a));
        }
    }

    public void showTests() {
        System.out.println("Доступные тесты: ");
        tests.entrySet().forEach(a -> System.out.println(a.getKey() + " : " + a.getValue().description));
        System.out.print("\nВыбери тест: ");

        boolean selected = false;
        while (!selected) {
            int key = scanner.nextInt();
            if (tests.containsKey(key)) {
                runTest(key);
                selected = true;
            } else {
                System.out.println("Такого теста не существует. Введи правильный номер");
            }
        }
    }

    public Map<Integer, Test> getTests() {
        return tests;
    }

    public void runTest(int key) {
        boolean answered = false;
        Stream<Question> questionsStream = tests.get(key).questions.stream();
        questionsStream.map(this::showQuestion).forEach(a -> System.out.println(a));
        System.out.println("Всего ответов: " + stats.getAnswersCount());
        System.out.println("Из них правильных: " + stats.getRightAnswersCount());
    }

    public String showQuestion(Question question) {
        boolean selected = false;
        String answer = "";
        System.out.println(question.q);
        question.answers.entrySet().forEach(a -> System.out.println(a.getKey() + " : " + a.getValue()));
        System.out.print("\nОтвет: ");
        while (!selected) {
            int choice = scanner.nextInt();
            if (question.answers.get(choice) == question.rightAnswer) {
                selected = true;
                answer = messages.get(2);
                stats.addRightAnswersCount();
                stats.addAnswersCount();
            } else {
                selected = true;
                answer =  messages.get(3);
                stats.addAnswersCount();
            }
        }
        return answer;
    }
}
