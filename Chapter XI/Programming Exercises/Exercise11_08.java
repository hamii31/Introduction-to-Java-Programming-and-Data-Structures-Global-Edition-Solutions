import java.util.*;

public class Exercise11_08 {
    public static void main(String[] args) {
        Account account = new Account(1122, 1000, 1.5, "Liam");
        account.deposit(30);
        account.deposit(40);
        account.deposit(50);

        account.withdraw(5);
        account.withdraw(4);
        account.withdraw(2);

        System.out.println(account.toString());
    }
}

class Account {
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private String name = "N/A";
    private Date dateCreated;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account() {
        this.dateCreated = new Date();
    }

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.dateCreated = new Date();
    }

    public Account(int id, double balance, double annualInterestRate, String name) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.name = name;
        this.dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return dateCreated;
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
        String description = name + " has withdrawn " + amount + " from their account.";
        Transaction transaction = new Transaction('w', amount, balance, description);
        this.transactions.add(transaction);
    }

    public void deposit(double amount) {
        this.balance += amount;
        String description = name + " has deposited " + amount + " to their account.";
        Transaction transaction = new Transaction('d', amount, balance, description);
        this.transactions.add(transaction);
    }

    public String buildTransactionsList(ArrayList<Transaction> transactions) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < transactions.size(); i++) {
            sb.append("\n\tTransaction ").append(i + 1).append(":");
            sb.append("\n\t\tDate: ").append(transactions.get(i).getDate());
            sb.append("\n\t\tType: ").append(transactions.get(i).getType());
            sb.append("\n\t\tAmount: ").append(transactions.get(i).getAmount());
            sb.append("\n\t\tBalance: ").append(transactions.get(i).getBalance());
            sb.append("\n\t\tDescription: ").append(transactions.get(i).getDescription());
            sb.append("\n");
        }

        return sb.toString();
    }

    public String toString() {
        return "Account Id: " + id + 
        "\nAccount Holder: " + name +
        "\nBalance: " + balance +
        "\nAnnual Interest Rate: " + annualInterestRate +
        "\nDate Created: " + dateCreated +
        "\nTransactions: " + buildTransactionsList(transactions);
    }
}

class Transaction {
    private Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;

    public Transaction(char type, double amount, double balance, String description) {
        this.date = new Date();
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
