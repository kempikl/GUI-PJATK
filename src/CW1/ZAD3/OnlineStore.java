package CW1.ZAD3;

public
class OnlineStore
        implements ShoppingCart {

    private Product[] products = new Products[20];
    private  int productCounter = 0;

    public  void addProduct(Product product) {
        Product[] tempArr = new Products[productCounter + 1];

        System.arraycopy(products, 0, tempArr, 0, productCounter);
        tempArr[productCounter] = product;
        productCounter ++;

        products = tempArr;
    }

    public  void removeProduct(Product product) {
        Product[] tempArr = new Products[productCounter];
        int index = 0;

        for (int i = 0; i < productCounter; i ++) {
            if (!product.equals(products[i])) {
                tempArr[index] = products[i];
                index ++;
            }
        }
        products = new Products[index];
        productCounter = index;
        System.arraycopy(tempArr, 0, products, 0, index);
    }

    public  double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public  static  void main(String[] args) {
        OnlineStore store = new OnlineStore();

        Book book = new Book("The Catcher in the Rye", 10.99);
        Clothing shirt = new Clothing("Blue Shirt", 25.99);
        Electronics phone = new Electronics("iPhone 12", 999.99);

        store.addProduct(book);
        store.addProduct(shirt);
        store.addProduct(phone);

        System.out.println("Total price: " + store.getTotalPrice());

        store.removeProduct(shirt);

        System.out.println("Total price: " + store.getTotalPrice());
    }
}