package logic;

import domain.models.CartItem;
import java.util.List;

public class SubtotalCalculator {

    public static double calculate(List<CartItem> items) {
        return items.stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }
}
