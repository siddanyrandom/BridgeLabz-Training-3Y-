import java.util.*;

public class NumberProperties {   // new class name

    public static boolean checkPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean checkNeon(int n) {
        int square = n * n;
        int sum = 0;
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == n;
    }

    public static boolean checkSpy(int n) {
        int sum = 0, product = 1, temp = n;
        while (temp > 0) {
            int d = temp % 10;
            sum += d;
            product *= d;
            temp /= 10;
        }
        return sum == product;
    }

    public static boolean checkAutomorphic(int n) {
        long sq = (long) n * n;
        return String.valueOf(sq).endsWith(String.valueOf(n));
    }

    public static boolean checkBuzz(int n) {
        return n % 7 == 0 || n % 10 == 7;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.println("Prime number: " + checkPrime(num));
        System.out.println("Neon number: " + checkNeon(num));
        System.out.println("Spy number: " + checkSpy(num));
        System.out.println("Automorphic number: " + checkAutomorphic(num));
        System.out.println("Buzz number: " + checkBuzz(num));

        sc.close();
    }
}
