package PRO2;


import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class CenterPanel extends JPanel {
    private final JLabel countLabel;
    private final JProgressBar progressBar;

    CenterPanel(Storage storage) {
        setBackground(new Color(241, 250, 238));
        setLayout(new GridBagLayout());

        JLabel titleLabel = new JLabel("Ilość balonów w magazynie");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        titleLabel.setForeground(new Color(29, 53, 87));

        countLabel = new JLabel("0");
        countLabel.setFont(new Font("Serif", Font.BOLD, 30));
        countLabel.setForeground(new Color(29, 53, 87));

        progressBar = new JProgressBar(0, 99);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.weighty = 1;
        add(titleLabel, gbc);

        gbc.weighty = 0;
        add(countLabel, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1;
        add(progressBar, gbc);

        new Thread(() -> {
            while (true) {
                SwingUtilities.invokeLater(() -> {
                    int count = storage.getBaloonCount();
                    countLabel.setText(Integer.toString(count));
                    progressBar.setValue(count);
                });
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();
    }
}
