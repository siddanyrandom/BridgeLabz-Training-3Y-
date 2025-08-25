import java.util.Scanner;

public class VowelsConsonantsTable {

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

    // Method to analyze string and return 2D array
    public static String[][] analyzeString(String str) {
        int len = str.length();
        String[][] result = new String[len][2];
        for (int i = 0; i < len; i++) {
            result[i][0] = String.valueOf(str.charAt(i));
            result[i][1] = checkChar(str.charAt(i));
        }
        return result;
    }

    // Method to display 2D array in tabular format
    public static void displayTable(String[][] data) {
        System.out.println("Character\tType");
        System.out.println("---------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] analysis = analyzeString(input);
        displayTable(analysis);

        sc.close();
    }
}
