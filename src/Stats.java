public class Stats {
    private int answersCount;
    private int rightAnswersCount;

    public Stats() {
        this.answersCount = 0;
        this.rightAnswersCount = 0;
    }

    public int getAnswersCount() {
        return answersCount;
    }

    public void addAnswersCount() {
        this.answersCount++;
    }

    public int getRightAnswersCount() {
        return rightAnswersCount;
    }

    public void addRightAnswersCount() {
        this.rightAnswersCount++;
    }
}
