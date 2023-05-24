package PRO2;

import javax.swing.*;
import java.awt.*;

public abstract class SidePanel extends JPanel {
    protected JScrollPane listScrollPane;
    protected JButton addButton;
    protected final Dimension preferredSize = new Dimension(250, getPreferredSize().height);

    SidePanel() {
        setLayout(new BorderLayout());
        setPreferredSize(preferredSize);
    }

    protected abstract void createListPanel(Storage storage);

    protected void addComponents() {
        add(listScrollPane, BorderLayout.CENTER);
        add(addButton, BorderLayout.SOUTH);
    }
}
