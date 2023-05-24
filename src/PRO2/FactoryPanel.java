package PRO2;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class FactoryPanel extends JPanel {

    FactoryPanel(Factory factory, Runnable removeCallback) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridwidth = GridBagConstraints.REMAINDER;

        JLabel balloonNameLabel = new JLabel("Fabryka " + factory.getNumber());

        JLabel balloonCountLabel = new JLabel("Wyprodukowane balony: 0");
        new Thread(() -> {
            while (true) {
                SwingUtilities.invokeLater(() ->
                        balloonCountLabel.setText("Wyprodukowane balony: " + factory.getBalloonCount()));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();

        JSlider productionTimeSlider = new JSlider(100, 3000, factory.getProductionTime());
        productionTimeSlider.addChangeListener(e ->
                factory.setProductionTime(productionTimeSlider.getValue()));

        JButton removeButton = new JButton("Usuń fabrykę");
        removeButton.addActionListener(e -> removeCallback.run());

        add(balloonNameLabel, gbc);
        add(Box.createVerticalStrut(5), gbc);
        add(balloonCountLabel, gbc);
        add(Box.createVerticalStrut(5), gbc);
        add(productionTimeSlider, gbc);
        add(Box.createVerticalStrut(5), gbc);
        add(removeButton, gbc);
    }
}
