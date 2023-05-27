package PRO2;

import javax.swing.*;
import java.awt.*;

public class Main {

    private final Storage storage = new Storage(99);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Fabryka Balonów");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Lewy panel
        JPanel leftPanel = new LeftPanel(storage);

        // Prawy panel
        JPanel rightPanel = new RightPanel(storage);

        // Centralny panel
        JPanel centerPanel = new CenterPanel(storage);

        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.EAST);
        frame.add(centerPanel, BorderLayout.CENTER);

        frame.setSize(850, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
