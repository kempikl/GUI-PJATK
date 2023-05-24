package PRO2;

import javax.swing.*;

public class RightPanel extends SidePanel {
    private TransporterListPanel transporterListPanel;

    RightPanel(Storage storage) {
        super();
        createListPanel(storage);
        addComponents();
    }

    @Override
    protected void createListPanel(Storage storage) {
        transporterListPanel = new TransporterListPanel();
        listScrollPane = new JScrollPane(transporterListPanel);

        addButton = new JButton("Dodaj Transporter");
        addButton.addActionListener(e -> {
            Transporter transporter = new Transporter(storage);
            TransporterPanel[] transporterPanel = new TransporterPanel[1];
            transporterPanel[0] = new TransporterPanel(transporter, () -> {
                transporterListPanel.removeTransporterPanel(transporterPanel[0]);
                transporter.stop();
            });
            transporterListPanel.addTransporterPanel(transporterPanel[0]);
            new Thread(transporter).start();
        });
    }
}
