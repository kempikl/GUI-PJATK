package PRO1;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        // Stwórz obiekt gry
        Game game = new Game(board, "Player1", "Player2");

        // Stwórz interfejs tekstowy i przekaż obiekt gry
        TextUI textUI = new TextUI(game);

        board.addObserver(textUI);

        // Rozpocznij grę
        textUI.start();
    }
}

