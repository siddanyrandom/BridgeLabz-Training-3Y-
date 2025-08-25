import java.util.Scanner;

public class NumberFormatDemo {

    // Method to generate NumberFormatException
    public static void generateException(String text) {
        // This will throw NumberFormatException if text is not a valid integer
        int num = Integer.parseInt(text);
        System.out.println("Parsed number: " + num);
    }

    // Method to handle NumberFormatException
    public static void handleException(String text) {
        try {
            int num = Integer.parseInt(text);
            System.out.println("Parsed number: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught other RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a text to parse as number: ");
        String input = sc.nextLine();

        System.out.println("\nDemonstrating NumberFormatException generation:");
        try {
            generateException(input);
        } catch (NumberFormatException e) {
            System.out.println("Exception caught in main: " + e);
        }

        System.out.println("\nDemonstrating NumberFormatException handling:");
        handleException(input);

        sc.close();
    }
}
