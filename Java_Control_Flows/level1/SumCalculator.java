import java.util.Scanner;

public class SumCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        double number;

        System.out.println("Enter numbers to sum. Enter 0 to see the total.");

        do {
            System.out.print("Enter a number: ");
            number = scanner.nextDouble();
            total += number;
        } while (number != 0);

        System.out.println("The total sum of the numbers is: " + total);
        
        scanner.close();
    }
}
