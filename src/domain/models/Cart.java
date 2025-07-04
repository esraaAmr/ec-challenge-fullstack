package domain.models;

import domain.interfaces.Shippable;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    List<CartItem> cartItems = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (!product.isAvailable(quantity)) {
            return;
        }

        cartItems.add(new CartItem(product, quantity));
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(cartItems);
    }

    public void clear() {
        cartItems.clear();
    }


    public List<Shippable> getShippableItems() {
        List<Shippable> shippable = new ArrayList<>();

        cartItems.stream()
                .map(CartItem::product)
                .filter(product -> product instanceof Shippable)
                .forEach(product -> shippable.add((Shippable) product));

        return shippable;
    }

}
