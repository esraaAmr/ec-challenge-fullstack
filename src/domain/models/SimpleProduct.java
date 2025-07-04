package domain.models;

public class SimpleProduct extends Product{
    public SimpleProduct(String name, double price, int quantity, boolean isExpired) {
        super(name, price, quantity, isExpired);
    }

    @Override
    boolean isShippable() {
        return false;
    }
}
