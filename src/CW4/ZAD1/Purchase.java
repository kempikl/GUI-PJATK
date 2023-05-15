package CW4.ZAD1;

class Purchase {
    private final String name;
    private final int price;

    public Purchase(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
