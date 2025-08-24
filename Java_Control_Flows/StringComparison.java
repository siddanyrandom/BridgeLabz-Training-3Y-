import java.util.Scanner;

public class StringComparison {

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

        // Take input strings
        System.out.print("Enter first string: ");
        String str1 = sc.next();
        System.out.print("Enter second string: ");
        String str2 = sc.next();

        // Compare using custom method
        boolean charAtResult = compareStrings(str1, str2);

        // Compare using built-in equals method
        boolean equalsResult = str1.equals(str2);

        // Display results
        System.out.println("Comparison using charAt() method: " + charAtResult);
        System.out.println("Comparison using equals() method: " + equalsResult);

        if (charAtResult == equalsResult) {
            System.out.println("Both methods give the same result.");
        } else {
            System.out.println("The results differ.");
        }

        sc.close();
    }
}
