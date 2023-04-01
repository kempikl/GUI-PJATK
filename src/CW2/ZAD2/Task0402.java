package CW2.ZAD2;

import java.util.function.Function;

public class Task0402 {
    public static void main(String[] args) {
        Parabola parabola = new Parabola(1, -1, -1.25);
        double xMin = FunDD.xminim(parabola, 0, 1);
        System.out.println(xMin);

        FunDD fun = new FunDD() {
            @Override
            public double fun(double x) {
                return Math.sqrt(Math.pow(x - 0.75, 2) + 1);
            }
        };
        xMin = FunDD.xminim(fun, 0, 2);
        System.out.println(xMin);

        Function<Double, Double> lambda = x -> x * x * (x - 2);
        xMin = FunDD.xminim(lambda::apply, 0, 2);
        System.out.println(xMin);
    }
}
