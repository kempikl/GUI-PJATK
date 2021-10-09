import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] a) throws FileNotFoundException {
        Scanner scan = new Scanner (new File("src/tab.txt"));
        List<Integer> numbers = new ArrayList<>();
        while (scan.hasNextLine()) {
            while (scan.hasNextInt()) {
                numbers.add(scan.nextInt());
            }
        }
        scan.close();

        int maxValue = numbers.get(0);

        for (Integer number : numbers) {
            if (maxValue < number) maxValue = number;
            System.out.print(number + " ");
        }

        System.out.println();
        System.out.println(maxValue);

        int counter = 0;
        for (Integer number : numbers) {
            if (number == maxValue) {
                System.out.print(counter + " ");
            }
            counter++;
        }
    }
}

