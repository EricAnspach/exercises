

import java.util.Scanner;

public class NameParserApp {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Enter a name: ");
            String name = sc.nextLine();
            name = name.trim();

            String[] nameParts = name.split(" ");

            int partCount = nameParts.length;

            if (partCount > 3) {
                System.out.println("Name is too long! Please enter a shorter name.");
            } else if (partCount < 2) {
                System.out.println("Name is too short! Please enter a full name.");
            } else {
                System.out.println("\nFirst name:  " + nameParts[0]);
                if (partCount == 3) {
                    System.out.println("Middle name: " + nameParts[1]);
                    System.out.println("Last name:   " + nameParts[2]);
                } else {
                    System.out.println("Last name:   " + nameParts[1]);
                }
                isValid = true;
            }
        }
        System.out.println();
    }
}
