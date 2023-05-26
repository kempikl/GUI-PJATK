package PRO2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ListPanel extends JPanel {
    protected final List<JPanel> panels;

    public ListPanel() {
        panels = new ArrayList<>();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(168,218,220));
    }

    protected void addPanel(JPanel panel) {
        JPanel panelContainer = new JPanel(new GridBagLayout());
        panelContainer.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        panelContainer.add(panel, gbc);

        panelContainer.setPreferredSize(new Dimension(panelContainer.getPreferredSize().width, 110));
        panelContainer.setMaximumSize(new Dimension(panelContainer.getMaximumSize().width, 110));
        panelContainer.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(2, 2, 2, 2),
                new LineBorder(new Color(230, 57, 70), 2)
        ));

        add(panelContainer);
        panels.add(panelContainer);

        revalidate();
        repaint();
    }

    protected void removePanel(JPanel panel) {
        panels.stream()
                .filter(p -> Arrays.asList(p.getComponents()).contains(panel))
                .findFirst()
                .ifPresent(this::removePanelContainer);
    }

    private void removePanelContainer(JPanel panel) {
        remove(panel);
        panels.remove(panel);
        revalidate();
        repaint();
    }
}
