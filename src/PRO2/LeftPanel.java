package PRO2;

import javax.swing.*;

public class LeftPanel extends SidePanel {
    private FactoryListPanel factoryListPanel;

    LeftPanel(Storage storage) {
        super();
        createListPanel(storage);
        addComponents();
    }

    @Override
    protected void createListPanel(Storage storage) {
        factoryListPanel = new FactoryListPanel();
        listScrollPane = new JScrollPane(factoryListPanel);

        addButton = new JButton("Dodaj fabrykę");
        addButton.addActionListener(e -> {
            Factory factory = new Factory(storage);
            FactoryPanel[] factoryPanel = new FactoryPanel[1];
            factoryPanel[0] = new FactoryPanel(factory, () -> {
                factoryListPanel.removeFactoryPanel(factoryPanel[0]);
                factory.stop();
            });
            factoryListPanel.addFactoryPanel(factoryPanel[0]);
            new Thread(factory).start();
        });
    }
}
