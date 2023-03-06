import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QuestionChooseMultipleVars implements Question {
    String q;
    Map<Integer, String> answers;
    List<Integer> rightAnswerKeys;
    Scanner scanner;
    Stats stats = new Stats();

    public QuestionChooseMultipleVars(String question,
                                      List<String> listOfAnswers,
                                      List<Integer> rightAnswerKeys,
                                      Scanner scanner) {
        this.q = question;
        answers = listOfAnswers.stream()
                .collect(Collectors.toMap((a -> listOfAnswers.indexOf(a) + 1), Function.identity()));
        this.rightAnswerKeys = rightAnswerKeys;
        this.scanner = scanner;
    }

    @Override
    public boolean processQuestion() {
        List<Integer> userAnswers = new ArrayList<>();
        System.out.println(this.q);
        this.answers
                .forEach((key, value) -> System.out.println(key + " : " + value));
        System.out.print("\nВведи номера подходящих вариантов в формате \"1 2 3\" и нажми Enter: ");

        boolean acceptInput = false;
        while (!acceptInput) {

            try {
                String lines = scanner.nextLine();
                String[] strs = lines.trim().split("\\s+");
                for (int i = 0; i < strs.length; i++) {
                    userAnswers.add(Integer.parseInt(strs[i]));
                    acceptInput = true;
                }
            } catch (NumberFormatException e) {
                System.err.println("Чё-то не то ты вводишь, давай ещё раз");
            }
        }

        boolean answered = false;
        boolean isRight = false;

        while (!answered) {
            if (userAnswers.containsAll(rightAnswerKeys)) {
                stats.setStats(true);
                isRight = true;
                answered = true;
            } else {
                stats.setStats(false);
                answered = true;
            }
        }
        return isRight;
    }

    @Override
    public Stats getStats() {
        return stats;
    }
}
