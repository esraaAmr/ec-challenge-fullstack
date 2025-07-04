package output;

import domain.models.CartItem;

import java.util.List;

public class ReceiptPrinter {

    public static void print(List<CartItem> items, double subtotal, double shipping, double total) {
        System.out.println("** Checkout receipt **");
        for (CartItem item : items) {
            System.out.printf("%dx %s\t%.0f%n", item.quantity(), item.product().getName(), item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal\t%.0f%n", subtotal);
        System.out.printf("Shipping\t%.0f%n", shipping);
        System.out.printf("Amount\t\t%.0f%n", total);
    }
}
