import java.util.Scanner;

public class MultiplicationTableRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input number
        System.out.print("Enter a number to print its multiplication table from 6 to 9: ");
        int number = sc.nextInt();

        // Array to store results (4 numbers * 10 results each = 40 slots)
        int[] multiplicationResult = new int[40];
        int index = 0;

        // Generate tables for 6 to 9
        for (int i = 6; i <= 9; i++) {
            for (int j = 1; j <= 10; j++) {
                multiplicationResult[index] = i * number;
                System.out.println(i + " * " + number + " = " + multiplicationResult[index]);
                index++;
            }
        }

        sc.close();
    }
}
