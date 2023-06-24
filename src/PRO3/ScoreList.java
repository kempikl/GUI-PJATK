package PRO3;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ScoreList extends JList<String> {
    public ScoreList(List<ScoreRecord> scores) {
        super(new ScoreListModel(scores));
        this.setFont(new Font("Serif", Font.PLAIN, 18));
        this.setBackground(new Color(244, 244, 248));
    }
}
