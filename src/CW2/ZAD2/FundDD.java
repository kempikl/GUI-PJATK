package CW2.ZAD2;

@FunctionalInterface
interface FunDD {
    double fun(double x);

    static double xminim(FunDD f, double a, double b) {
        double xMin = a;
        double yMin = f.fun(a);

        for (double x = xMin + 1e-5; x <= b; x += 1e-5) {
            double y = f.fun(x);
            if (y < yMin) {
                xMin = x;
                yMin = y;
            }
        }

        return xMin;
    }
}
