package PRO1;

import java.util.List;
import java.util.Scanner;

public class Player {
    private boolean isWhite;
    private String name;

    public Player(boolean isWhite, String name) {
        this.isWhite = isWhite;
        this.name = name;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean movePiece(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        Piece piece = board.getPiece(fromRow, fromCol);

        if (piece == null || piece.isWhite() != isWhite) {
            return false;
        }

        List<int[]> possibleMoves = piece.getPossibleMoves(board);
        for (int[] move : possibleMoves) {
            if (move[0] == toRow && move[1] == toCol) {
                Piece capturedPiece = board.getPiece(toRow, toCol);

                // Wykonaj tymczasowy ruch
                board.setPiece(piece, toRow, toCol);
                board.setPiece(null, fromRow, fromCol);

                // Sprawdź, czy ruch powoduje szach dla własnego króla
                if (isKingInCheck(board, isWhite)) {
                    // Jeśli tak, cofnij ruch i zwróć false
                    board.setPiece(piece, fromRow, fromCol);
                    board.setPiece(capturedPiece, toRow, toCol);
                    return false;
                }

                // Sprawdź roszadę
                if (piece instanceof King && Math.abs(fromCol - toCol) == 2) {
                    int rookCol = fromCol < toCol ? 7 : 0;
                    int newRookCol = fromCol < toCol ? toCol - 1 : toCol + 1;
                    Piece rook = board.getPiece(fromRow, rookCol);
                    if (rook instanceof Rook) {
                        board.setPiece(rook, fromRow, newRookCol);
                        board.setPiece(null, fromRow, rookCol);
                    }
                }

                // Sprawdź promocję piona
                if (piece instanceof Pawn && (toRow == 0 || toRow == 7)) {
                    Queen promotedPawn = new Queen(toCol, toRow, piece.isWhite());
                    board.setPiece(promotedPawn, toRow, toCol);
                }

                // Sprawdź, czy przeciwnik jest w szachu
                boolean opponentInCheck = isKingInCheck(board, !isWhite);
                if (opponentInCheck) {
                    System.out.println("Szach!");
                }

                // Sprawdź, czy przeciwnik jest w szach-macie
                boolean opponentInCheckmate = isKingInCheckmate(board, !isWhite);
                if (opponentInCheckmate) {
                    System.out.println("Szach-mat!");
                }

                return true;
            }
        }
        return false;
    }

    private boolean isKingInCheck(Board board, boolean isWhite) {
        int kingRow = -1;
        int kingCol = -1;

        // Znajdź współrzędne króla
        outerLoop:
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board.getPiece(row, col);
                if (piece instanceof King && piece.isWhite() == isWhite) {
                    kingRow = row;
                    kingCol = col;
                    break outerLoop;
                }
            }
        }

        // Sprawdź, czy którykolwiek z przeciwników może zaatakować króla
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board.getPiece(row, col);
                if (piece != null && piece.isWhite() != isWhite) {
                    List<int[]> possibleMoves = piece.getPossibleMoves(board);
                    for (int[] move : possibleMoves) {
                        if (move[0] == kingRow && move[1] == kingCol) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean isKingInCheckmate(Board board, boolean isWhite) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board.getPiece(row, col);
                if (piece != null && piece.isWhite() == isWhite) {
                    List<int[]> possibleMoves = piece.getPossibleMoves(board);
                    for (int[] move : possibleMoves) {
                        // Wykonaj tymczasowy ruch
                        Piece capturedPiece = board.getPiece(move[0], move[1]);
                        board.setPiece(piece, move[0], move[1]);
                        board.setPiece(null, row, col);

                        // Sprawdź, czy król jest wciąż w szachu
                        boolean kingInCheck = isKingInCheck(board, isWhite);

                        // Cofnij tymczasowy ruch
                        board.setPiece(piece, row, col);
                        board.setPiece(capturedPiece, move[0], move[1]);

                        if (!kingInCheck) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}


