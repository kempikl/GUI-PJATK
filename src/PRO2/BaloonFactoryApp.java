package PRO2;

import javax.swing.*;
import java.awt.*;

public class BaloonFactoryApp {

    private final Storage storage = new Storage(99);
    private final DefaultListModel<String> factoryModel = new DefaultListModel<>();
    private final DefaultListModel<String> transporterModel = new DefaultListModel<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BaloonFactoryApp().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Baloon Factory App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Left panel for factories
        JPanel leftPanel = new JPanel(new BorderLayout());
        JList<String> factoryList = new JList<>(factoryModel);
        JScrollPane factoryScrollPane = new JScrollPane(factoryList);
        JButton addFactoryButton = new JButton("Add Factory");
//        addFactoryButton.addActionListener(e -> {
//            FactoryPanel factoryPanel = new FactoryPanel(new Factory(storage, factoryPanel));
//            Thread factoryThread = new Thread(factoryPanel.getFactory());
//            factoryThread.start();
//            factoryModel.addElement(factoryPanel);
//        });
        leftPanel.add(factoryScrollPane, BorderLayout.CENTER);
        leftPanel.add(addFactoryButton, BorderLayout.SOUTH);

        // Right panel for transporters
        JPanel rightPanel = new JPanel(new BorderLayout());
        JList<String> transporterList = new JList<>(transporterModel);
        JScrollPane transporterScrollPane = new JScrollPane(transporterList);
        JButton addTransporterButton = new JButton("Add Transporter");
        addTransporterButton.addActionListener(e -> {
            Transporter transporter = new Transporter(storage);
            Thread transporterThread = new Thread(transporter);
            transporterThread.start();
            transporterModel.addElement("Transporter " + transporterModel.getSize());
        });
        rightPanel.add(transporterScrollPane, BorderLayout.CENTER);
        rightPanel.add(addTransporterButton, BorderLayout.SOUTH);

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

