import java.util.Scanner;

public class ConvertToUpperCase {

    // Method to convert string to uppercase using charAt()
    public static String toUpperCaseUsingCharAt(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32); // Convert to uppercase
            }
            result += ch;
        }
        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2) {
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

        System.out.print("Enter the text: ");
        String input = sc.nextLine();

        // Convert using user-defined method
        String upperCharAt = toUpperCaseUsingCharAt(input);

        // Convert using built-in method
        String upperBuiltIn = input.toUpperCase();

        // Compare the results
        boolean areSame = compareStrings(upperCharAt, upperBuiltIn);

        // Display results
        System.out.println("Uppercase using charAt() method: " + upperCharAt);
        System.out.println("Uppercase using built-in toUpperCase(): " + upperBuiltIn);
        System.out.println("Do both results match? " + areSame);

        sc.close();
    }
}
