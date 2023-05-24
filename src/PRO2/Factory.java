package PRO2;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Factory implements Runnable {
    private static final AtomicLong nextFactoryNumber = new AtomicLong();

    private final long number;
    private final Storage storage;
    private volatile int productionTime;
    private final AtomicInteger balloonCount;
    private volatile boolean running;

    Factory(Storage storage) {
        number = nextFactoryNumber.incrementAndGet();
        this.storage = storage;
        productionTime = ThreadLocalRandom.current().nextInt(100, 3000);
        balloonCount = new AtomicInteger();
        running = true;
    }

    public void setProductionTime(int productionTime) {
        this.productionTime = productionTime;
    }

    public void stop() {
        running = false;
    }

    public int getProductionTime() {
        return productionTime;
    }

    @Override
    public void run() {
        while (running) {
            try {
                BaloonColor color = BaloonColor.values()[ThreadLocalRandom.current().nextInt(BaloonColor.values().length)];
                Baloon baloon = new Baloon(color);
                storage.addBaloon(baloon);
                balloonCount.getAndIncrement();
                TimeUnit.MILLISECONDS.sleep(productionTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public int getBalloonCount() {
        return balloonCount.intValue();
    }

    public long getNumber() {
        return number;
    }
}
