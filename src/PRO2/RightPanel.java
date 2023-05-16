package PRO2;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {
    private final TransporterListPanel transporterListPanel;

    RightPanel(Storage storage) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(250, getPreferredSize().height));

        transporterListPanel = new TransporterListPanel();
        JScrollPane transporterScrollPane = new JScrollPane(transporterListPanel);

        JButton addTransporterButton = new JButton("Dodaj Transporter");
        addTransporterButton.addActionListener(e -> {
            Transporter transporter = new Transporter(storage);
            TransporterPanel[] transporterPanel = new TransporterPanel[1];
            transporterPanel[0] = new TransporterPanel(transporter, () -> {
                transporterListPanel.removeTransporterPanel(transporterPanel[0]);
                transporter.stop();
            });
            transporterListPanel.addTransporterPanel(transporterPanel[0]);
            new Thread(transporter).start();
        });

        add(transporterScrollPane, BorderLayout.CENTER);
        add(addTransporterButton, BorderLayout.SOUTH);
    }
}
