package CW2.ZAD4;

import java.awt.Color;

enum ColComponent {
    RED, GREEN, BLUE, NONE
}

class MyColor extends Color {
    private final int sum;

    public MyColor(int r, int g, int b) {
        super(r, g, b);
        sum = r + g + b;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "(" + getRed() + "," + getGreen() + "," + getBlue() + ")";
    }
}
