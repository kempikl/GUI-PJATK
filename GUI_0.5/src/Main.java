import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        int[] tab;
        BubbleSort bs = new BubbleSort();

        IntStream generator = new Random().ints(100, 10, 101);
        tab = generator.toArray();

        bs.bubbleSort(tab);
        bs.printArray(tab);
    }
}