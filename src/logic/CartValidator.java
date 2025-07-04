package logic;

import domain.models.CartItem;
import domain.models.Product;
import java.util.List;

public class CartValidator {

    public boolean validate(List<CartItem> items) {
        return items.stream().allMatch(item -> {
            Product product = item.product();
            int quantity = item.quantity();
            boolean available = product.isAvailable(quantity);
            if (!available) {
                System.out.println(product.getName() + " is out of stock or expired");
            }
            return available;
        });
    }

}

