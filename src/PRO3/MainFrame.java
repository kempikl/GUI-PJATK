package PRO3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainFrame implements GameEventListener {
    private final GameTable gameTable;
    private final GameController gameController;

    public MainFrame(GameBoard gameBoard, GameController gameController) {
        this.gameTable = new GameTable(gameBoard);
        this.gameController = gameController;
        this.gameTable.addKeyListener(gameController);
        GameEvent.addListener(this);
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.X_AXIS));
        tablePanel.add(gameTable);

        ScorePanel scorePanel = new ScorePanel();

        frame.add(tablePanel, BorderLayout.CENTER);
        frame.add(scorePanel, BorderLayout.NORTH);
        tablePanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent componentEvent) {
                int height = tablePanel.getHeight();
                int rowHeight = height / gameTable.getRowCount();
                gameTable.setRowHeight(rowHeight);
            }
        });

        frame.setSize(750, 510);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void handleGameTickEvent(GameTickEvent event) {
        gameTable.updateGameBoard();
    }

    @Override
    public void handleSnakeCollisionEvent(SnakeCollisionEvent event) {
        SwingUtilities.invokeLater(() -> {
            String userName = new UserNameDialog(gameController.getScore()).getUserName();
            gameController.addScore(userName);

            SwingUtilities.invokeLater(() -> new ScoreWindow(gameController.getScoreRecordList()));
        });
    }

    @Override
    public void handleFoodEatenEvent(FoodEatenEvent event) {
    }

    @Override
    public void handleScoreChangeEvent(ScoreChangeEvent event) {
    }
}
