package PRO2;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class Transporter implements Runnable {
    private static final AtomicLong nextTransporterNumber = new AtomicLong();

    public long number;
    private final Storage storage;
    private volatile TransporterStatus status;
    private volatile boolean running;
    private boolean isPaused;
    private final Object lock = new Object();

    Transporter(Storage storage) {
        number = nextTransporterNumber.incrementAndGet();
        status = TransporterStatus.WAITING;
        this.storage = storage;
        running = true;
        isPaused = false;
    }

    @Override
    public void run() {
        while(running) {
            try {
                synchronized (lock) {
                    if (isPaused) {
                        status = TransporterStatus.PAUSED;
                        lock.wait();
                    }

                    status = TransporterStatus.LOADING;
                    long startTime = System.nanoTime();
                    List<Baloon> baloons = storage.getBaloons(10);
                    long endTime = System.nanoTime();
                    long deliveryTime = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

                    delivery(baloons, deliveryTime);

                    if (!isPaused) {
                        status = TransporterStatus.WAITING;
                        TimeUnit.SECONDS.sleep(10);
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void stop() {
        running = false;
    }

    public void resumeThread() {
        synchronized (lock) {
            status = TransporterStatus.WAITING;
            isPaused = false;
            lock.notify();
        }
    }

    public void pauseThread() {
        isPaused = true;
    }

    private void delivery(List<Baloon> baloons, long deliveryTime) throws InterruptedException {
        status = TransporterStatus.DELIVERING;
        TimeUnit.MILLISECONDS.sleep(deliveryTime);

        System.out.println("Transporter nr. " + number);
        for(Baloon baloon : baloons) {
            System.out.println("Transport balonu nr " + baloon.number + " koloru " + baloon.color);
        }
        System.out.println("Czas: " + deliveryTime);
    }

    public TransporterStatus getStatus() {
        return status;
    }
}
