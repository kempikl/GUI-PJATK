package PRO1;

public enum Color {
    WHITE(0, "białe"),
    BLACK(1, "czarne");

    final String friendlyName;

    Color(long byteColor, String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString() {
        return " (" + friendlyName + ")";
    }
}
