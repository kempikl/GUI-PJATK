package CW1.ZAD3;

public interface ShoppingCart {

    void addProduct(Product product);
    void removeProduct(Product product);
    double getTotalPrice();
}
