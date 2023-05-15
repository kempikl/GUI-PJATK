package PRO2;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicLong;

class FactoryPanel extends JPanel {
    private final Factory factory;
    private final AtomicLong baloonCount = new AtomicLong();

    FactoryPanel(Factory factory) {
        this.factory = factory;
        setLayout(new BorderLayout());

        JLabel countLabel = new JLabel("Baloon count: 0");
        JSlider timeSlider = new JSlider(JSlider.HORIZONTAL, 100, 3000, 1000);
        JButton removeButton = new JButton("Remove");

        timeSlider.addChangeListener(e -> factory.setProductionTime(timeSlider.getValue()));
        removeButton.addActionListener(e -> factory.stop());

        add(countLabel, BorderLayout.NORTH);
        add(timeSlider, BorderLayout.CENTER);
        add(removeButton, BorderLayout.SOUTH);

        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                SwingUtilities.invokeLater(() -> countLabel.setText("Baloon count: " + baloonCount.get()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }

    void incrementBaloonCount() {
        baloonCount.incrementAndGet();
    }

    public Factory getFactory() {
        return factory;
    }
}

