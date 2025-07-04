package domain.models;

public abstract class Product {

    String name;
    double price;
    int quantity;
    boolean isExpired;

    public Product(String name, double price, int quantity, boolean isExpired) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isExpired = isExpired;
    }

    public boolean isAvailable(int quantity) {
        return !isExpired && this.quantity >= quantity;
    }

    public void reduceStock(int quantity) {
        this.quantity -= quantity;
    }

    public String getName() {
        return name;
    }


    abstract boolean isShippable();
}
