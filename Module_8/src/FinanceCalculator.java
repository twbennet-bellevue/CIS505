/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/

public class FinanceCalculator {

    //global static variables
    private static int MONTHS_IN_YEAR = 12;

    /**
     * Calculates the Future Value from a monthly payment, rate, and years.
     * @param monthlyPayment double
     * @param rate double
     * @param years int
     * @return double futureValue
     */
    public static double calculateFutureValue(double monthlyPayment, double rate, int years) {
        int months = years * MONTHS_IN_YEAR;
        double presentValue = monthlyPayment * months;
        double interestRate = (1 + rate / 100);
        double futureValue = presentValue * (Math.pow(interestRate, months));

        return futureValue;
    }
    
}
