
class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        displayInfo();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        displayInfo();
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccount {
    int maturityPeriod; // in months

    FixedDepositAccount(String accountNumber, double balance, int maturityPeriod) {
        super(accountNumber, balance);
        this.maturityPeriod = maturityPeriod;
    }

    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        displayInfo();
        System.out.println("Maturity Period: " + maturityPeriod + " months");
    }
}

public class Main {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SA101", 5000, 4.5);
        CheckingAccount ca = new CheckingAccount("CA102", 3000, 1000);
        FixedDepositAccount fd = new FixedDepositAccount("FD103", 10000, 12);

        sa.displayAccountType();
        System.out.println();
        ca.displayAccountType();
        System.out.println();
        fd.displayAccountType();
    }
}
```
