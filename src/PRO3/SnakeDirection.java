package PRO3;

public enum SnakeDirection {
    UP(0, -1),
    RIGHT(1, 0),
    DOWN(0, 1),
    LEFT(-1, 0);

    private final int dx;
    private final int dy;

    SnakeDirection(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public boolean isOpposite(SnakeDirection other) {
        return dx + other.dx == 0 && dy + other.dy == 0;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}
