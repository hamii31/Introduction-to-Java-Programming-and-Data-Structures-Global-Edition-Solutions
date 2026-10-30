import java.util.Date;

public class Exercise09_07 {
    public static void main(String[] args) {
        Account accObj = new Account(1122, 20_000);
        accObj.setAnnualInterestRate(4.5);
        accObj.withdraw(2_500);
        accObj.deposit(3_000);
        System.out.println("Current balance is: " + accObj.getBalance());
        System.out.println("The monthly interest is: " + accObj.getMonthlyInterest());
        System.err.println("The account was created on: " + accObj.getDate());
    }
}

class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    public Account() {
        this.id = 0;
        this.balance = 0;
        this.annualInterestRate = 0;
        this.dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = 0;
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

}
