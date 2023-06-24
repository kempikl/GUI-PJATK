package PRO3;

public record ScoreRecord(String playerName, int score) implements Comparable<ScoreRecord> {

    @Override
    public int compareTo(ScoreRecord o) {
        return Integer.compare(o.score(), this.score);
    }
}
