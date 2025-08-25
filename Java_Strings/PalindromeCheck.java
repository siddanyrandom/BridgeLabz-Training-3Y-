import java.util.Scanner;

public class PalindromeCheck {

    // Logic 1: Iterative using start and end index
    public static boolean isPalindromeIterative(String text) {
        text = text.replaceAll("\\s", "").toLowerCase();
        int start = 0;
        int end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        text = text.replaceAll("\\s", "").toLowerCase();
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Logic 3: Using char arrays
    public static boolean isPalindromeCharArray(String text) {
        text = text.replaceAll("\\s", "").toLowerCase();
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println("Using Iterative method: " + 
            (isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome"));

        System.out.println("Using Recursive method: " + 
            (isPalindromeRecursive(text, 0, text.replaceAll(\"\\\\s\", \"\").length() - 1) ? "Palindrome" : "Not Palindrome"));

        System.out.println("Using Char Array method: " + 
            (isPalindromeCharArray(text) ? "Palindrome" : "Not Palindrome"));

        sc.close();
    }
}
