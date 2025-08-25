import java.util.Scanner;
import java.util.Random;

public class VotingEligibility {

    // Method to generate random ages for n students
    public static int[] generateAges(int n) {
        Random rand = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = rand.nextInt(90) + 1; // Age between 1 and 90
        }
        return ages;
    }

    // Method to check voting eligibility and return 2D array
    public static String[][] checkVotingEligibility(int[] ages) {
        int n = ages.length;
        String[][] result = new String[n][2];
        for (int i = 0; i < n; i++) {
            int age = ages[i];
            result[i][0] = String.valueOf(age);
            if (age < 0) {
                result[i][1] = "Cannot vote (invalid age)";
            } else if (age >= 18) {
                result[i][1] = "Can vote";
            } else {
                result[i][1] = "Cannot vote";
            }
        }
        return result;
    }

    // Method to display 2D array in tabular format
    public static void displayTable(String[][] data) {
        System.out.println("Age\tEligibility");
        System.out.println("---------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Generate ages
        int[] ages = generateAges(n);

        // Check voting eligibility
        String[][] eligibility = checkVotingEligibility(ages);

        // Display result
        displayTable(eligibility);

        sc.close();
    }
}
