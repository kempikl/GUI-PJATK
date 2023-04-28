package PRO1;

public enum Color {
    WHITE(0, "białe"),
    BLACK(1, "czarne");

    final String friendlyName;
    final int bitColor;

    Color(int bitColor, String friendlyName) {
        this.friendlyName = friendlyName;
        this.bitColor = bitColor;
    }

    public int getBitColor() {
        return bitColor;
    }

    @Override
    public String toString() {
        return " (" + friendlyName + ")";
    }
}
