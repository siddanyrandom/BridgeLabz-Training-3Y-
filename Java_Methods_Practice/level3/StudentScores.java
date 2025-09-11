import java.util.*;

public class StudentScores {

    public static int[][] generateRandomScores(int numStudents) {
        int[][] scores = new int[numStudents][3]; // 3 subjects: Physics, Chemistry, Maths
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = (int) (Math.random() * 91) + 10; // 2-digit scores (10 to 100)
            }
        }
        return scores;
    }

    public static double[][] calculateTotalAvgPercent(int[][] scores) {
        int numStudents = scores.length;
        double[][] result = new double[numStudents][3]; // column 0: total, 1: average, 2: percentage

        for (int i = 0; i < numStudents; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percent = total / 300.0 * 100.0;

            result[i][0] = Math.round(total * 100.0) / 100.0;
            result[i][1] = Math.round(avg * 100.0) / 100.0;
            result[i][2] = Math.round(percent * 100.0) / 100.0;
        }

        return result;
    }

    public static void displayScorecard(int[][] scores, double[][] totals) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t%d\t\t%d\t%.2f\t%.2f\t%.2f%n",
                    i + 1, scores[i][0], scores[i][1], scores[i][2],
                    totals[i][0], totals[i][1], totals[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();

        int[][] scores = generateRandomScores(numStudents);
        double[][] totals = calculateTotalAvgPercent(scores);

        displayScorecard(scores, totals);

        sc.close();
    }
}
