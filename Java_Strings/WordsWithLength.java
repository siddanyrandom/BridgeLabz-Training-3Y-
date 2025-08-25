import java.util.Scanner;
import java.util.ArrayList;

public class WordsWithLength {

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
        if (start < len) {
            words.add(text.substring(start, len));
        }

        String[] result = new String[words.size()];
        for (int i = 0; i < words.size(); i++) {
            result[i] = words.get(i);
        }
        return result;
    }

    // Method to create 2D array of word and its length
    public static String[][] wordsWithLength(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String input = sc.nextLine();

        // Split into words using charAt()
        String[] words = splitWords(input);

        // Create 2D array with words and lengths
        String[][] wordLengthArray = wordsWithLength(words);

        // Display in tabular format
        System.out.println("\nWord\tLength");
        System.out.println("----------------");
        for (int i = 0; i < wordLengthArray.length; i++) {
            System.out.println(wordLengthArray[i][0] + "\t" + Integer.parseInt(wordLengthArray[i][1]));
        }

        sc.close();
    }
}
