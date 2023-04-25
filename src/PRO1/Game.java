package PRO1;

import java.util.Scanner;

public class Game {
    private final Board board;
    private final Player whitePlayer;
    private final Player blackPlayer;
    private Player currentPlayer;
    private  Player currentOpponent;
    private GameObserver observer;

    public Game(Board board, String whitePlayerName, String blackPlayerName) {
        this.board = board;
        this.whitePlayer = new Player(true, whitePlayerName);
        this.blackPlayer = new Player(false, blackPlayerName);
        this.currentPlayer = whitePlayer;
        this.currentOpponent = blackPlayer;

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
        return currentOpponent.isKingInCheckmate(board);
    }

    public boolean isOpponentInCheck() {
        return currentOpponent.isKingInCheck(board);
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == whitePlayer) ? blackPlayer : whitePlayer;
        currentOpponent = (currentPlayer == whitePlayer) ? blackPlayer : whitePlayer;
    }

    public void makeTie() {
        System.out.println(currentOpponent.getName() + ", czy zgadzasz się na remis? [t/n]");
        Scanner scanner = new Scanner(System.in);
        if (scanner.next().equals("t")) {
            System.out.println("Gra zakończona remisem");
            System.exit(0);
        }
        observer.gameChanged(currentPlayer.getName());
    }

    public Board getBoard() {
        return board;
    }

    public void setObserver(GameObserver gameObserver) {
        this.observer = gameObserver;
    }
}

