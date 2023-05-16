package PRO2;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class Transporter implements Runnable {
    private static final AtomicLong nextTransporterNumber = new AtomicLong();

    long number;
    private final Storage storage;
    private volatile TransporterStatus status;
    private volatile boolean running;

    Transporter(Storage storage) {
        number = nextTransporterNumber.incrementAndGet();
        this.storage = storage;
        this.status = TransporterStatus.WAITING;
        running = true;
    }

    @Override
    public void run() {
        while(running) {
            try {
                status = TransporterStatus.LOADING;
                long startTime = System.nanoTime();
                List<Baloon> baloons = storage.getBaloons(10);
                long endTime = System.nanoTime();
                long deliveryTime = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

                delivery(baloons, deliveryTime);

                status = TransporterStatus.WAITING;
                TimeUnit.MILLISECONDS.sleep(10000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void stop() {
        running = false;
    }

    public void start() {
        running = true;
        run();
    }

    private void delivery(List<Baloon> baloons, long deliveryTime) throws InterruptedException {
        status = TransporterStatus.DELIVERING;
        TimeUnit.MILLISECONDS.sleep(deliveryTime);

        for(Baloon baloon : baloons) {
            System.out.println(number + " - Transporting baloon number " + baloon.number + " of color " + baloon.color);
        }
        System.out.println("Time: " + deliveryTime);
    }

    public TransporterStatus getStatus() {
        return status;
    }
}
