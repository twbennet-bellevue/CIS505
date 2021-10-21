public class FinanceCalculator {

    private static int MONTHS_IN_YEAR = 12;

    public static double calculateFutureValue(double monthlyPayment, double rate, int years) {
        int months = years * MONTHS_IN_YEAR;
        double presentValue = monthlyPayment * months;
        double interestRate = (1 + rate / 100);
        double futureValue = presentValue * (Math.pow(interestRate, months));

        return futureValue;
    }
    
}
