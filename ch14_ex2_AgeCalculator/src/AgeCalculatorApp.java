import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class AgeCalculatorApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the Age Calculator\n");

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Get input from the the user
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        boolean isValid = false;

        do {
            System.out.print("Enter your date of birth (YYYY-MM-DD): ");
            String dateOfBirthString = sc.nextLine();
            System.out.println();

            // Get and validate user's date of birth
            LocalDate dateOfBirth = LocalDate.parse(dateOfBirthString);
            long age = dateOfBirth.until(currentDate, ChronoUnit.YEARS);

            if (age < 0) {
                System.out.println("The date of birth entered is in the future. Please enter a valid birthdate.");
            } else {
                // If user's date of birth is valid
                // Format and print user's date of birth
                DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
                String dateOfBirthFormatted = dtf.format(dateOfBirth);
                System.out.println("Your date of birth is " + dateOfBirthFormatted);

                // Format and print the current date
                String currentDateFormatted = dtf.format(currentDate);
                System.out.println("The current date is " + currentDateFormatted);

                // Calculate and print the user's age
                System.out.println("Your age is " + age);
                isValid = true;
            }

        } while (!isValid);
    }
}