package PRO1;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Figure {
    /**
     * Konstruktor klasy Pawn.
     *
     * @param row     Współrzędna wiersza pionka.
     * @param col     Współrzędna kolumny pionka.
     * @param isWhite Czy pionek należy do białego gracza (true) czy czarnego (false).
     */
    public Pawn(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
    }

    /**
     * Konstruktor klasy Pawn.
     *
     * @param isWhite Czy pionek należy do białego gracza (true) czy czarnego (false).
     */
    public Pawn(boolean isWhite) {
        super(isWhite);
        figureType = FigureType.PAWN;
    }

    @Override
    public List<int[]> getPossibleMoves(Board board) {
        List<int[]> moves = new ArrayList<>();

        int direction = isWhite() ? -1 : 1;
        int newRow = row + direction;

        // Ruch o jedno pole do przodu
        if (board.isValidMove(row, col, newRow, col) && board.getFigure(newRow, col) == null) {
            moves.add(new int[]{newRow, col});

            // Ruch o dwa pola do przodu dla pionka, który jeszcze się nie ruszał
            int twoStepsRow = newRow + direction;
            if ((isWhite() && row == 6) || (!isWhite() && row == 1)) {
                if (board.isValidMove(row, col, twoStepsRow, col) && board.getFigure(twoStepsRow, col) == null) {
                    moves.add(new int[]{twoStepsRow, col});
                }
            }
        }

        // Bicie po skosie
        for (int newCol = col - 1; newCol <= col + 1; newCol += 2) {
            if (board.isValidMove(row, col, newRow, newCol)) {
                Figure targetFigure = board.getFigure(newRow, newCol);
                if (targetFigure != null && targetFigure.isWhite() != isWhite()) {
                    moves.add(new int[]{newRow, newCol});
                }
            }
        }

        return moves;
    }

    @Override
    public char getSymbol() {
        if (isWhite) return '\u2659';
        else return '\u265F';
    }
}

