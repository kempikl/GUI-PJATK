package PRO2;

import javax.swing.*;

public class LeftPanel extends SidePanel {
    private ListPanel ListPanel;

    LeftPanel(Storage storage) {
        super();
        createListPanel(storage);
        addComponents();
    }

    @Override
    protected void createListPanel(Storage storage) {
        ListPanel = new ListPanel();
        listScrollPane = new JScrollPane(ListPanel);

        addButton = new JButton("Dodaj fabrykę");
        addButton.addActionListener(e -> {
            Factory factory = new Factory(storage);
            FactoryPanel[] factoryPanel = new FactoryPanel[1];
            factoryPanel[0] = new FactoryPanel(factory, () -> {
                ListPanel.removePanel(factoryPanel[0]);
                factory.stop();
            });
            ListPanel.addPanel(factoryPanel[0]);
            new Thread(factory).start();
        });
    }
}
