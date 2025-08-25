import java.util.Scanner;

public class StringToCharArray {

    // Method to return characters of a string without using toCharArray()
    public static char[] getChars(String str) {
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        return chars;
    }

    // Method to compare two char arrays
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
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

        // Get chars using user-defined method
        char[] userChars = getChars(input);

        // Get chars using built-in method
        char[] builtInChars = input.toCharArray();

        // Compare both arrays
        boolean areSame = compareCharArrays(userChars, builtInChars);

        // Display results
        System.out.print("Characters using user-defined method: ");
        for (char c : userChars) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.print("Characters using built-in toCharArray(): ");
        for (char c : builtInChars) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.println("Are both arrays same? " + areSame);

        sc.close();
    }
}
