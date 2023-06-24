package PRO3;

public interface GameEventListener {
    void handleGameTickEvent(GameTickEvent event);

    void handleSnakeCollisionEvent(SnakeCollisionEvent event);

    void handleFoodEatenEvent(FoodEatenEvent event);

    void handleScoreChangeEvent(ScoreChangeEvent event);
}
