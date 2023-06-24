package PRO3;

public class ScoreChangeEvent extends GameEvent {
    private final int score;

    public ScoreChangeEvent(Object source, int score) {
        super(source);
        this.score = score;
        for (GameEventListener listener : listeners) {
            listener.handleScoreChangeEvent(this);
        }
    }

    public int getScore() {
        return score;
    }
}
