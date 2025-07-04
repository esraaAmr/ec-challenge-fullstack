package domain.models;

import domain.interfaces.Shippable;

public class ExpirableShippableProduct extends Product implements Shippable {

    double weight;

    public ExpirableShippableProduct(String name, double price, int quantity, boolean isExpired, double weight) {
        super(name, price, quantity, isExpired);
        this.weight = weight;
    }

    @Override
    boolean isShippable() {
        return true;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
