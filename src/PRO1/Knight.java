package PRO1;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    /**
     * Konstruktor klasy Knight.
     *
     * @param row     Współrzędna wiersza skoczka.
     * @param col     Współrzędna kolumny skoczka.
     * @param isWhite Czy skoczek należy do białego gracza (true) czy czarnego (false).
     */
    public Knight(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
    }

    /**
     * Konstruktor klasy Knight.
     *
     * @param isWhite Czy skoczek należy do białego gracza (true) czy czarnego (false).
     */
    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public List<int[]> getPossibleMoves(Board board) {
        List<int[]> moves = new ArrayList<>();
        int[][] possibleOffsets = {
                {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
                {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
        };

        for (int[] offset : possibleOffsets) {
            int newRow = row + offset[0];
            int newCol = col + offset[1];

            if (board.isValidMove(row, col, newRow, newCol)) {
                Piece targetPiece = board.getPiece(newRow, newCol);
                if (targetPiece == null || targetPiece.isWhite() != isWhite()) {
                    moves.add(new int[]{newRow, newCol});
                }
            }
        }

        return moves;
    }

    @Override
    public char getSymbol() {
        if (isWhite) return '\u2658';
        else return '\u265E';
    }
}