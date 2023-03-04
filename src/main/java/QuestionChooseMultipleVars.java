import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QuestionChooseMultipleVars implements Question {
    String q;
    Map<Integer, String> answers;
    List<String> rightAnswers;
    Scanner scanner = new Scanner(System.in);
    boolean isAnswered = false;
    boolean isRightAnswered = false;

    public QuestionChooseMultipleVars(String question, List<String> listOfAnswers, List<String> rightAnswers) {
        this.q = question;
        answers = listOfAnswers.stream()
                .collect(Collectors.toMap((a -> listOfAnswers.indexOf(a) + 1), Function.identity()));
        this.rightAnswers = rightAnswers;
    }

    @Override
    public String processQuestion() {
        boolean answered = false;
        String answer = null;
        List<String> userAnswers = new ArrayList<>();
        System.out.println(this.q);
        this.answers
                .forEach((key, value) -> System.out.println(key + " : " + value));
        System.out.print("\nВведи номера подходящих вариантов в формате \"1 2 3\" и нажми Enter: ");

        boolean acceptInput = false;
        while (!acceptInput) {

            try {
                String lines = scanner.nextLine();
                String[] strs = lines.trim().split("\\s+");
                int[] input = new int[strs.length];
                for (int i = 0; i < input.length; i++) {
                    input[i] = Integer.parseInt(strs[i]);
                    acceptInput = true;
                    userAnswers.add(answers.get(input[i]));
                }
            } catch (NumberFormatException e) {
                System.out.println("Чё-то не то ты вводишь, давай ещё раз");
            }
        }

        while (!answered) {
            if (this.rightAnswers.containsAll(userAnswers)) {
                answered = true;
                answer = RIGHT_ANSWER;
                isAnswered = true;
                isRightAnswered = true;
            } else {
                answered = true;
                answer = BAD_ANSWER;
                isAnswered = true;
            }
        }
        return answer;
    }

    @Override
    public boolean getIsAnswered() {
        return isAnswered;
    }

    @Override
    public boolean getIsRightAnswered() {
        return isRightAnswered;
    }
}
