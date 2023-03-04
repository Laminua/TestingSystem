import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestService {
    static final String CHOOSE_TEST = "Выбери тест: ";
    static final String AVAILABLE_TESTS = "Доступные тесты";
    Map<Integer, Test> tests;
    Scanner scanner = new Scanner(System.in);

    public TestService(List<Test> loT) {
        tests = loT.stream()
                .collect(Collectors.toMap((a -> loT.indexOf(a) + 1), Function.identity()));
    }

    public void showTests() {
        System.out.println(AVAILABLE_TESTS);
        tests.forEach((key, value) -> System.out.println(key + " : " + value.description));
        System.out.print(CHOOSE_TEST);

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

    public void runTest(int key) {
        tests.get(key).questions.stream()
                .map(Question::processQuestion)
                .forEach(System.out::println);
        tests.get(key).setCompleteAndCollectStats(new ArrayList<>(tests.get(key).questions));
        showTests();
    }
}
