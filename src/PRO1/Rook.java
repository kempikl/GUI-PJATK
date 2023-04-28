package PRO1;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Figure {
    /**
     * Konstruktor klasy Rook.
     *
     * @param isWhite Czy wieża należy do białego gracza (true) czy czarnego (false).
     */
    public Rook(boolean isWhite) {
        super(isWhite);
        figureType = FigureType.ROOK;
    }

    @Override
    public List<int[]> getPossibleMoves(Board board) {
        List<int[]> moves = new ArrayList<>();

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
        if (isWhite) return '\u2656';
        else return '\u265C';
    }

    /**
     * Dodaje ruch o współrzędnych (newRow, newCol) do listy ruchów, jeśli jest dozwolony.
     * Zwraca true, jeśli ruch napotkał na inną figurę (czyli wieża nie może dalej się poruszać w tym kierunku).
     *
     * @param board   Plansza szachowa.
     * @param newRow  Współrzędna wiersza docelowej pozycji.
     * @param newCol  Współrzędna kolumny docelowej pozycji.
     * @param moves   Lista dozwolonych ruchów.
     * @return true, jeśli ruch napotkał na inną figurę, false w przeciwnym przypadku.
     */
    private boolean addMoveIfValid(Board board, int newRow, int newCol, List<int[]> moves) {
        if (board.isValidMove(row, col, newRow, newCol)) {
            moves.add(new int[]{newRow, newCol});
            return true;
        }
        return false;
    }
}

