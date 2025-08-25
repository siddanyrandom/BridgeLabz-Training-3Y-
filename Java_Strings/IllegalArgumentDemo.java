import java.util.Scanner;

public class IllegalArgumentDemo {

    // Method to generate IllegalArgumentException
    public static void generateException(String text) {
        // This will throw IllegalArgumentException because start > end
        System.out.println("Substring result: " + text.substring(5, 2));
    }

    // Method to handle IllegalArgumentException
    public static void handleException(String text) {
        try {
            System.out.println("Substring result: " + text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught other RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("\nDemonstrating IllegalArgumentException generation:");
        try {
            generateException(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught in main: " + e);
        }

        System.out.println("\nDemonstrating IllegalArgumentException handling:");
        handleException(input);

        sc.close();
    }
}
