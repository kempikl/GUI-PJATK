package PRO3;

import java.awt.*;

public class GameBoard {
    private int[][] board;
    private Snake snake;
    private Food food;

    public static final int EMPTY = 0;
    public static final int SNAKE = 1;
    public static final int FOOD = 2;

    public GameBoard() {
        this.board = new int[25][16];
        this.snake = new Snake();
        this.food = new Food();

        // na początku plansza jest pusta
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 16; j++) {
                this.board[i][j] = EMPTY;
            }
        }

        // dodajemy węża i jedzenie do planszy
        this.addSnakeToBoard();
        this.addFoodToBoard();
    }

    private void addSnakeToBoard() {
        for (Point point : snake.getBody()) {
            this.board[point.x][point.y] = SNAKE;
        }
    }

    private void addFoodToBoard() {
        Point foodPoint = food.getLocation();
        this.board[foodPoint.x][foodPoint.y] = FOOD;
    }

    public int[][] getBoard() {
        return board;
    }

    public void updateBoard() {
        // czyscimy plansze
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 16; j++) {
                this.board[i][j] = EMPTY;
            }
        }

        // dodajemy na nowo węża i jedzenie
        this.addSnakeToBoard();
        this.addFoodToBoard();
    }
}

