import java.util.Scanner;

public class TrimString {

    // Method to find start and end indices after trimming
    public static int[] trimIndices(String str) {
        int len = str.length();
        int start = 0;
        int end = len - 1;

        // Trim leading spaces
        while (start < len && str.charAt(start) == ' ') {
            start++;
        }

        // Trim trailing spaces
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    // Method to get substring using charAt()
    public static String substringCharAt(String str, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string with leading/trailing spaces: ");
        String input = sc.nextLine();

        // User-defined trim using charAt()
        int[] indices = trimIndices(input);
        String trimmedCustom = substringCharAt(input, indices[0], indices[1]);

        // Built-in trim
        String trimmedBuiltIn = input.trim();

        // Compare
        boolean isSame = compareStrings(trimmedCustom, trimmedBuiltIn);

        System.out.println("\nTrimmed string using charAt(): \"" + trimmedCustom + "\"");
        System.out.println("Trimmed string using built-in trim(): \"" + trimmedBuiltIn + "\"");
        System.out.println("Do both trimmed strings match? " + isSame);

        sc.close();
    }
}
