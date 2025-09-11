import java.util.*;

public class NumberChecker3{

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

    public static int[] reverseArray(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    public static boolean arraysEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static boolean isPalindrome(int[] digits) {
        return arraysEqual(digits, reverseArray(digits));
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int[] digits = digitsArray(num);
        int[] reversed = reverseArray(digits);

        System.out.println("Number of digits: " + countDigits(num));
        System.out.println("Digits array: " + Arrays.toString(digits));
        System.out.println("Reversed array: " + Arrays.toString(reversed));
        System.out.println("Arrays equal: " + arraysEqual(digits, reversed));
        System.out.println("Palindrome number: " + isPalindrome(digits));
        System.out.println("Duck number: " + isDuckNumber(digits));

        sc.close();
    }
}
