import java.util.List;

public class Test {
    String description;
    List<Question> questions;
    boolean isComplete = false; // для дальнейшего функционала

    public Test(String description, List<Question> questions) {
        this.description = description;
        this.questions = questions;
    }
}
