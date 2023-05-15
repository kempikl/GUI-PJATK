package PRO2;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

class Factory implements Runnable {
    private final Storage storage;
    private final FactoryPanel panel;
    private volatile int productionTime;
    private volatile boolean running = true;

    Factory(Storage storage, FactoryPanel panel) {
        this.storage = storage;
        this.panel = panel;
        this.productionTime = 1000;
    }

    void setProductionTime(int productionTime) {
        this.productionTime = productionTime;
    }

    void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                BaloonColor color = BaloonColor.values()[ThreadLocalRandom.current().nextInt(BaloonColor.values().length)];
                Baloon baloon = new Baloon(color);
                storage.addBaloon(baloon);
                panel.incrementBaloonCount();
                TimeUnit.MILLISECONDS.sleep(productionTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

