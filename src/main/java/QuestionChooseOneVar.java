import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QuestionChooseOneVar implements Question {
    String q;
    Map<Integer, String> answers;
    String rightAnswer;
    Scanner scanner = new Scanner(System.in);
    boolean isAnswered = false;
    boolean isRightAnswered = false;

    public QuestionChooseOneVar(String question, List<String> listOfAnswers, String rightAnswer) {
        this.q = question;
        answers = listOfAnswers.stream()
                .collect(Collectors.toMap((a -> listOfAnswers.indexOf(a) + 1), Function.identity()));
        this.rightAnswer = rightAnswer;
    }

    @Override
    public String processQuestion() {
        boolean selected = false;
        String answer = null;

        System.out.println(this.q);
        this.answers
                .forEach((key, value) -> System.out.println(key + " : " + value));
        System.out.print("\nВыбери один вариант: ");

        while (!selected) {
            int choice = scanner.nextInt();
            if (this.answers.containsKey(choice)) {
                if (this.answers.get(choice).equals(this.rightAnswer)) {
                    selected = true;
                    answer = RIGHT_ANSWER;
                    isAnswered = true;
                    isRightAnswered = true;
                } else {
                    selected = true;
                    answer = BAD_ANSWER;
                    isAnswered = true;
                }
            } else {
                System.out.println("Недопустимый ответ, попробуй ещё раз");
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

