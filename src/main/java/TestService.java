import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestService {
    static final String CHOOSE_TEST = "Выбери тест: ";
    static final String AVAILABLE_TESTS = "Доступные тесты";
    static final String RIGHT_ANSWER = "Правильный ответ";
    static final String BAD_ANSWER = "Неправильный ответ";
    Map<Integer, Test> tests;
    Scanner scanner = new Scanner(System.in);

    public TestService(List<Test> loT) {
        tests = loT.stream()
                .collect(Collectors.toMap((a -> loT.indexOf(a) + 1), Function.identity()));
    }

    public void showTests() {
        System.out.println(AVAILABLE_TESTS);
        tests.forEach((key, value) -> System.out.println(key + " : " + value.description + value.info));
        System.out.print(CHOOSE_TEST);

        int key = 0;
        boolean selected = false;
        while (!selected) {
            try {
                key = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next();
            }
            if (tests.containsKey(key)) {
                runTest(key);
                selected = true;
            } else {
                System.err.println("Введи число от 1 до " + tests.size());
            }
        }
    }

    public void runTest(int key) {
        tests.get(key).questions.stream()
                .map(Question::processQuestion)
                .forEach(bool -> {
                    if (bool) System.out.println(RIGHT_ANSWER);
                    else System.out.println(BAD_ANSWER);
        });
        tests.get(key).setCompleteAndCollectStats(new ArrayList<>(tests.get(key).questions));
        showTests();
    }
}
