package CW3.ZAD1;

import java.util.Arrays;
import java.util.Comparator;

class MyComp implements Comparator<Integer> {
    public static final int
            BY_VAL = 0, BY_VAL_REV = 1,
            BY_NUM_OF_DIVS = 2, BY_SUM_OF_DIGS = 3;

    private final int criteria;

    public MyComp(int criteria) {
        this.criteria = criteria;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        switch (criteria) {
            case BY_VAL:
                return o1.compareTo(o2);
            case BY_VAL_REV:
                return o2.compareTo(o1);
            case BY_NUM_OF_DIVS:
                int divs1 = numOfDivisors(o1);
                int divs2 = numOfDivisors(o2);
                return divs1 != divs2 ? Integer.compare(divs1, divs2) : Integer.compare(o1, o2);
            case BY_SUM_OF_DIGS:
                int sum1 = sumOfDigits(o1);
                int sum2 = sumOfDigits(o2);
                return sum1 != sum2 ? Integer.compare(sum1, sum2) : Integer.compare(o1, o2);
            default:
                return 0;
        }
    }

    private int numOfDivisors(int n) {
        int divs = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divs++;
            }
        }
        return divs;
    }

    private int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}


public class Compars {
    public static void main(String[] args) {
        Integer[] a = {1,5,33,12,98,15};
        printTable("Original    ", a);

        Arrays.sort(a,new MyComp(MyComp.BY_VAL));
        printTable("ByVal       ", a);

        Arrays.sort(a,new MyComp(MyComp.BY_VAL_REV));
        printTable("ByValRev    ", a);

        Arrays.sort(a,new MyComp(MyComp.BY_NUM_OF_DIVS));
        printTable("ByNumOfDivs ", a);

        Arrays.sort(a,new MyComp(MyComp.BY_SUM_OF_DIGS));
        printTable("BySumOfDigs ", a);
    }

    static void printTable(String mess, Integer[] a) {
        System.out.print(mess + "[ ");
        for (int d : a) System.out.print(d + " ");
        System.out.print("]\n");
    }
}
