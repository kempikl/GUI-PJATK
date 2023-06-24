package PRO3;

import javax.swing.table.AbstractTableModel;

public class GameTableModel extends AbstractTableModel {

    private final GameBoard gameBoard;

    public GameTableModel(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    @Override
    public int getRowCount() {
        return gameBoard.getRowCount();
    }

    @Override
    public int getColumnCount() {
        return gameBoard.getColumnCount();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return gameBoard.getCell(rowIndex, columnIndex);
    }
}
