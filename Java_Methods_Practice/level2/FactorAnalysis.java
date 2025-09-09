import java.util.Scanner;

public class FactorAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int[] factors = findFactors(number);

        System.out.print("Factors: ");
        for (int f : factors) {
            System.out.print(f + " ");
        }
        System.out.println();

        int sum = sumOfFactors(factors);
        int sumSquares = sumOfSquares(factors);
        long product = productOfFactors(factors);

        System.out.println("Sum of factors: " + sum);
        System.out.println("Sum of squares of factors: " + sumSquares);
        System.out.println("Product of factors: " + product);

        sc.close();
    }

    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int f : factors) {
            sum += f;
        }
        return sum;
    }

    public static int sumOfSquares(int[] factors) {
        int sumSquares = 0;
        for (int f : factors) {
            sumSquares += Math.pow(f, 2);
        }
        return sumSquares;
    }

    public static long productOfFactors(int[] factors) {
        long product = 1;
        for (int f : factors) {
            product *= f;
        }
        return product;
    }
}
