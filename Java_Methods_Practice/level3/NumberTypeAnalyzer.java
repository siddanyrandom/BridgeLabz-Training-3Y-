import java.util.*;

public class NumberTypeAnalyzer {   // fresh class name

    // Sum of proper divisors of n (excluding n itself)
    public static int sumOfProperDivisors(int n) {
        int sum = 1; // 1 is a proper divisor for n > 1
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) sum += n / i;
            }
        }
        return n == 1 ? 0 : sum;
    }

    public static boolean isPerfect(int n) {
        return n > 1 && sumOfProperDivisors(n) == n;
    }

    public static boolean isAbundant(int n) {
        return n > 1 && sumOfProperDivisors(n) > n;
    }

    public static boolean isDeficient(int n) {
        return n > 0 && sumOfProperDivisors(n) < n;
    }

    public static boolean isStrong(int n) {
        int temp = n, sum = 0;
        while (temp > 0) {
            sum += factorial(temp % 10);
            temp /= 10;
        }
        return sum == n;
    }

    private static int factorial(int x) {
        int f = 1;
        for (int i = 2; i <= x; i++) f *= i;
        return f;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num = sc.nextInt();

        System.out.println("Perfect number:   " + isPerfect(num));
        System.out.println("Abundant number:  " + isAbundant(num));
        System.out.println("Deficient number: " + isDeficient(num));
        System.out.println("Strong number:    " + isStrong(num));

        sc.close();
    }
}
