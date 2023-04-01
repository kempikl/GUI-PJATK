package CW2.ZAD4;

import java.util.Comparator;

class MyColorCompar implements Comparator<MyColor> {
    private final ColComponent colComp;

    public MyColorCompar(ColComponent colComp) {
        this.colComp = colComp;
    }

    public MyColorCompar() {
        colComp = ColComponent.NONE;
    }

    @Override
    public int compare(MyColor c1, MyColor c2) {
        return switch (colComp) {
            case RED -> c1.getRed() - c2.getRed();
            case GREEN -> c1.getGreen() - c2.getGreen();
            case BLUE -> c1.getBlue() - c2.getBlue();
            default -> c1.getSum() - c2.getSum();
        };
    }
}
