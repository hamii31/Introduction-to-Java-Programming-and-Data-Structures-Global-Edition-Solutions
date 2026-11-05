import java.util.*;

public class Exercise11_03 {
    public static void main(String[] args) {
        Account account1 = new Account(1, 2500, 3.5);
        System.out.println(account1.toString());

        Account account2 = new CheckingAccount(2, 2500, 3.5, 250);
        System.out.println(account2.toString());

        Account account3 = new SavingAccount(3, 5000, 1.5);
        System.out.println(account3.toString());
    }
}

class Account {
    public int id = 0;
    public double balance = 0;
    public double annualInterestRate = 0;
    public Date dateCreated;

    public Account() {
        this.dateCreated = new Date();
    }

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.dateCreated = new Date();
    }

    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getAnnualInterestRate() {
        return this.annualInterestRate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDate() {
        return this.dateCreated;
    }

    public double getMonthlyInterestRate() {
        return (this.annualInterestRate / 100) / (double) 12;
    }

    public double getMonthlyInterest() {
        double monthlyInterest = getMonthlyInterestRate();
        return this.balance * monthlyInterest;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public String toString() {
        return "Account Id: " + id + 
        "\nBalance: " + balance +
        "\nAnnual Interest Rate: " + annualInterestRate +
        "\nDate Created: " + dateCreated;
    }
}

class CheckingAccount extends Account {
    private double overdraftLimit = 100.00;

    public CheckingAccount() {
        this.dateCreated = new Date();
    }

    public CheckingAccount(int id, double balance, double annualInterestRate, double overdraftLimit) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.overdraftLimit = overdraftLimit;
        this.dateCreated = new Date();
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public boolean isOverdraft(double balance) {
        return (this.balance + overdraftLimit) - balance >= 0.00;
    }
    
    @Override
    public String toString() {
        return "Checking Account Id: " + id +
        "\nBalance: " + balance +
        "\nAnnual Interest Rate: " + annualInterestRate +
        "\nOverdraft Limit: " + overdraftLimit +
        "\nDate Created: " + dateCreated;
    }
}

class SavingAccount extends Account {
    public SavingAccount() {
        this.dateCreated = new Date();
    }

    public SavingAccount(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.dateCreated = new Date();
    }

    public boolean isOverdraft(double balance) {
        return this.balance - balance >= 0.00;
    }

    @Override
    public String toString() {
        return "Saving Account Id: " + id +
        "\nBalance: " + balance +
        "\nAnnual Interest Rate: " + annualInterestRate +
        "\nDate Created: " + dateCreated;
    }
}
