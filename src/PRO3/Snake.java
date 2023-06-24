package PRO3;

import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;

public class Snake {
    private final Deque<Point> body;
    private SnakeDirection direction;

    public Snake() {
        this.body = new LinkedList<>();
        this.direction = SnakeDirection.RIGHT;
        this.body.add(new Point(0, 0));
    }

    public Deque<Point> getBody() {
        return body;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public void move(Food food, GameBoard board) {
        Point head = body.peekFirst();

        Point newPoint = new Point(head.x + direction.getDx(), head.y + direction.getDy());

        if (isOutsideBoard(newPoint, board) || isBodyCollision(newPoint)) {
            new SnakeCollisionEvent(this);
        } else {
            body.addFirst(newPoint);

            if (!isFoodEaten(newPoint, food))
                body.removeLast();
            else new FoodEatenEvent(food);
        }
    }

    private boolean isFoodEaten(Point head, Food food) {
        if (head.equals(food.getLocation())) {
            food.generateNewLocation();
            return true;
        } else return false;
    }

    private boolean isOutsideBoard(Point head, GameBoard board) {
        return head.x < 0 || head.x >= board.getColumnCount() || head.y < 0 || head.y >= board.getRowCount();
    }

    public boolean isBodyCollision(Point point) {
        return body.contains(point);
    }
}
