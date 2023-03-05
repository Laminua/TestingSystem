public interface Question {
    String RIGHT_ANSWER = "Правильный ответ";
    String BAD_ANSWER = "Неправильный ответ";
    String processQuestion();
    boolean getIsAnswered();
    boolean getIsRightAnswered();
}
