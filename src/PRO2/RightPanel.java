package PRO2;

import javax.swing.*;

public class RightPanel extends SidePanel {
    private ListPanel ListPanel;

    RightPanel(Storage storage) {
        super();
        createListPanel(storage);
        addComponents();
    }

    @Override
    protected void createListPanel(Storage storage) {
        ListPanel = new ListPanel();
        listScrollPane = new JScrollPane(ListPanel);

        addButton = new JButton("Dodaj Transporter");
        addButton.addActionListener(e -> {
            Transporter transporter = new Transporter(storage);
            TransporterPanel[] transporterPanel = new TransporterPanel[1];
            transporterPanel[0] = new TransporterPanel(transporter, () -> {
                ListPanel.removePanel(transporterPanel[0]);
                transporter.stop();
            });
            ListPanel.addPanel(transporterPanel[0]);
            new Thread(transporter).start();
        });
    }
}
