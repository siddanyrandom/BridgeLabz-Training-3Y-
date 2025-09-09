import java.util.Scanner;

public class TriangleRun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double side1 = sc.nextDouble();
        double side2 = sc.nextDouble();
        double side3 = sc.nextDouble();

        int rounds = calculateRounds(side1, side2, side3);
        System.out.println("Number of rounds to complete 5 km: " + rounds);

        sc.close();
    }

    public static int calculateRounds(double a, double b, double c) {
        double perimeter = a + b + c;
        double distanceToRun = 5000.0;
        return (int) Math.ceil(distanceToRun / perimeter);
    }
}
