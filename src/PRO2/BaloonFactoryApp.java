package PRO2;

import javax.swing.*;
import java.awt.*;

public class BaloonFactoryApp {

    private final Storage storage = new Storage(99);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BaloonFactoryApp().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Fabryka Balonów");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Lewy panel
        JPanel leftPanel = new LeftPanel(storage);

        // Right panel for transporters
        JPanel rightPanel = new RightPanel(storage);

        // Center panel for storage
        JTextArea storageTextArea = new JTextArea();
        JScrollPane storageScrollPane = new JScrollPane(storageTextArea);
        new Thread(() -> {
            while (true) {
                SwingUtilities.invokeLater(() -> storageTextArea.setText(storage.toString()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();

        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.EAST);
        frame.add(storageScrollPane, BorderLayout.CENTER);

        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

