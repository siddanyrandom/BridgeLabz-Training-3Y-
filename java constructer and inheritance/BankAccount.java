public class BankAccount {

    // Public variable: Accessible from anywhere.
    public String accountNumber;

    // Protected variable: Accessible within the same class, subclasses, and the same package.
    protected String accountHolder;

    // Private variable: Only accessible within this class.
    private double balance;

    /**
     * Parameterized constructor for the BankAccount class.
     *
     * @param accountNumber The account number.
     * @param accountHolder The name of the account holder.
     * @param initialBalance The initial balance of the account.
     */
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    /**
     * Public method to get the value of the private 'balance' variable.
     * This is a "getter" method.
     *
     * @return The current account balance.
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Public method to set the value of the private 'balance' variable.
     * This is a "setter" method that also validates the new balance.
     *
     * @param newBalance The new balance to be set.
     */
    public void setBalance(double newBalance) {
        if (newBalance >= 0) {
            this.balance = newBalance;
            System.out.println("Balance updated successfully.");
        } else {
            System.out.println("Invalid balance. Balance cannot be negative.");
        }
    }
}

/**
 * A subclass that inherits from BankAccount, representing a savings account.
 * This class demonstrates how to access public and protected members from a subclass.
 */
class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double initialBalance, double interestRate) {
        // Call the superclass constructor to initialize inherited members
        super(accountNumber, accountHolder, initialBalance);
        this.interestRate = interestRate;
    }

    /**
     * A method to display details specific to a savings account.
     * This method can directly access the public 'accountNumber' and protected 'accountHolder'
     * variables from the superclass.
     */
    public void displaySavingsAccountDetails() {
        System.out.println("\nSavings Account Details:");
        // Direct access to public member
        System.out.println("Account Number: " + this.accountNumber);
        // Direct access to protected member
        System.out.println("Account Holder: " + this.accountHolder);
        // Cannot directly access private 'balance', must use the public getter method
        System.out.println("Balance: $" + String.format("%.2f", this.getBalance()));
        System.out.println("Interest Rate: " + String.format("%.2f", this.interestRate) + "%");
    }

    /**
     * Main method to demonstrate the functionality of the BankAccount and SavingsAccount classes.
     */
    public static void main(String[] args) {
        System.out.println("--- Demonstrating Access Modifiers ---");

        // 1. Working with a basic BankAccount object
        BankAccount account1 = new BankAccount("123456789", "John Doe", 1500.50);
        System.out.println("\nInitial Bank Account Details:");
        System.out.println("Account Number (public): " + account1.accountNumber);
        System.out.println("Account Holder (protected): " + account1.accountHolder);
        System.out.println("Balance (private via public method): $" + String.format("%.2f", account1.getBalance()));

        // Accessing and modifying the private balance via public methods
        account1.setBalance(1600.75);
        System.out.println("Updated Balance: $" + String.format("%.2f", account1.getBalance()));

        // 2. Working with a SavingsAccount object (subclass)
        SavingsAccount savings1 = new SavingsAccount("987654321", "Jane Smith", 5000.00, 2.5);
        savings1.displaySavingsAccountDetails();
    }
}
