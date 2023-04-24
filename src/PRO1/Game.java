package PRO1;

public class Game {
    private final Board board;
    private final Player whitePlayer;
    private final Player blackPlayer;
    private Player currentPlayer;
    private GameObserver observer;

    public Game(Board board, String whitePlayerName, String blackPlayerName) {
        this.board = board;
        this.whitePlayer = new Player(true, whitePlayerName);
        this.blackPlayer = new Player(false, blackPlayerName);
        this.currentPlayer = whitePlayer;

        board.initializeBoard();
    }

    public void play(int[] move) {
        if (makeMove(move)) {
            if (isOpponentInCheck()) {
                if (isOpponentInCheckmate()) observer.onCheckmate(currentPlayer.getName());
                observer.onCheck();
            }
            System.out.println("Ruch wykonany.");
            switchPlayer();
        } else {
            System.out.println("Nieprawidłowy ruch. Spróbuj ponownie.");
        }
        observer.gameChanged(currentPlayer.getName());
    }

    public String getCurrentPlayerName() {
        return currentPlayer.getName();
    }

    public boolean makeMove(int[] move) {
        return currentPlayer.movePiece(board, move[0], move[1], move[2], move[3]);
    }

    public boolean isOpponentInCheckmate() {
        Player opponent = currentPlayer == whitePlayer ? blackPlayer : whitePlayer;
        return opponent.isKingInCheckmate(board);
    }

    public boolean isOpponentInCheck() {
        Player opponent = currentPlayer == whitePlayer ? blackPlayer : whitePlayer;
        return opponent.isKingInCheck(board);
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == whitePlayer) ? blackPlayer : whitePlayer;
    }

    public Board getBoard() {
        return board;
    }

    public void setObserver(GameObserver gameObserver) {
        this.observer = gameObserver;
    }
}

