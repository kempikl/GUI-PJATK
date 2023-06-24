package PRO3;

import javax.swing.*;
import java.util.List;

public class ScoreWindow extends JFrame {

    public ScoreWindow(List<ScoreRecord> scoreRecordList) {
        ScoreList scoreList = new ScoreList(scoreRecordList);

        this.setTitle("Top 10");
        this.setSize(300, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getContentPane().add(new JScrollPane(scoreList));

        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
