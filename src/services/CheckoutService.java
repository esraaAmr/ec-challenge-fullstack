package services;

import domain.models.*;
import logic.CartValidator;
import logic.ShippableChecker;
import logic.SubtotalCalculator;
import logic.TransactionHandler;
import output.ReceiptPrinter;

import java.util.List;

public class CheckoutService {

    private static final double SHIPPING_FEE = 50.0;

    private final Customer customer;
    private final Cart cart;

    public CheckoutService(Customer customer, Cart cart) {
        this.customer = customer;
        this.cart = cart;
    }

    public void process() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        List<CartItem> items = cart.getItems();

        CartValidator validator = new CartValidator();
        if (!validator.validate(items)) return;

        double subtotal = SubtotalCalculator.calculate(items);
        boolean hasShippableItem = ShippableChecker.hasShippableItems(items);
        double shipping = hasShippableItem ? SHIPPING_FEE : 0.0;
        double total = subtotal + shipping;

        if (!customer.hasSufficientBalance(total)) {
            System.out.println("Customer's balance is insufficient");
            return;
        }

        TransactionHandler.process(customer, items, total);

        if (hasShippableItem) {
            ShippingService.ship(cart.getShippableItems());
        }

        ReceiptPrinter.print(items, subtotal, shipping, total);
        cart.clear();
    }
}
