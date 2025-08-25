import java.util.Random;
import java.util.Scanner;

public class StudentScoreCard {

    // Method to generate random PCM scores for n students
    public static int[][] generateScores(int n) {
        Random rand = new Random();
        int[][] scores = new int[n][3]; // Physics, Chemistry, Maths
        for (int i = 0; i < n; i++) {
            scores[i][0] = rand.nextInt(100) + 1; // Physics 1-100
            scores[i][1] = rand.nextInt(100) + 1; // Chemistry 1-100
            scores[i][2] = rand.nextInt(100) + 1; // Maths 1-100
        }
        return scores;
    }

    // Method to calculate total, average, percentage
    public static double[][] calculateStats(int[][] scores) {
        int n = scores.length;
        double[][] stats = new double[n][3]; // total, average, percentage
        for (int i = 0; i < n; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double perc = (total / 300.0) * 100;
            stats[i][0] = Math.round(total * 100.0) / 100.0;
            stats[i][1] = Math.round(avg * 100.0) / 100.0;
            stats[i][2] = Math.round(perc * 100.0) / 100.0;
        }
        return stats;
    }

    // Method to calculate grade based on percentage
    public static String[] calculateGrades(double[][] stats) {
        int n = stats.length;
        String[] grades = new String[n];
        for (int i = 0; i < n; i++) {
            double perc = stats[i][2];
            if (perc >= 90) grades[i] = "A+";
            else if (perc >= 80) grades[i] = "A";
            else if (perc >= 70) grades[i] = "B+";
            else if (perc >= 60) grades[i] = "B";
            else if (perc >= 50) grades[i] = "C";
            else grades[i] = "F";
        }
        return grades;
    }

    // Method to display scorecard
    public static void displayScoreCard(int[][] scores, double[][] stats, String[] grades) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");
        System.out.println("--------------------------------------------------------------------------");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t%d\t\t%d\t%.0f\t%.2f\t%.2f\t\t%s\n",
                              i+1, scores[i][0], scores[i][1], scores[i][2],
                              stats[i][0], stats[i][1], stats[i][2], grades[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] scores = generateScores(n);
        double[][] stats = calculateStats(scores);
        String[] grades = calculateGrades(stats);

        displayScoreCard(scores, stats, grades);

        sc.close();
    }
}
