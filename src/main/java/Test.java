import java.util.Collection;
import java.util.List;

public class Test {
    String description;
    String info = "";
    List<Question> questions;
    boolean isComplete = false;
    long answersCount = 0;
    long rightAnswersCount = 0;

    public Test(String description, List<Question> questions) {
        this.description = description;
        this.questions = questions;
    }

    public void setCompleteAndCollectStats(Collection<Question> questionCollection) {
        isComplete = true;

        answersCount = questionCollection.stream()
                .map(Question::getStats)
                .map(Stats::isAnswered)
                .filter(b -> b)
                .count();
        rightAnswersCount = questionCollection.stream()
                .map(Question::getStats)
                .map(Stats::isRightAnswered)
                .filter(b -> b)
                .count();

        info = " * Пройден (Ответов: " + answersCount + " , из них верных: " + rightAnswersCount + ")";
    }

}
