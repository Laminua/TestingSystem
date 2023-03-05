import java.util.Scanner;

public class QuestionInputAnswer implements Question{
    String q;
    String rightAnswer;
    Scanner scanner = new Scanner(System.in);
    boolean isAnswered = false;
    boolean isRightAnswered = false;

    public QuestionInputAnswer(String question, String rightAnswer) {
        this.q = question;
        this.rightAnswer = rightAnswer;
    }
    @Override
    public String processQuestion() {
        boolean answered = false;
        String answer = null;

        System.out.println(this.q);

        System.out.print("\nВведи пропущенное слово и нажми Enter: ");

        while (!answered) {
            String userAnswer = scanner.nextLine();
            if (rightAnswer.equalsIgnoreCase(userAnswer)) {
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
