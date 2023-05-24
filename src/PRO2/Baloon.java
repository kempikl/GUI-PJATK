package PRO2;

import java.util.concurrent.atomic.AtomicLong;

public class Baloon {
    private static final AtomicLong nextBaloonNumber = new AtomicLong();

    public long number;
    public BaloonColor color;

    Baloon(BaloonColor color) {
        this.number = nextBaloonNumber.incrementAndGet();
        this.color = color;
    }
}
