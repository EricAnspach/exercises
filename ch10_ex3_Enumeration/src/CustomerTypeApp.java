public class CustomerTypeApp {

    public static void main(String[] args) {
        // display a welcome message
        System.out.println("Welcome to the Customer Type Test application\n");

        // get and display the discount percent for a customer type
        CustomerType retail = CustomerType.RETAIL;

        double discountPercent = getDiscountPercent(retail);
        System.out.println("Discount percent is: " + discountPercent);

        // display the value of the toString method of a customer type
        String displayString = retail.toString();
        System.out.println(displayString);
    }

    // a method that accepts a CustomerType enumeration
    public static double getDiscountPercent (CustomerType customerType) {
        double discountPercent = 0.0;
        if (customerType == CustomerType.RETAIL) {
            discountPercent = .10;
        } else if (customerType == CustomerType.TRADE) {
            discountPercent = .30;
        } else if (customerType == CustomerType.COLLEGE) {
            discountPercent = .20;
        }
        return discountPercent;
    }
}
