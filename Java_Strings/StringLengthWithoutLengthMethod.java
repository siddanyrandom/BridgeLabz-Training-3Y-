import java.util.Scanner;

public class StringLengthWithoutLengthMethod {

    // Method to find string length without using length()
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // Reached end of string
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.next();

        // Find length using user-defined method
        int lengthCustom = getLength(input);

        // Find length using built-in method
        int lengthBuiltIn = input.length();

        // Display results
        System.out.println("Length using user-defined method: " + lengthCustom);
        System.out.println("Length using built-in length(): " + lengthBuiltIn);

        sc.close();
    }
}
