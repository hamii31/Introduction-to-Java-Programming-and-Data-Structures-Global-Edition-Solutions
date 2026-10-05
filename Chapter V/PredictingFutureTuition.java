public class PredictingFutureTuition {
    public static void main(String[] args) {
        int tuition = 10_000;
        int sentinel = tuition * 2;
        double yearlyIncreaseRate = 0.07;
        int years = 0;
        
        do { 
            tuition += tuition * yearlyIncreaseRate;
            years++;
        } while (tuition < sentinel);

        System.out.printf("It took %d years for the tuition to reach %d.", years, tuition);
    }
}
