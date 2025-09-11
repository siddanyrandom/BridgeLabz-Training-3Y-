import java.util.Scanner;

public class TeamBMI {

    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightMeters = data[i][1] / 100.0;
            data[i][2] = weight / (heightMeters * heightMeters);
        }
    }

    public static String[] determineStatus(double[][] data) {
        String[] status = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi < 18.5) {
                status[i] = "Underweight";
            } else if (bmi < 25) {
                status[i] = "Normal";
            } else if (bmi < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] team = new double[10][3];

        for (int i = 0; i < team.length; i++) {
            System.out.print("Enter weight (kg) for member " + (i + 1) + ": ");
            team[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) for member " + (i + 1) + ": ");
            team[i][1] = sc.nextDouble();
        }

        calculateBMI(team);
        String[] status = determineStatus(team);

        System.out.println("\nMember | Weight(kg) | Height(cm) | BMI     | Status");
        for (int i = 0; i < team.length; i++) {
            System.out.printf("%6d | %10.2f | %9.2f | %7.2f | %s%n",
                    (i + 1), team[i][0], team[i][1], team[i][2], status[i]);
        }

        sc.close();
    }
}
