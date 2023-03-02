import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question {
    String q;
    Map<Integer, String> answers;
    String rightAnswer;
    boolean isAnswered = false; // для дальнейшего функционала
    boolean rightAnswered = false; // для дальнейшего функционала

    public Question(String q, List<String> listA, String rightAnswer) {
        this.q = q;
        if (answers == null) {
            answers = new HashMap<>();
            listA.forEach(a -> answers.put(listA.indexOf(a) + 1, a));
        }
        this.rightAnswer = rightAnswer;
    }

}
