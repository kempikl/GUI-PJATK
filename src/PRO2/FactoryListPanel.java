package PRO2;

import javax.swing.*;

public class FactoryListPanel extends JPanel {

    FactoryListPanel() {
        BoxLayout layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        setLayout(layout);
    }

    void addFactoryPanel(FactoryPanel factoryPanel) {
        add(factoryPanel);
        revalidate();
    }

    void removeFactoryPanel(FactoryPanel factoryPanel) {
        remove(factoryPanel);
        revalidate();
        repaint();
    }
}
