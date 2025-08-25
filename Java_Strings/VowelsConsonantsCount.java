import java.util.Scanner;

public class VowelsConsonantsCount {

    // Method to check if a character is vowel or consonant
    public static String checkChar(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32); // convert to lowercase
        }
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    // Method to count vowels and consonants in a string
    public static int[] countVowelsConsonants(String str) {
        int vowels = 0;
        int consonants = 0;
        int len = str.length(); // built-in length() is allowed here
        for (int i = 0; i < len; i++) {
            String type = checkChar(str.charAt(i));
            if (type.equals("Vowel")) vowels++;
            else if (type.equals("Consonant")) consonants++;
        }
        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        int[] result = countVowelsConsonants(input);

        System.out.println("Number of vowels: " + result[0]);
        System.out.println("Number of consonants: " + result[1]);

        sc.close();
    }
}
