package PRO1;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    /**
     * Konstruktor klasy King.
     *
     * @param row     Współrzędna wiersza króla.
     * @param col     Współrzędna kolumny króla.
     * @param isWhite Czy król należy do białego gracza (true) czy czarnego (false).
     */
    public King(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
    }

    /**
     * Konstruktor klasy King.
     *
     * @param isWhite Czy król należy do białego gracza (true) czy czarnego (false).
     */
    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public List<int[]> getPossibleMoves(Board board) {
        List<int[]> moves = new ArrayList<>();

        // Ruchy w pionie i poziomie
        addMoveIfValid(board, row + 1, col, moves);
        addMoveIfValid(board, row - 1, col, moves);
        addMoveIfValid(board, row, col + 1, moves);
        addMoveIfValid(board, row, col - 1, moves);

        // Ruchy po przekątnych
        addMoveIfValid(board, row + 1, col + 1, moves);
        addMoveIfValid(board, row + 1, col - 1, moves);
        addMoveIfValid(board, row - 1, col + 1, moves);
        addMoveIfValid(board, row - 1, col - 1, moves);

        return moves;
    }

    @Override
    public char getSymbol() {
        if (isWhite) return '\u2654';
        else return '\u265A';
    }

    /**
     * Dodaje ruch o współrzędnych (newRow, newCol) do listy ruchów, jeśli jest dozwolony.
     *
     * @param board  Plansza szachowa.
     * @param newRow Współrzędna wiersza docelowego.
     * @param newCol Współrzędna kolumny docelowej.
     * @param moves  Lista dozwolonych ruchów.
     */
    private void addMoveIfValid(Board board, int newRow, int newCol, List<int[]> moves) {
        if (board.isValidMove(row, col, newRow, newCol)) {
            Piece targetPiece = board.getPiece(newRow, newCol);
            if (targetPiece == null || isWhite() != targetPiece.isWhite()) {
                moves.add(new int[]{newRow, newCol});
            }
        }
    }
}

