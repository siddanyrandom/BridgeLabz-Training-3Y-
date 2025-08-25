import java.util.Scanner;

public class CharFrequencyCharAt {

    // Method to find frequency using charAt()
    public static String[][] frequency(String text) {
        int[] freq = new int[256]; // ASCII frequency array

        // Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Count unique characters
        int uniqueCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                uniqueCount++;
            }
        }

        // Create result 2D array
        String[][] result = new String[uniqueCount][2];
        int index = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(freq[ch]);
                index++;
            }
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
