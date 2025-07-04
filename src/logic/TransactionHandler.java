package logic;

import domain.models.CartItem;
import domain.models.Customer;

import java.util.List;

public class TransactionHandler {

    public static void process(Customer customer, List<CartItem> items, double total) {
        customer.withdraw(total);
        items.forEach(item -> item.product().reduceStock(item.quantity()));
    }
}
