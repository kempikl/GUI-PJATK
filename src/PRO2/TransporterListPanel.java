package PRO2;

import javax.swing.*;

public class TransporterListPanel extends JPanel {
    private final BoxLayout layout;

    TransporterListPanel() {
        layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        setLayout(layout);
    }

    void addTransporterPanel(TransporterPanel transporterPanel) {
        add(transporterPanel);
        revalidate();
    }

    void removeTransporterPanel(TransporterPanel transporterPanel) {
        remove(transporterPanel);
        revalidate();
        repaint();
    }
}
