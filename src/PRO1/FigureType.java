package PRO1;

public enum FigureType {
    PAWN(0),
    KING(1),
    QUEEN(2),
    ROOK(3),
    BISHOP(4),
    KNIGHT(5);

    private final int numeric;

    FigureType(int numeric) {
        this.numeric = numeric;
    }

    public int getNumeric() {
        return numeric;
    }
}
