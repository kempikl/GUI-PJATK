package PRO3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ScoreManager {
    private static final int MAX_SCORES = 10;
    private static final String SCORE_FILE = "scores.dat";
    private final List<ScoreRecord> scores;

    public ScoreManager() {
        scores = new ArrayList<>();
        loadScores();
    }

    public void addScore(String playerName, int score) {
        if (!(playerName == null || playerName.equals(""))) {
            scores.add(new ScoreRecord(playerName, score));
            scores.sort(Comparator.comparing(ScoreRecord::score).reversed());
            if (scores.size() > MAX_SCORES) {
                scores.remove(MAX_SCORES);
            }
            saveScores();
        }
    }

    public List<ScoreRecord> getScores() {
        return new ArrayList<>(scores);
    }

    private void loadScores() {
        try (FileInputStream fis = new FileInputStream(SCORE_FILE)) {
            int count;
            while ((count = fis.read()) != -1) {
                byte[] playerNameBytes = new byte[count];
                fis.read(playerNameBytes);
                String playerName = new String(playerNameBytes);
                int score = fis.read() << 24 | fis.read() << 16 | fis.read() << 8 | fis.read();
                scores.add(new ScoreRecord(playerName, score));
            }
        } catch (IOException ignored) {

        }
    }

    private void saveScores() {
        try (FileOutputStream fos = new FileOutputStream(SCORE_FILE)) {
            for (ScoreRecord record : scores) {
                byte[] playerNameBytes = record.playerName().getBytes();
                fos.write(playerNameBytes.length);
                fos.write(playerNameBytes);
                fos.write(record.score() >> 24);
                fos.write(record.score() >> 16);
                fos.write(record.score() >> 8);
                fos.write(record.score());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
