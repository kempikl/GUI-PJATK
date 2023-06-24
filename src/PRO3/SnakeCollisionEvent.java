package PRO3;

public class SnakeCollisionEvent extends GameEvent {
    public SnakeCollisionEvent(Object source) {
        super(source);
        for (GameEventListener listener : listeners) {
            listener.handleSnakeCollisionEvent(this);
        }
    }
}
