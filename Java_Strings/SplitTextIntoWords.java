import java.util.Scanner;
import java.util.ArrayList;

public class SplitTextIntoWords {

    // Method to find string length without using length()
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // End of string
        }
        return count;
    }

    // Method to split text into words using charAt()
    public static String[] splitWords(String text) {
        ArrayList<String> words = new ArrayList<>();
        int start = 0;
        int len = getLength(text);

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                if (start != i) { // skip multiple spaces
                    words.add(text.substring(start, i));
                }
                start = i + 1;
            }
        }
        // Add last word
        if (start < len) {
            words.add(text.substring(start, len));
        }

        // Convert ArrayList to array
        String[] result = new String[words.size()];
        for (int i = 0; i < words.size(); i++) {
            result[i] = words.get(i);
        }
        return result;
    }

    // Method to compare two string arrays
    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String input = sc.nextLine();

        // Split using user-defined method
        String[] wordsCustom = splitWords(input);

        // Split using built-in split()
        String[] wordsBuiltIn = input.split(" ");

        // Compare results
        boolean areSame = compareStringArrays(wordsCustom, wordsBuiltIn);

        // Display results
        System.out.println("\nWords using user-defined method:");
        for (String word : wordsCustom) {
            System.out.println(word);
        }

        System.out.println("\nWords using built-in split():");
        for (String word : wordsBuiltIn) {
            System.out.println(word);
        }

        System.out.println("\nDo both results match? " + areSame);

        sc.close();
    }
}
