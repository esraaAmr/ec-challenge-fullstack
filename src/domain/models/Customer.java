package domain.models;

public class Customer {

    private double balance;

    public Customer(double balance) {
        this.balance = balance;
    }

    public boolean hasSufficientBalance(double amount) {
        return balance >= amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

}
