package PRO2;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {
    private final FactoryListPanel factoryListPanel;

    LeftPanel(Storage storage) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(250, getPreferredSize().height));

        factoryListPanel = new FactoryListPanel();
        JScrollPane factoryScrollPane = new JScrollPane(factoryListPanel);

        JButton addFactoryButton = new JButton("Dodaj fabrykę");
        addFactoryButton.addActionListener(e -> {
            Factory factory = new Factory(storage);
            FactoryPanel[] factoryPanel = new FactoryPanel[1];
            factoryPanel[0] = new FactoryPanel(factory, () -> {
                factoryListPanel.removeFactoryPanel(factoryPanel[0]);
                factory.stop();
            });
            factoryListPanel.addFactoryPanel(factoryPanel[0]);
            new Thread(factory).start();
        });


        add(factoryScrollPane, BorderLayout.CENTER);
        add(addFactoryButton, BorderLayout.SOUTH);
    }
}
