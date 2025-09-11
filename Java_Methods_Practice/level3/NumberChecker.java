import java.util.*;

public class NumberChecker {

    public static int countDigits(int num) {
        return String.valueOf(Math.abs(num)).length();
    }

    public static int[] digitsArray(int num) {
        String s = String.valueOf(Math.abs(num));
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        return digits;
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d == 0) return true;
        }
        return false;
    }

    public static boolean isArmstrong(int num, int[] digits) {
        int n = digits.length;
        int sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, n);
        }
        return sum == num;
    }

    public static int[] findLargestTwo(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int d : digits) {
            if (d > largest) {
                second = largest;
                largest = d;
            } else if (d > second && d != largest) {
                second = d;
            }
        }
        return new int[]{largest, second == Integer.MIN_VALUE ? largest : second};
    }

    public static int[] findSmallestTwo(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int d : digits) {
            if (d < smallest) {
                second = smallest;
                smallest = d;
            } else if (d < second && d != smallest) {
                second = d;
            }
        }
        return new int[]{smallest, second == Integer.MAX_VALUE ? smallest : second};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int count = countDigits(num);
        int[] digits = digitsArray(num);

        System.out.println("Number of digits: " + count);
        System.out.println("Digits array: " + Arrays.toString(digits));
        System.out.println("Duck number: " + isDuckNumber(digits));
        System.out.println("Armstrong number: " + isArmstrong(num, digits));

        int[] largestTwo = findLargestTwo(digits);
        System.out.println("Largest digit: " + largestTwo[0] + ", Second largest: " + largestTwo[1]);

        int[] smallestTwo = findSmallestTwo(digits);
        System.out.println("Smallest digit: " + smallestTwo[0] + ", Second smallest: " + smallestTwo[1]);

        sc.close();
    }
}
