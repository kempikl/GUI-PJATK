package PRO2;

import javax.swing.*;

public class FactoryPanel extends JPanel {

    FactoryPanel(Factory factory, Runnable removeCallback) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JLabel balloonCountLabel = new JLabel("Baloons produced: 0");
        new Thread(() -> {
            while (true) {
                SwingUtilities.invokeLater(() ->
                        balloonCountLabel.setText("Baloons produced: " + factory.getBalloonCount()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();

        JSlider productionTimeSlider = new JSlider(100, 3000, factory.getProductionTime());
        productionTimeSlider.addChangeListener(e ->
                factory.setProductionTime(productionTimeSlider.getValue()));

        JButton removeButton = new JButton("Remove factory");
        removeButton.addActionListener(e -> removeCallback.run());

        add(balloonCountLabel);
        add(productionTimeSlider);
        add(removeButton);
    }
}
