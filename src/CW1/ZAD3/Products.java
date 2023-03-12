package CW1.ZAD3;

public class Products implements Product{
    protected String name;
    protected double price;

    public Products(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
