package PRO3;

public class FoodEatenEvent extends GameEvent {
    public FoodEatenEvent(Object source) {
        super(source);
        for (GameEventListener listener : listeners) {
            listener.handleFoodEatenEvent(this);
        }
    }
}
