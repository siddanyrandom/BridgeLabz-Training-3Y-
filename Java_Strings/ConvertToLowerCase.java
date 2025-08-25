import java.util.Scanner;

public class ConvertToLowerCase {

    // Method to convert string to lowercase using charAt()
    public static String toLowerCaseUsingCharAt(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32); // Convert to lowercase
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
        String lowerCharAt = toLowerCaseUsingCharAt(input);

        // Convert using built-in method
        String lowerBuiltIn = input.toLowerCase();

        // Compare the results
        boolean areSame = compareStrings(lowerCharAt, lowerBuiltIn);

        // Display results
        System.out.println("Lowercase using charAt() method: " + lowerCharAt);
        System.out.println("Lowercase using built-in toLowerCase(): " + lowerBuiltIn);
        System.out.println("Do both results match? " + areSame);

        sc.close();
    }
}
