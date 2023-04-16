package PRO1;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
    /**
     * Konstruktor klasy Bishop.
     *
     * @param row     Współrzędna wiersza gońca.
     * @param col     Współrzędna kolumny gońca.
     * @param isWhite Czy goniec należy do białego gracza (true) czy czarnego (false).
     */
    public Bishop(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
    }

    /**
     * Konstruktor klasy Bishop.
     *
     * @param isWhite Czy goniec należy do białego gracza (true) czy czarnego (false).
     */
    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public List<int[]> getPossibleMoves(Board board) {
        List<int[]> moves = new ArrayList<>();

        // Ruchy po przekątnych
        addDiagonalMoves(board, 1, 1, moves);
        addDiagonalMoves(board, 1, -1, moves);
        addDiagonalMoves(board, -1, 1, moves);
        addDiagonalMoves(board, -1, -1, moves);

        return moves;
    }

    @Override
    public char getSymbol() {
        if (isWhite) return '\u2657';
        else return '\u265D';
    }

    /**
     * Dodaje dozwolone ruchy po przekątnych do listy ruchów.
     *
     * @param board   Plansza szachowa.
     * @param rowStep Krok w kierunku wierszy (1 lub -1).
     * @param colStep Krok w kierunku kolumn (1 lub -1).
     * @param moves   Lista dozwolonych ruchów.
     */
    private void addDiagonalMoves(Board board, int rowStep, int colStep, List<int[]> moves) {
        int newRow = row + rowStep;
        int newCol = col + colStep;

        while (board.isValidMove(row, col, newRow, newCol)) {
            Piece targetPiece = board.getPiece(newRow, newCol);
            if (targetPiece == null) {
                moves.add(new int[]{newRow, newCol});
            } else {
                if (isWhite() != targetPiece.isWhite()) {
                    moves.add(new int[]{newRow, newCol});
                }
                break;
            }
            newRow += rowStep;
            newCol += colStep;
        }
    }
}
