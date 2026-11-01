import java.util.Date;
import java.util.Scanner;

public class Exercise10_07 {
    private static Account loadAccount(Account[] accounts, int id) {
        for (Account account : accounts) {
            if (account.getId() == id) return account;
        }
        return null;
    }
    private static void bootMenu(Account account, Scanner input) {
       while (true) {
            System.out.println("\nMain menu");
            System.out.println("1: check balance");
            System.out.println("2: withdraw");
            System.out.println("3: deposit");
            System.out.println("4: exit");

            System.out.println("Enter a choice: ");
            int choice = input.nextInt(); 
            if (choice == 4) {
                break;
            }

            switch(choice) {
                case 1 -> {
                    System.out.printf("The balance is %.2f\n", account.getBalance());
                } 
                case 2 -> {
                    System.out.println("Enter an amount to withdraw: ");
                    account.withdraw(input.nextDouble());
                } 
                case 3 -> {
                    System.out.println("Enter an amount to deposit: ");
                    account.deposit(input.nextDouble());
                }
            }
       }
    }
    public static void main(String[] args) {

        Account[] accounts = new Account[10];

        for (int i = 0; i < accounts.length; i++) accounts[i] = new Account(i, 100);
        
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Enter an Id: ");
            int id = input.nextInt();

            Account account = loadAccount(accounts, id);
            
            if (account != null) bootMenu(account, input);
            else System.out.println("Invalid Id.");
        }
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
