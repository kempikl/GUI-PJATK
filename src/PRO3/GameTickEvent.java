package PRO3;

public class GameTickEvent extends GameEvent {
    public GameTickEvent(Object source) {
        super(source);
        for (GameEventListener listener : listeners) {
            listener.handleGameTickEvent(this);
        }
    }
}
