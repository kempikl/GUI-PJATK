package PRO3;

import java.awt.Point;
import java.util.Random;

public class Food {
    private Point location;
    private Random random;

    public Food() {
        this.random = new Random();
        this.location = new Point(generateRandomCoordinate(), generateRandomCoordinate());
    }

    private int generateRandomCoordinate() {
        return random.nextInt(25); //TODO
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public void generateNewLocation() {
        this.location = new Point(generateRandomCoordinate(), generateRandomCoordinate());
    }
}

