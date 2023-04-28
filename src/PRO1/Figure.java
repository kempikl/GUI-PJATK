package PRO1;

import java.util.List;

public abstract class Figure implements Movable {
    protected int row;
    protected int col;
    protected final boolean isWhite;
    private final Color color;
    protected FigureType figureType;

    /**
     * Konstruktor klasy Piece.
     *
     * @param isWhite Czy figura jest białym graczem (true) czy czarnym (false).
     */
    public Figure(boolean isWhite) {
        this.isWhite = isWhite;
        color = isWhite ? Color.WHITE : Color.BLACK;
    }

    public static Figure createFigure(FigureType figureType, boolean isWhite) {
        return switch (figureType) {
            case PAWN -> new Pawn(isWhite);
            case KING -> new King(isWhite);
            case QUEEN -> new Queen(isWhite);
            case ROOK -> new Rook(isWhite);
            case BISHOP -> new Bishop(isWhite);
            case KNIGHT -> new Knight(isWhite);
        };
    }

    /**
     * Sprawdza, czy figura jest białym graczem.
     *
     * @return true, jeśli figura jest białym graczem, false w przeciwnym przypadku.
     */
    public boolean isWhite() {
        return isWhite;
    }

    /**
     * Ustawia nową pozycję figury.
     *
     * @param row Współrzędna wiersza docelowej pozycji.
     * @param col Współrzędna kolumny docelowej pozycji.
     */
    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public abstract List<int[]> getPossibleMoves(Board board);

    public abstract char getSymbol();
}

