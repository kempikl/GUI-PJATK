# GUI - CW 01 - Zad 3

Napisz program, który symuluje działanie sklepu internetowego. Sklep ma kilka rodzajów produktów, które mogą być dodawane do koszyka. Zaimplementuj interfejs Product z metodami:

-   getName(), zwracającą nazwę produktu,
-   getPrice(), zwracającą cenę produktu.

Stwórz klasy reprezentujące różne produkty, np. Book, Clothing, Electronics, implementujące interfejs Product.

Następnie zaimplementuj interfejs ShoppingCart z metodami:

-   addProduct(Product product), dodającą produkt do koszyka,
-   removeProduct(Product product), usuwającą produkt z koszyka,
-   getTotalPrice(), zwracającą łączną cenę produktów w koszyku.

OnlineStore.java

    public
	    class OnlineStore
	    implements ShoppingCart {
	    
	    private Product[] products = new Products[20];
	    private  int productCounter = 0;
	    
	    public  void addProduct(Product product) {
		    // ...
	    }
	    
	    public  void removeProduct(Product product) {
		    // ...
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
