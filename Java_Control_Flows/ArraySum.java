import java.util.Scanner;

public class ArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Array to hold up to 10 elements
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        System.out.println("Enter up to 10 positive numbers (0 or negative to stop):");

        // Infinite loop until conditions break
        while (true) {
            System.out.print("Enter number " + (index + 1) + ": ");
            double value = sc.nextDouble();

            // Check for stop conditions
            if (value <= 0) {
                break;
            }
            if (index == 10) {
                System.out.println("Array limit reached (10 numbers).");
                break;
            }

            // Store value in array
            numbers[index] = value;
            index++;
        }

        // Calculate sum
        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }

        // Display results
        System.out.println("\nYou entered the following numbers:");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println("\nTotal sum = " + total);

        sc.close();
    }
}
