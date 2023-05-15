package CW3.ZAD3;

import java.util.Iterator;
import java.util.Random;

public class Roll implements Iterable<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        return new RollIterator();
    }

    private static class RollIterator implements Iterator<Integer> {
        private final Random random = new Random();
        private int[] lastThreeRolls = new int[3];
        private int rollCount = 0;

        @Override
        public boolean hasNext() {
            return rollCount < 3 || sumOfLastThreeRolls() != 11;
        }

        @Override
        public Integer next() {
            int roll = random.nextInt(6) + 1;
            lastThreeRolls[rollCount % 3] = roll;
            rollCount++;
            return roll;
        }

        private int sumOfLastThreeRolls() {
            return lastThreeRolls[0] + lastThreeRolls[1] + lastThreeRolls[2];
        }
    }
}

