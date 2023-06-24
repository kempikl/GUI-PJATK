package PRO3;

import java.awt.*;
import java.util.Random;

public class Food {
    private final Random random;
    private Point location;

    public Food() {
        this.random = new Random();
        generateNewLocation();
    }

    public Point getLocation() {
        return location;
    }

    public void generateNewLocation() {
        this.location = new Point(random.nextInt(25), random.nextInt(16));
    }
}
