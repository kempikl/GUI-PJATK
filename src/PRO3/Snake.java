package PRO3;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class Snake {
    private Queue<Point> body; // używamy kolejki do przechowywania segmentów ciała węża
    private int direction; // kierunek, w którym porusza się wąż

    public Snake() {
        this.body = new LinkedList<Point>();
        this.direction = 0; // na początek ustawiamy kierunek na 0
        this.body.add(new Point(0, 0)); // na początku wąż ma jeden segment
    }

    public Queue<Point> getBody() {
        return body;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void move() {
        Point head = body.peek(); // aktualna głowa węża
        Point newPoint = switch (direction) {
            case 0 -> // w górę
                    new Point(head.x, head.y - 1);
            case 1 -> // w prawo
                    new Point(head.x + 1, head.y);
            case 2 -> // w dół
                    new Point(head.x, head.y + 1);
            case 3 -> // w lewo
                    new Point(head.x - 1, head.y);
            default -> null;

            // w zależności od kierunku dodajemy nowy punkt na początek ciała węża
        };

        // dodajemy nowy punkt na początek ciała węża
        body.add(newPoint);

        // usuwamy ostatni element ciała węża, chyba że wąż zjadł jedzenie
        // w takim przypadku nie usuwamy ostatniego elementu, więc wąż "rośnie"
        // to można zaimplementować poprzez dodanie warunku sprawdzającego, czy wąż zjadł jedzenie
        body.remove();
    }

    public boolean checkCollision() {
        // sprawdzamy, czy wąż uderzył w siebie lub w ścianę
        // to można zaimplementować poprzez sprawdzenie, czy nowa głowa węża jest poza planszą lub na innym segmencie ciała węża
        // na razie zwrócimy false
        return false;
    }
}

