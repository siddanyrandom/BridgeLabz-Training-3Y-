import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Array for 11 players
        double[] heights = new double[11];
        double sum = 0.0;

        // Input heights
        System.out.println("Enter the height of 11 players in the football team:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Height of player " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
            sum += heights[i];
        }

        // Calculate mean
        double mean = sum / heights.length;

        // Display result
        System.out.println("\nMean height of the football team = " + mean);

        sc.close();
    }
}
