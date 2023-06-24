package PRO3;

import java.util.EventObject;
import java.util.LinkedList;

public abstract class GameEvent extends EventObject {
    protected static LinkedList<GameEventListener> listeners = new LinkedList<>();

    public GameEvent(Object source) {
        super(source);
    }

    public static void addListener(GameEventListener listener) {
        listeners.add(listener);
    }
}
