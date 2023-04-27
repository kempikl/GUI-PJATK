package PRO1;

public enum Color {
    WHITE(0, "białe"),
    BLACK(1, "czarne");

    final String friendlyName;
    final int byteColor;

    Color(int byteColor, String friendlyName) {
        this.friendlyName = friendlyName;
        this.byteColor = byteColor;
    }

    public int getByteColor() {
        return byteColor;
    }

    @Override
    public String toString() {
        return " (" + friendlyName + ")";
    }
}
