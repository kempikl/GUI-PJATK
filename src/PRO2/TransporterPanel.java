package PRO2;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class TransporterPanel extends JPanel {
    private final JLabel statusLabel;

    TransporterPanel(Transporter transporter, Runnable removeCallback) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        statusLabel = new JLabel("Status: " + transporter.getStatus());
        new Thread(() -> {
            while (true) {
                SwingUtilities.invokeLater(() ->
                        statusLabel.setText("Status: " + transporter.getStatus()));
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();

        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> transporter.start());

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(e -> transporter.stop());

        JButton removeButton = new JButton("Usuń transporter");
        removeButton.addActionListener(e -> removeCallback.run());

        add(statusLabel);
        add(startButton);
        add(stopButton);
        add(removeButton);
    }
}
