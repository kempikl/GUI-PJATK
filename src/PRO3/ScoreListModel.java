package PRO3;

import javax.swing.*;
import java.util.List;

public class ScoreListModel extends DefaultListModel<String> {
    public ScoreListModel(List<ScoreRecord> scores) {
        super();
        for (int i = 0; i < scores.size(); i++) {
            this.addElement(i + 1 + ". " + scores.get(i).playerName() + " : " + scores.get(i).score() + " pkt");
        }
    }
}
