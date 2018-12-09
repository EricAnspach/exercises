import java.text.NumberFormat;

public class MonthSelectorApp {

    public static void main(String[] args) {
        System.out.println("Monthly Sales\n");
        
        // declare monthNames and monthSales arrays
        String[] monthName = { "January", "February", "March", "April", "May",
        						"June", "July", "August", "September", "October",
        						"November", "December"};
        
        double[] monthSales = { 45.23, 299.03, 9814.34, 333.00, 1.67, 87581.01, 551.02,
        						224563.85, 55.80, 998.12, 2317.77, 891.60};
     
 
        // get currency formatting
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        
        // get one or more months
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            // get the input from the user
            int monthNumber = Console.getInt("Enter month number: ");
            
            // validate input
            if (monthNumber < 1 || monthNumber > monthName.length) {
                Console.displayLine("Invalid month number. Try again.");
                continue;                
            }
            
            // get the index number for the month
            monthNumber = monthNumber - 1;
            // and display the month name and sales
            Console.displayLine("Sales for " + monthName[monthNumber] + ": "
            + currency.format(monthSales[monthNumber]));
            Console.displayLine();


            // check if the user wants to continue
            choice = Console.getString("Continue? (y/n): ");
            Console.displayLine();
        }
        
        // display the total sales for the year
        double totalSales = 0;
//        for (int i = 0; i < monthSales.length; i++) {
//			totalSales += monthSales[i];
//		}
        
        for (double monthSale:monthSales) {
			totalSales += monthSale;
		}
        Console.displayLine("Total sales: " + currency.format(totalSales));
        Console.displayLine();
    }    

}
