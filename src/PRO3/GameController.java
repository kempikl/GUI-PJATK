package PRO3;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GameController extends KeyAdapter implements GameEventListener {

    private final Snake snake;
    private final ScoreManager scoreManager;
    private boolean isRunning;
    private int score;

    public GameController(GameBoard gameBoard) {
        GameEvent.addListener(this);
        this.snake = gameBoard.getSnake();
        this.isRunning = true;
        this.score = 0;
        this.scoreManager = new ScoreManager();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        SnakeDirection newDirection = switch (keyCode) {
            case KeyEvent.VK_UP -> SnakeDirection.UP;
            case KeyEvent.VK_RIGHT -> SnakeDirection.RIGHT;
            case KeyEvent.VK_DOWN -> SnakeDirection.DOWN;
            case KeyEvent.VK_LEFT -> SnakeDirection.LEFT;
            default -> null;
        };

        if (newDirection != null && !snake.getDirection().isOpposite(newDirection)) {
            snake.setDirection(newDirection);
        }
    }

    public void startGame() {
        new Thread(() -> {
            while (isRunning) {
                new GameTickEvent(this);
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();
    }

    public int getScore() {
        return score;
    }

    public List<ScoreRecord> getScoreRecordList() {
        return scoreManager.getScores();
    }

    public void addScore(String playerName) {
        scoreManager.addScore(playerName, score);
    }

    @Override
    public void handleGameTickEvent(GameTickEvent event) {
    }

    @Override
    public void handleSnakeCollisionEvent(SnakeCollisionEvent event) {
        isRunning = false;
    }

    @Override
    public void handleFoodEatenEvent(FoodEatenEvent event) {
        score++;
        new ScoreChangeEvent(this, score);
    }

    @Override
    public void handleScoreChangeEvent(ScoreChangeEvent event) {
    }
}
