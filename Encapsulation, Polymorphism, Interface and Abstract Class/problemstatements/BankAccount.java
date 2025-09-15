import java.util.ArrayList;
import java.util.List;

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getHolderName() { return holderName; }
    public void setHolderName(String holderName) { this.holderName = holderName; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public void deposit(double amount) { balance += amount; }
    public void withdraw(double amount) { if (balance >= amount) balance -= amount; }

    public abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: $" + balance);
    }
}

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public double calculateInterest() { return getBalance() * 0.04; }

    public void applyForLoan(double amount) { System.out.println("Loan of $" + amount + " applied for Savings Account."); }
    public boolean calculateLoanEligibility() { return getBalance() >= 5000; }
}

class CurrentAccount extends BankAccount implements Loanable {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public double calculateInterest() { return getBalance() * 0.02; }

    public void applyForLoan(double amount) { System.out.println("Loan of $" + amount + " applied for Current Account."); }
    public boolean calculateLoanEligibility() { return getBalance() >= 10000; }
}

public class BankingSystemDemo {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        SavingsAccount sa = new SavingsAccount("SA101", "Alice", 8000);
        CurrentAccount ca = new CurrentAccount("CA202", "Bob", 15000);

        accounts.add(sa);
        accounts.add(ca);

        for (BankAccount acc : accounts) {
            acc.displayDetails();
            System.out.println("Interest: $" + acc.calculateInterest());
            if (acc instanceof Loanable loanAcc) {
                loanAcc.applyForLoan(5000);
                System.out.println("Loan Eligibility: " + loanAcc.calculateLoanEligibility());
            }
            System.out.println("------------------------");
        }
    }
}
