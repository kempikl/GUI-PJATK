package PRO2;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

class Transporter implements Runnable {
    private static final AtomicLong nextTransporterNumber = new AtomicLong();

    long number;
    private final Storage storage;
    private volatile TransporterState state;

    Transporter(Storage storage) {
        number = nextTransporterNumber.incrementAndGet();
        this.storage = storage;
        this.state = TransporterState.WAITING;
    }

    @Override
    public void run() {
        while(true) {
            try {
                state = TransporterState.LOADING;
                long startTime = System.nanoTime();
                List<Baloon> baloons = storage.getBaloons(10);
                long endTime = System.nanoTime();
                long deliveryTime = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

                delivery(baloons, deliveryTime);

                state = TransporterState.WAITING;
                TimeUnit.MILLISECONDS.sleep(10000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private void delivery(List<Baloon> baloons, long deliveryTime) throws InterruptedException {
        state = TransporterState.DELIVERING;
        TimeUnit.MILLISECONDS.sleep(deliveryTime);

        for(Baloon baloon : baloons) {
            System.out.println(number + " - Transporting baloon number " + baloon.number + " of color " + baloon.color);
        }
        System.out.println("Time: " + deliveryTime);
    }

}
