package PRO1;

public class Game {
    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    private Player currentPlayer;

    public Game(Board board, String whitePlayerName, String blackPlayerName) {
        this.board = board;
        this.whitePlayer = new Player(true, whitePlayerName);
        this.blackPlayer = new Player(false, blackPlayerName);
        this.currentPlayer = whitePlayer;

        board.initializeBoard();
    }

    public void play(int[] move) {
        if (makeMove(move)) {
            if (isOpponentInCheckmate()) {
                System.out.println("Szach-mat! Gracz " + currentPlayer.getName() + " wygrywa!");
                return;
            } else {
                System.out.println("Ruch wykonany.");
            }
        } else {
            System.out.println("Nieprawidłowy ruch. Spróbuj ponownie.");
        }
        switchPlayer();
    }

    public String getCurrentPlayerName() {
        return currentPlayer.getName();
    }

    public boolean makeMove(int[] move) {
        return currentPlayer.movePiece(board, move[0], move[1], move[2], move[3]);
    }

    public boolean isOpponentInCheckmate() {
        Player opponent = currentPlayer == whitePlayer ? blackPlayer : whitePlayer;
        return opponent.isKingInCheckmate(board, !currentPlayer.isWhite());
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == whitePlayer) ? blackPlayer : whitePlayer;
    }

    public Board getBoard() {
        return board;
    }
}

