import java.util.Scanner;

public class CharFrequencyUnique {

    // Method to find unique characters using nested loops
    public static char[] uniqueCharacters(String text) {
        StringBuilder unique = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                unique.append(ch);
            }
        }
        return unique.toString().toCharArray();
    }

    // Method to find frequency using ASCII indexes and unique characters
    public static String[][] frequency(String text) {
        int[] freq = new int[256]; // ASCII array

        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        char[] uniqueChars = uniqueCharacters(text);
        String[][] result = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(freq[uniqueChars[i]]);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[][] freqTable = frequency(text);

        System.out.println("Character Frequencies:");
        System.out.println("Char | Frequency");
        for (int i = 0; i < freqTable.length; i++) {
            System.out.printf("  %s  |     %s%n", freqTable[i][0], freqTable[i][1]);
        }

        sc.close();
    }
}
