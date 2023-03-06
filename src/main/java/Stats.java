public class Stats {
    private boolean answered;
    private boolean rightAnswered;

    public void setStats(boolean isRight) {
        if (isRight) {
            answered = true;
            rightAnswered = true;
        } else {
            answered = true;
        }
    }

    public boolean isAnswered() {
        return answered;
    }

    public boolean isRightAnswered() {
        return rightAnswered;
    }
}
