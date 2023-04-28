package PRO1;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Figure {
    /**
     * Konstruktor klasy Queen.
     *
     * @param isWhite Czy hetman należy do białego gracza (true) czy czarnego (false).
     */
    public Queen(boolean isWhite) {
        super(isWhite);
        figureType = FigureType.QUEEN;
    }

    @Override
    public List<int[]> getPossibleMoves(Board board) {
        List<int[]> moves = new ArrayList<>();

        // Ruchy po przekątnych
        addDiagonalMoves(board, 1, 1, moves);
        addDiagonalMoves(board, 1, -1, moves);
        addDiagonalMoves(board, -1, 1, moves);
        addDiagonalMoves(board, -1, -1, moves);

        // Ruchy w pionie
        for (int newRow = row + 1; newRow <= 7; newRow++) {
            if (addMoveIfValid(board, newRow, col, moves)) {
                break;
            }
        }
        for (int newRow = row - 1; newRow >= 0; newRow--) {
            if (addMoveIfValid(board, newRow, col, moves)) {
                break;
            }
        }

        // Ruchy w poziomie
        for (int newCol = col + 1; newCol <= 7; newCol++) {
            if (addMoveIfValid(board, row, newCol, moves)) {
                break;
            }
        }
        for (int newCol = col - 1; newCol >= 0; newCol--) {
            if (addMoveIfValid(board, row, newCol, moves)) {
                break;
            }
        }

        return moves;
    }

    @Override
    public char getSymbol() {
        if (isWhite) return '\u2655';
        else return '\u265B';
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

    /**
     * Dodaje ruch o współrzędnych (newRow, newCol) do listy ruchów, jeśli jest dozwolony.
     * Zwraca `true`, jeśli ruch napotkał na inną figurę (co oznacza, że hetman nie może dalej się poruszać w tym kierunku) lub `false` w przeciwnym przypadku.
     *
     * @param board  Plansza szachowa.
     * @param newRow Współrzędna wiersza docelowego.
     * @param newCol Współrzędna kolumny docelowej.
     * @param moves  Lista dozwolonych ruchów.
     * @return `true`, jeśli ruch napotkał na inną figurę, `false` w przeciwnym przypadku.
     */
    private boolean addMoveIfValid(Board board, int newRow, int newCol, List<int[]> moves) {
        if (board.isValidMove(row, col, newRow, newCol)) {
            moves.add(new int[]{newRow, newCol});
            return true;
        }
        return false;
    }
}

