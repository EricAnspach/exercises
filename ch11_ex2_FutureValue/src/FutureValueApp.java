import java.text.*;
import java.util.Stack;

public class FutureValueApp {

    public static void main(String[] args) {
        // display a welcome message
        System.out.println("Welcome to the Future Value Calculator");
        System.out.println();

        // perform 1 or more calculations
        int rowCount = 0;
        String[][] valueArray = new String[10][4];
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {

            // get the input from the user
            System.out.println("DATA ENTRY");
            double monthlyInvestment = Console.getDouble(
                    "Enter monthly investment: ", 0, 1000);
            double interestRate = Console.getDouble(
                    "Enter yearly interest rate: ", 0, 30);
            int years = Console.getInt(
                    "Enter number of years: ", 0, 100);

            // calculate the future value
            double monthlyInterestRate = interestRate / 12 / 100;
            int months = years * 12;
            double futureValue = calculateFutureValue(
                    monthlyInvestment, monthlyInterestRate, months);

            // get the currency and percent formatters
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent = NumberFormat.getPercentInstance();
            percent.setMinimumFractionDigits(1);

            String monthlyInvFormatted = currency.format(monthlyInvestment);
            String monthlyPercFormatted = percent.format(interestRate / 100);
            String futureValueFormatted = currency.format(futureValue);

            // format the result as a single string
            String results
                    = "Monthly investment:\t"
                    + monthlyInvFormatted + "\n"
                    + "Yearly interest rate:\t"
                    + monthlyPercFormatted + "\n"
                    + "Number of years:\t"
                    + years + "\n"
                    + "Future value:\t\t"
                    + futureValueFormatted + "\n";

            // print the results
            System.out.println();
            System.out.println("FORMATTED RESULTS");
            System.out.println(results);

            valueArray[rowCount][0] = monthlyInvFormatted;
            valueArray[rowCount][1] = monthlyPercFormatted;
            valueArray[rowCount][2] = Integer.toString(years);
            valueArray[rowCount][3] = futureValueFormatted;

            rowCount++;
            // see if the user wants to continue
            if (rowCount < 10) {
                choice = Console.getString("Continue? (y/n): ");
                System.out.println();
            } else {
                choice = "n";
            }

        }
        System.out.println("Future Value Calculations\n");
        System.out.println("Inv/Mo. Rate    Years   Future Value");

        for (int i = 0; i < rowCount; i++) {
            System.out.println(
                    valueArray[i][0] + "\t" +
                    valueArray[i][1] + "\t" +
                    valueArray[i][2] + "\t\t" +
                    valueArray[i][3]);
        }


    }

    public static double calculateFutureValue(double monthlyInvestment,
            double monthlyInterestRate, int months) {
        double futureValue = 0;
        for (int i = 1; i <= months; i++) {
            futureValue = (futureValue + monthlyInvestment)
                        * (1 + monthlyInterestRate);
        }
        return futureValue;
    }
}