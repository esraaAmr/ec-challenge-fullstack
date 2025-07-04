package domain.models;

public record CartItem(Product product, int quantity) {

    public double getTotalPrice() {
        return quantity * product.price;
    }
}
