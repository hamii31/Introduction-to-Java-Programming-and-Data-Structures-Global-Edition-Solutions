public class Exercise09_02 {
    public static void main (String args[]) {
        Stock stock = new Stock("ORCL", "Oracle Corporation");
        stock.previousClosingPrice = 34.5;
        stock.currentPrice = 34.35;
        System.out.printf("Price-change percentage: %.2f%%", stock.getChangePercent());
    }
}

class Stock{
    String symbol;
    String name;
    double previousClosingPrice;
    double currentPrice;

    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public double getChangePercent() {
        double difference = Math.abs(this.previousClosingPrice - this.currentPrice);
        return difference * 100;
    }
}
