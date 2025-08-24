import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int EMP_COUNT = 10;
        double[] salaries = new double[EMP_COUNT];
        double[] yearsOfService = new double[EMP_COUNT];
        double[] bonuses = new double[EMP_COUNT];
        double[] newSalaries = new double[EMP_COUNT];

        double totalBonus = 0.0, totalOldSalary = 0.0, totalNewSalary = 0.0;

        // Input salaries and years of service
        for (int i = 0; i < EMP_COUNT; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1) + ":");

            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            if (salary <= 0) {
                System.out.println("Invalid salary! Please enter again.");
                i--; // retry
                continue;
            }

            System.out.print("Years of Service: ");
            double service = sc.nextDouble();
            if (service < 0) {
                System.out.println("Invalid years of service! Please enter again.");
                i--; // retry
                continue;
            }

            salaries[i] = salary;
            yearsOfService[i] = service;
        }

        // Calculate bonuses and new salaries
        for (int i = 0; i < EMP_COUNT; i++) {
            double bonusRate = (yearsOfService[i] > 5) ? 0.05 : 0.02;
            bonuses[i] = salaries[i] * bonusRate;
            newSalaries[i] = salaries[i] + bonuses[i];

            totalBonus += bonuses[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }

        // Print results
        System.out.println("\n===== Zara Bonus Report =====");
        for (int i = 0; i < EMP_COUNT; i++) {
            System.out.printf("Employee %d: Old Salary = %.2f, Bonus = %.2f, New Salary = %.2f%n",
                    (i + 1), salaries[i], bonuses[i], newSalaries[i]);
        }

        System.out.println("\n===== Totals =====");
        System.out.printf("Total Old Salary = %.2f%n", totalOldSalary);
        System.out.printf("Total Bonus Payout = %.2f%n", totalBonus);
        System.out.printf("Total New Salary = %.2f%n", totalNewSalary);

        sc.close();
    }
}
