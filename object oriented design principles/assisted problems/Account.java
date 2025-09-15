import java.util.ArrayList;
import java.util.List;

class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }

    public void deposit(double amount) { balance += amount; }
    public void withdraw(double amount) {
        if (amount <= balance) balance -= amount;
    }
}

class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() { return name; }
    public List<Account> getAccounts() { return accounts; }

    public void addAccount(Account account) { accounts.add(account); }

    public void viewBalance() {
        System.out.println("Balances for " + name + ":");
        for (Account a : accounts) {
            System.out.println("  Account " + a.getAccountNumber() + ": " + a.getBalance());
        }
        System.out.println();
    }
}

class Bank {
    private String name;
    private List<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer c) { customers.add(c); }

    public void openAccount(Customer c, String accNo, double initialDeposit) {
        Account account = new Account(accNo, initialDeposit);
        c.addAccount(account);
        if (!customers.contains(c)) customers.add(c);
        System.out.println("Account " + accNo + " opened for " + c.getName() + " in " + name);
    }
}

public class AssociationDemo {
    public static void main(String[] args) {
        Bank bank = new Bank("Global Bank");

        Customer c1 = new Customer("Alice");
        Customer c2 = new Customer("Bob");

        bank.openAccount(c1, "A101", 5000);
        bank.openAccount(c1, "A102", 3000);
        bank.openAccount(c2, "B201", 7000);

        c1.viewBalance();
        c2.viewBalance();
    }
}
