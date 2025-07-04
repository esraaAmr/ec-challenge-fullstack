import domain.models.*;
import services.CheckoutService;

public class Main {
    public static void main(String[] args) {

        Product cheese = new ExpirableShippableProduct("Cheese", 100, 5, false, 0.2);
        Product biscuits = new ExpirableShippableProduct("Biscuits", 150, 3, false, 0.7);
        Product scratchCard = new SimpleProduct("ScratchCard", 50, 10, false);
        Product cake = new ExpirableShippableProduct("Cake", 50, 2, false, 1.0);

        Customer customer = new Customer(20000);

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);
        cart.add(cake, 2);


        CheckoutService checkoutService = new CheckoutService(customer, cart);
        checkoutService.process();
    }
}
