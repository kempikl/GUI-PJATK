package PRO2;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class TransporterPanel extends JPanel {
    private final JLabel statusLabel;

    public TransporterPanel(Transporter transporter, Runnable removeCallback) {
        setOpaque(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridwidth = GridBagConstraints.REMAINDER;

        statusLabel = new JLabel("Status: " + transporter.getStatus());
        new Thread(() -> {
            while (true) {
                SwingUtilities.invokeLater(() ->
                        statusLabel.setText("Status: " + transporter.getStatus()));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();

        JLabel transporterNameLabel = new JLabel("Transporter " + transporter.number);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> transporter.resumeThread());

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(e -> transporter.pauseThread());

        JButton removeButton = new JButton("Usuń transporter");
        removeButton.addActionListener(e -> removeCallback.run());

        add(transporterNameLabel, gbc);
        add(Box.createVerticalStrut(3), gbc);
        add(statusLabel, gbc);
        add(Box.createVerticalStrut(5), gbc);

        gbc.gridwidth = 1;
        add(startButton, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(stopButton, gbc);

        add(Box.createVerticalStrut(5), gbc);
        add(removeButton, gbc);
    }
}
