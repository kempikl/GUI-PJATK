package PRO3;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard(16, 25);
        GameController gameController = new GameController(gameBoard);
        MainFrame mainFrame = new MainFrame(gameBoard, gameController);

        SwingUtilities.invokeLater(mainFrame::createAndShowGUI);

        gameController.startGame();
    }
}

