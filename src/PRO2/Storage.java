package PRO2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Storage {
    private final BlockingQueue<Baloon> queue;

    Storage(int storageCapacity) {
        queue = new LinkedBlockingQueue<>(storageCapacity);
    }

    public void addBaloon(Baloon baloon) throws InterruptedException {
        queue.put(baloon);
    }

    public synchronized List<Baloon> getBaloons(int amount) throws InterruptedException {
        List<Baloon> baloons = new ArrayList<>();
        for(int i = 0; i < amount; i++) {
            baloons.add(queue.take());
        }
        return baloons;
    }

    @Override
    public String toString() {
        return "Ilość: " + queue.size();
    }
}


