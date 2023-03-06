import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QuestionChooseOneVar implements Question {
    String q;
    Map<Integer, String> answers;
    int rightAnswerKey;
    Scanner scanner;
    Stats stats = new Stats();

    public QuestionChooseOneVar(String question, List<String> listOfAnswers, int rightAnswerKey, Scanner scanner) {
        this.q = question;
        answers = listOfAnswers.stream()
                .collect(Collectors.toMap((a -> listOfAnswers.indexOf(a) + 1), Function.identity()));
        this.rightAnswerKey = rightAnswerKey;
        this.scanner = scanner;
    }

    @Override
    public boolean processQuestion() {

        System.out.println(this.q);
        this.answers
                .forEach((key, value) -> System.out.println(key + " : " + value));
        System.out.print("\nВыбери один вариант: ");

        boolean acceptInput = false;
        int choice = 0;

        while (!acceptInput) {

            try {
                choice = scanner.nextInt();
                if (answers.containsKey(choice)) {
                    acceptInput = true;
                } else {
                    System.err.println("Введи число от 1 до " + answers.size());
                }
            } catch (InputMismatchException e) {
                System.err.println("Введи число!");
                scanner.next();
            }
        }
        boolean selected = false;
        boolean isRight = false;

        while (!selected) {
                if (choice == rightAnswerKey) {
                    stats.setStats(true);
                    isRight = true;
                    selected = true;
                } else {
                    stats.setStats(false);
                    selected = true;
                }
        }
        scanner.nextLine();
        return isRight;
    }

    @Override
    public Stats getStats() {
        return stats;
    }
}

