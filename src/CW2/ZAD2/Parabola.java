package CW2.ZAD2;

class Parabola implements FunDD {
    private final double a;
    private final double b;
    private final double c;

    public Parabola(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double fun(double x) {
        return a * x * x + b * x + c;
    }
}
