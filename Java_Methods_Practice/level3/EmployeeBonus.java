import java.util.*;

public class EmployeeBonus {

    public static double[][] generateSalaryAndService(int numEmployees) {
        double[][] data = new double[numEmployees][2]; // column 0: salary, column 1: years of service
        for (int i = 0; i < numEmployees; i++) {
            data[i][0] = (int) (Math.random() * 90000) + 10000; // 5-digit salary 10000–99999
            data[i][1] = (int) (Math.random() * 15) + 1;        // years of service 1–15
        }
        return data;
    }

    public static double[][] calculateNewSalaryAndBonus(double[][] data) {
        double[][] result = new double[data.length][2]; // column 0: new salary, column 1: bonus
        for (int i = 0; i < data.length; i++) {
            double salary = data[i][0];
            double years = data[i][1];
            double bonus = (years > 5) ? salary * 0.05 : salary * 0.02;
            double newSalary = salary + bonus;
            result[i][0] = newSalary;
            result[i][1] = bonus;
        }
        return result;
    }

    public static void displayTotals(double[][] oldData, double[][] newData) {
        double sumOld = 0, sumNew = 0, totalBonus = 0;
        System.out.printf("%-10s %-12s %-12s %-12s %-12s%n", "Employee", "Old Salary", "Years", "Bonus", "New Salary");
        for (int i = 0; i < oldData.length; i++) {
            double oldSalary = oldData[i][0];
            double years = oldData[i][1];
            double bonus = newData[i][1];
            double newSalary = newData[i][0];
            sumOld += oldSalary;
            sumNew += newSalary;
            totalBonus += bonus;
            System.out.printf("%-10d %-12.2f %-12.0f %-12.2f %-12.2f%n", i + 1, oldSalary, years, bonus, newSalary);
        }
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-10s %-12.2f %-12s %-12.2f %-12.2f%n", "TOTAL", sumOld, "", totalBonus, sumNew);
    }

    public static void main(String[] args) {
        int numEmployees = 10;
        double[][] employeeData = generateSalaryAndService(numEmployees);
        double[][] newData = calculateNewSalaryAndBonus(employeeData);
        displayTotals(employeeData, newData);
    }
}
