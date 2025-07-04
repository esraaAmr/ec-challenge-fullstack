package logic;

import domain.interfaces.Shippable;
import domain.models.CartItem;
import java.util.List;

public class ShippableChecker {

    public static boolean hasShippableItems(List<CartItem> items) {
        return items.stream()
                .anyMatch(item -> item.product() instanceof Shippable);
    }
}
