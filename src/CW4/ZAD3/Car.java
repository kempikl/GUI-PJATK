package CW4.ZAD3;

class Car {
    String brand;
    String price;

    Car(String brand, String price) {
        this.brand = brand;
        this.price = price;
    }

    public String toString() {
        return brand + " " + price;
    }
}
