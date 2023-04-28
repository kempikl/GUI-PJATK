package PRO1;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Figure {
    /**
     * Konstruktor klasy Bishop.
     *
     * @param isWhite Czy goniec należy do białego gracza (true) czy czarnego (false).
     */
    public Bishop(boolean isWhite) {
        super(isWhite);
        figureType = FigureType.BISHOP;
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
            moves.add(new int[]{newRow, newCol});

            newRow += rowStep;
            newCol += colStep;
        }
    }
}
