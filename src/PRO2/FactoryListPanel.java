package PRO2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactoryListPanel extends JPanel {
    private final List<JPanel> factoryPanels;

    public FactoryListPanel() {
        factoryPanels = new ArrayList<>();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void addFactoryPanel(FactoryPanel factoryPanel) {
        // Create panelContainer using GridBagLayout
        JPanel panelContainer = new JPanel(new GridBagLayout());

        // Add factoryPanel to panelContainer
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        panelContainer.add(factoryPanel, gbc);

        // Set fixed height and border for panelContainer
        panelContainer.setPreferredSize(new Dimension(panelContainer.getPreferredSize().width, 110));
        panelContainer.setMaximumSize(new Dimension(panelContainer.getMaximumSize().width, 110));
        panelContainer.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(2, 2, 2, 2),
                new LineBorder(Color.BLACK, 2)
        ));

        // Add panelContainer to this panel
        add(panelContainer);
        factoryPanels.add(panelContainer);

        revalidate();
        repaint();
    }

    public void removeFactoryPanel(FactoryPanel factoryPanel) {
        factoryPanels.stream()
                .filter(panel -> Arrays.asList(panel.getComponents()).contains(factoryPanel))
                .findFirst()
                .ifPresent(this::removeFactoryPanelContainer);
    }

    private void removeFactoryPanelContainer(JPanel panel) {
        remove(panel);
        factoryPanels.remove(panel);
        revalidate();
        repaint();
    }
}


