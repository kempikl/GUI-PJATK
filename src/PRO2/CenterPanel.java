package PRO2;

import javax.swing.*;
import java.awt.*;

class CenterPanel extends JPanel {
    private final JLabel countLabel;
    private final JProgressBar progressBar;

    CenterPanel(Storage storage) {
        setBackground(new Color(241, 250, 238));
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Ilość balonów w magazynie", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        titleLabel.setForeground(new Color(29, 53, 87));

        countLabel = new JLabel("0", SwingConstants.CENTER);
        countLabel.setForeground(new Color(29, 53, 87));

        JLabel occupancyLabel = new JLabel("Zajętość magazynu", SwingConstants.CENTER);

        progressBar = new JProgressBar(0, 99);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        add(titleLabel, BorderLayout.NORTH);
        add(countLabel, BorderLayout.CENTER);
        add(occupancyLabel, BorderLayout.SOUTH);
        add(progressBar, BorderLayout.SOUTH);

        new Thread(() -> {
            while (true) {
                SwingUtilities.invokeLater(() -> {
                    int count = storage.getBaloonCount();
                    countLabel.setText(Integer.toString(count));
                    progressBar.setValue(count);
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();
    }
}

