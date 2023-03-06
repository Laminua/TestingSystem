import java.util.Scanner;

public class QuestionInputAnswer implements Question {
    String q;
    String rightAnswer;
    Scanner scanner;
    Stats stats = new Stats();

    public QuestionInputAnswer(String question, String rightAnswer, Scanner scanner) {
        this.q = question;
        this.rightAnswer = rightAnswer;
        this.scanner = scanner;
    }

    @Override
    public boolean processQuestion() {
        boolean answered = false;
        boolean isRight = false;

        System.out.println(this.q);

        System.out.print("\nВведи пропущенное слово и нажми Enter: ");

        while (!answered) {
            String userAnswer = scanner.nextLine();
            if (rightAnswer.equalsIgnoreCase(userAnswer)) {
                isRight = true;
                stats.setStats(true);
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
