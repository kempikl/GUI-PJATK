package PRO3;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class GameTable extends JTable {

    public GameTable(GameBoard gameBoard) {
        setModel(new GameTableModel(gameBoard));

        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (value == CellStatus.EMPTY) {
                    c.setBackground(new Color(244, 244, 248));
                } else if (value == CellStatus.SNAKE) {
                    c.setBackground(new Color(42, 183, 202, 204));
                } else if (value == CellStatus.HEAD) {
                    c.setBackground(new Color(254, 215, 102));
                } else if (value == CellStatus.FOOD) {
                    c.setBackground(new Color(254, 74, 73));
                }

                return c;
            }
        });

        setCellSelectionEnabled(false);
    }

    public void updateGameBoard() {
        ((AbstractTableModel) getModel()).fireTableDataChanged();
    }
}
