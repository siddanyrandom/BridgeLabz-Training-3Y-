import java.util.Scanner;

public class BMI_Team {

    // Method to calculate BMI and return BMI value and status
    public static String[][] calculateBMI(double[][] data) {
        String[][] result = new String[data.length][4];

        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100.0;

            double bmi = weight / (heightM * heightM);
            bmi = Math.round(bmi * 100.0) / 100.0; // round to 2 decimals

            String status;
            if (bmi < 18.5) {
                status = "Underweight";
            } else if (bmi < 25) {
                status = "Normal weight";
            } else if (bmi < 30) {
                status = "Overweight";
            } else {
                status = "Obese";
            }

            result[i][0] = String.valueOf(heightCm);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.valueOf(bmi);
            result[i][3] = status;
        }

        return result;
    }

    // Method to display 2D array in tabular format
    public static void displayBMI(String[][] bmiData) {
        System.out.printf("%-10s %-10s %-10s %-15s%n", "Height(cm)", "Weight(kg)", "BMI", "Status");
        System.out.println("---------------------------------------------------");
        for (int i = 0; i < bmiData.length; i++) {
            System.out.printf("%-10s %-10s %-10s %-15s%n", 
                              bmiData[i][0], bmiData[i][1], bmiData[i][2], bmiData[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10; // number of persons
        double[][] data = new double[n][2];

        System.out.println("Enter weight(kg) and height(cm) for 10 persons:");
        for (int i = 0; i < n; i++) {
            System.out.print("Person " + (i + 1) + " Weight (kg): ");
            data[i][0] = sc.nextDouble();
            System.out.print("Person " + (i + 1) + " Height (cm): ");
            data[i][1] = sc.nextDouble();
        }

        String[][] bmiData = calculateBMI(data);
        displayBMI(bmiData);

        sc.close();
    }
}
