package PRO1;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Piece[][] board;
    private List<IBoardObserver> observers;

    public Board() {
        board = new Piece[8][8];
        observers = new ArrayList<>();
    }

    public Piece getPiece(int row, int col) {
        if (isValidCoordinate(row) && isValidCoordinate(col)) {
            return board[row][col];
        }
        return null;
    }

    public void setPiece(Piece piece, int row, int col) {
        if (isValidCoordinate(row) && isValidCoordinate(col)) {
            board[row][col] = piece;
            if (piece != null) {
                piece.setPosition(row, col);
            }
            notifyObservers();
        }
    }

    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
        if (!isValidCoordinate(fromRow) || !isValidCoordinate(fromCol) || !isValidCoordinate(toRow) || !isValidCoordinate(toCol)) {
            return false;
        }

        Piece piece = getPiece(fromRow, fromCol);
        if (piece == null) {
            return false;
        }

        Piece targetPiece = getPiece(toRow, toCol);
        if (targetPiece != null && piece.isWhite() == targetPiece.isWhite()) {
            return false;
        }

        return true;
    }

    public void addObserver(IBoardObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IBoardObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (IBoardObserver observer : observers) {
            observer.onBoardChanged(this);
        }
    }

    private boolean isValidCoordinate(int coord) {
        return coord >= 0 && coord < 8;
    }

    public void initializeBoard() {
        // Umieść piony
        for (int col = 0; col < 8; col++) {
            setPiece(new Pawn(false), 1, col);
            setPiece(new Pawn(true), 6, col);
        }

        // Umieść wieże
        setPiece(new Rook(false), 0, 0);
        setPiece(new Rook(false), 0, 7);
        setPiece(new Rook(true), 7, 0);
        setPiece(new Rook(true), 7, 7);

        // Umieść skoczki
        setPiece(new Knight(false), 0, 1);
        setPiece(new Knight(false), 0, 6);
        setPiece(new Knight(true), 7, 1);
        setPiece(new Knight(true), 7, 6);

        // Umieść gońców
        setPiece(new Bishop(false), 0, 2);
        setPiece(new Bishop(false), 0, 5);
        setPiece(new Bishop(true), 7, 2);
        setPiece(new Bishop(true), 7, 5);

        // Umieść hetmanów
        setPiece(new Queen(false), 0, 3);
        setPiece(new Queen(true), 7, 3);

        // Umieść królów
        setPiece(new King(false), 0, 4);
        setPiece(new King(true), 7, 4);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  a b c d e f g h\n");
        for (int row = 0; row < 8; row++) {
            sb.append(8 - row).append(" ");
            for (int col = 0; col < 8; col++) {
                Piece piece = getPiece(row, col);
                if (piece == null) {
                    sb.append(".");
                } else {
                    sb.append(piece.getSymbol());
                }
                sb.append(" ");
            }
            sb.append(8 - row).append("\n");
        }
        sb.append("  a b c d e f g h\n");
        return sb.toString();
    }
}
