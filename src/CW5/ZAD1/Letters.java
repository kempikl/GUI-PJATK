package CW5.ZAD1;

import java.util.ArrayList;
import java.util.Iterator;

public class Letters implements Iterable<Thread> {
    private final ArrayList<Thread> threads = new ArrayList<>();

    public Letters(String str) {
        for (char c : str.toCharArray()) {
            Thread t = new Thread(() -> {
                while (!Thread.interrupted()) {
                    System.out.print(c);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }, "Thread " + c);
            threads.add(t);
        }
    }

    public void start() {
        for (Thread t : threads) {
            t.start();
        }
    }

    public void stop() {
        for (Thread t : threads) {
            t.interrupt();
        }
    }

    @Override
    public Iterator<Thread> iterator() {
        return threads.iterator();
    }
}

