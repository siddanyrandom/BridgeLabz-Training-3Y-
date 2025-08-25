import java.util.Scanner;

public class CharFrequencyNestedLoops {

    // Method to find frequency of characters using nested loops
    public static String[] findFrequency(String text) {
        text = text.replaceAll("\\s", ""); // remove spaces
        char[] chars = text.toCharArray();
        int n = chars.length;
        int[] freq = new int[n];

        for (int i = 0; i < n; i++) {
            freq[i] = 1; // initialize frequency
            for (int j = i + 1; j < n; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // mark duplicate
                }
            }
        }

        // Count number of unique characters
        int uniqueCount = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] != '0') uniqueCount++;
        }

        // Create result array
        String[] result = new String[uniqueCount];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " = " + freq[i];
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] frequency = findFrequency(text);

        System.out.println("Character Frequencies:");
        for (String s : frequency) {
            System.out.println(s);
        }

        sc.close();
    }
}
