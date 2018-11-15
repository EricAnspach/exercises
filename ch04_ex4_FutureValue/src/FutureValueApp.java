import java.util.Scanner;
import java.text.NumberFormat;

public class FutureValueApp {

    public static void main(String[] args) {
        System.out.println("The Future Value Calculator\n");
        
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            // get the input from the user
            System.out.print("Enter monthly investment:   ");
            double monthlyInvestment = sc.nextDouble();
//            System.out.print("Enter yearly interest rate: ");
//            double interestRate = sc.nextDouble();
            System.out.print("Enter number of years:      ");
            int years = sc.nextInt();
            System.out.println();

            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent = NumberFormat.getPercentInstance();
            percent.setMinimumFractionDigits(1);

            String table = "";
            String headerrow = "Year" + "\t";

            for (double rate = 5.0; rate < 7.0; rate += 0.5) {
                headerrow += percent.format(rate/100) + "\t\t\t";
            }

            table += headerrow + "\n";

            for (int i = 1; i <= years; i++) {
                String row = i + "\t\t";

                for (double rate = 5.0; rate < 7.0; rate += 0.5) {
                    int months = i * 12;
                    double monthlyInterestRate = rate/12/100;

                    double futureValue = 0.0;
                    for (int j = 1; j < months; j++) {
                        futureValue = (futureValue + monthlyInvestment) * (1 + monthlyInterestRate);
                    }
                    row += currency.format(futureValue) + "\t\t";
                }
                table += row + "\n";
            }
            System.out.println(table);



//            // convert yearly values to monthly values
//            double monthlyInterestRate = interestRate / 12 / 100;
//            int months = years * 12;
//
//            // use a for loop to calculate the future value
//            double futureValue = 0.0;
//            for (int i = 1; i <= months; i++) {
//                futureValue = (futureValue + monthlyInvestment) *
//                              (1 + monthlyInterestRate);
//            }
//
//            // format the result and display it to the user
//            NumberFormat currency = NumberFormat.getCurrencyInstance();
//            System.out.println("Future value:               "
//                    + currency.format(futureValue));
//            System.out.println();

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
        }
        System.out.println("Bye!");
    }
}