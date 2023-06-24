package PRO3;

import java.awt.*;
import java.util.Iterator;

public class GameBoard implements GameEventListener {
    private final CellStatus[][] board;
    private final Snake snake;
    private final Food food;

    public GameBoard(int rowCount, int columnCount) {
        GameEvent.addListener(this);
        this.board = new CellStatus[rowCount][columnCount];
        this.snake = new Snake();
        this.food = new Food();

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                this.board[i][j] = CellStatus.EMPTY;
            }
        }

        addSnakeToBoard();
        addFoodToBoard();
    }

    private void addSnakeToBoard() {
        Iterator<Point> iterator = snake.getBody().iterator();
        Point head = iterator.next();

        this.board[head.y][head.x] = CellStatus.HEAD;

        while (iterator.hasNext()) {
            Point point = iterator.next();
            this.board[point.y][point.x] = CellStatus.SNAKE;
        }
    }


    private void addFoodToBoard() {
        Point foodPoint = food.getLocation();
        this.board[foodPoint.y][foodPoint.x] = CellStatus.FOOD;
    }

    public CellStatus[][] getBoard() {
        return board;
    }

    private void updateBoard() {
        snake.move(food, this);

        for (int i = 0; i < getRowCount(); i++) {
            for (int j = 0; j < getColumnCount(); j++) {
                this.board[i][j] = CellStatus.EMPTY;
            }
        }

        addSnakeToBoard();
        addFoodToBoard();
    }

    public CellStatus getCell(int rowIndex, int columnIndex) {
        return board[rowIndex][columnIndex];
    }

    public Snake getSnake() {
        return snake;
    }

    public int getRowCount() {
        return board.length;
    }

    public int getColumnCount() {
        return board[0].length;
    }

    @Override
    public void handleGameTickEvent(GameTickEvent event) {
        updateBoard();
    }

    @Override
    public void handleSnakeCollisionEvent(SnakeCollisionEvent event) {
    }

    @Override
    public void handleFoodEatenEvent(FoodEatenEvent event) {
    }

    @Override
    public void handleScoreChangeEvent(ScoreChangeEvent event) {
    }
}
