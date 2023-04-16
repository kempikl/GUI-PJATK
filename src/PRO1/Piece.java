package PRO1;

import java.util.List;

public abstract class Piece implements IMovable {
    protected int row;
    protected int col;
    protected boolean isWhite;

    /**
     * Konstruktor klasy Piece.
     *
     * @param row     Współrzędna wiersza figury.
     * @param col     Współrzędna kolumny figury.
     * @param isWhite Czy figura jest białym graczem (true) czy czarnym (false).
     */
    public Piece(int row, int col, boolean isWhite) {
        this.row = row;
        this.col = col;
        this.isWhite = isWhite;
    }

    /**
     * Konstruktor klasy Piece.
     *
     * @param isWhite Czy figura jest białym graczem (true) czy czarnym (false).
     */
    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
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
     * Sprawdza, czy figura jest czarnym graczem.
     *
     * @return true, jeśli figura jest czarnym graczem, false w przeciwnym przypadku.
     */
    public boolean isBlack() {
        return !isWhite;
    }

    /**
     * Zwraca współrzędną wiersza figury.
     *
     * @return Współrzędna wiersza figury.
     */
    public int getRow() {
        return row;
    }

    /**
     * Zwraca współrzędną kolumny figury.
     *
     * @return Współrzędna kolumny figury.
     */
    public int getCol() {
        return col;
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

    @Override
    public abstract List<int[]> getPossibleMoves(Board board);

    public abstract char getSymbol();
}

