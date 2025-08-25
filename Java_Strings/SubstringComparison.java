import java.util.Scanner;

public class SubstringComparison {

    // Method to create substring using charAt()
    public static String substringUsingCharAt(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end && i < str.length(); i++) {
            result += str.charAt(i);
        }
        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input string
        System.out.print("Enter a string: ");
        String input = sc.next();

        // Take start and end index
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        // Substring using charAt()
        String subCharAt = substringUsingCharAt(input, start, end);

        // Substring using built-in method
        String subBuiltIn = "";
        if (start >= 0 && end <= input.length() && start < end) {
            subBuiltIn = input.substring(start, end);
        }

        // Compare both substrings
        boolean comparisonResult = compareUsingCharAt(subCharAt, subBuiltIn);

        // Display results
        System.out.println("Substring using charAt(): " + subCharAt);
        System.out.println("Substring using built-in substring(): " + subBuiltIn);
        System.out.println("Are both substrings same? " + comparisonResult);

        sc.close();
    }
}
