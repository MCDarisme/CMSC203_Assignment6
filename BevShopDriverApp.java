/*
 * Class: CMSC203 
 * Instructor: Dr. Grinberg
 * Due: 04/29/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Guerlain Darisme
*/
import java.util.Scanner;

public class BevShopDriverApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BevShop bevShop = new BevShop();

        System.out.println("Welcome to The Beverage Shop!");
        System.out.println("The current order in process can have at most 3 alcoholic beverages.");
        System.out.println("The minimum age to order an alcohol drink is 21.");

        boolean done = false;

        while (!done) {
            System.out.println("Start a new order:");

            System.out.println("Your Total Order for now is 0.0");

            System.out.print("Please enter your name: ");
            String name = scanner.nextLine();

            System.out.print("Please enter your age: ");
            int age = Integer.parseInt(scanner.nextLine());

            Customer customer = new Customer(name, age);

            if (age >= 21) {
                System.out.println("Your age is above 20 and you are eligible to order alcohol.");
            } else {
                System.out.println("You are not eligible to order alcohol due to your age.");
            }

            bevShop.startNewOrder(800, Day.MONDAY, customer.getName(), customer.getAge());

            double currentTotal = 0.0;

            boolean ordering = true;
            while (ordering) {
                System.out.print("Would you like to add a drink (Yes/No)? ");
                String addDrink = scanner.nextLine().toLowerCase();

                if (addDrink.equals("yes")) {
                    System.out.print("Please select a drink type (Coffee/Alcohol/Smoothie): ");
                    String drinkType = scanner.nextLine().toLowerCase();

                    System.out.print("Please select a drink size (Small/Medium/Large): ");
                    Size size = Size.valueOf(scanner.nextLine().toUpperCase());

                    switch (drinkType) {
                        case "coffee":
                            System.out.print("Do you want an extra shot? (Yes/No): ");
                            boolean extraShot = scanner.nextLine().equalsIgnoreCase("yes");

                            System.out.print("Do you want extra syrup? (Yes/No): ");
                            boolean extraSyrup = scanner.nextLine().equalsIgnoreCase("yes");

                            bevShop.processCoffeeOrder("Coffee", size, extraShot, extraSyrup);
                            break;
                        case "alcohol":
                            bevShop.processAlcoholOrder("Alcohol", size);
                            break;
                        case "smoothie":
                            System.out.print("How many fruits do you want to add? ");
                            int numOfFruits = Integer.parseInt(scanner.nextLine());

                            System.out.print("Do you want to add protein? (Yes/No): ");
                            boolean addProtein = scanner.nextLine().equalsIgnoreCase("yes");

                            bevShop.processSmoothieOrder("Smoothie", size, numOfFruits, addProtein);
                            break;
                        default:
                            System.out.println("Invalid drink type.");
                            break;
                    }

                    currentTotal = bevShop.getCurrentOrder().calcOrderTotal();
                    System.out.println("The Total price on the Order: " + currentTotal);
                } else if (addDrink.equals("no")) {
                    ordering = false;
                } else {
                    System.out.println("Invalid input. Please enter Yes or No.");
                }
            }

            System.out.println("#------------------------------------#");
            System.out.print("Would you like to start a new order (Yes/No)? ");
            String startNewOrder = scanner.nextLine().toLowerCase();

            if (startNewOrder.equals("no")) {
                done = true;
            }
        }
        
        double totalSales = bevShop.totalMonthlySale();
        System.out.println("Total sales for all orders: $" + totalSales);

        scanner.close();

        System.out.println("Thank you for visiting The Beverage Shop!");
    }
}
