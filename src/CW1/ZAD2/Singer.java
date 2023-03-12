package CW1.ZAD2;

public abstract class Singer {
    private String name;
    private int number;
    private static int numberCounter = 1;

    public Singer(String name) {
        this.name = name;

        number = numberCounter;
        numberCounter ++;
    }

    abstract String sing();

    public static String loudest(Singer[] sng) {
        Singer mostUpper = null;
        int upperCounter = 0;

        try {
            for (Singer s : sng) {
                int tempCounter = 0;

                for (char ch : s.sing().toCharArray())
                    if (Character.isUpperCase(ch))
                        tempCounter++;

                if (tempCounter > upperCounter) {
                    mostUpper = s;
                    upperCounter = tempCounter;
                }
            }
            return mostUpper.toString();
        } catch (NullPointerException ignored) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "(" + number + ")" + " " + name + ": " + sing();
    }
}
