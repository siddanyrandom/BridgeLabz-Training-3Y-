import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take number input
        System.out.print("Enter a number to print its multiplication table: ");
        int number = sc.nextInt();

        // Define an array to store results from 1 to 10
        int[] table = new int[10];

        // Generate table
        for (int i = 0; i < table.length; i++) {
            table[i] = number * (i + 1);
        }

        // Display table
        System.out.println("\nMultiplication Table of " + number + ":");
        for (int i = 0; i < table.length; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + table[i]);
        }

        sc.close();
    }
}
