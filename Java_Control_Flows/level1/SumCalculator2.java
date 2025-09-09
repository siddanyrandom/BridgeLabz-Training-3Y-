import java.util.Scanner;

public class SumCalculator2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        
        System.out.println("Enter numbers to sum. Enter a negative number or zero to see the total.");

        while (true) {
            System.out.print("Enter a number: ");
            double number = scanner.nextDouble();

            if (number <= 0) {
                break;
            }

            total += number;
        }

        System.out.println("The total sum of the numbers is: " + total);
        
        scanner.close();
    }
}
