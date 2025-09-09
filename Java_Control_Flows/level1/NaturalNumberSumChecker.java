import java.util.Scanner;

public class NaturalNumberSumChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        if (n > 0) {
            long sumByFormula = (long) n * (n + 1) / 2;

            long sumByLoop = 0;
            int i = 1;
            while (i <= n) {
                sumByLoop += i;
                i++;
            }

            System.out.println("The sum using the formula is: " + sumByFormula);
            System.out.println("The sum using the while loop is: " + sumByLoop);

            if (sumByFormula == sumByLoop) {
                System.out.println("Both computations yield the same result.");
            } else {
                System.out.println("There was an error in the calculation. The results do not match.");
            }
        } else {
            System.out.println("The number " + n + " is not a natural number.");
        }

        scanner.close();
    }
}
