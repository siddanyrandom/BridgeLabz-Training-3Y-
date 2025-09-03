public class Employee {

    // Public variable: Accessible from anywhere.
    public int employeeID;

    // Protected variable: Accessible within the same class, subclasses, and the same package.
    protected String department;

    // Private variable: Only accessible within this class.
    private double salary;

    /**
     * Parameterized constructor for the Employee class.
     *
     * @param employeeID  The unique ID for the employee.
     * @param department  The department the employee belongs to.
     * @param salary      The employee's salary.
     */
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    /**
     * Public method to get the value of the private 'salary' variable.
     * This is a "getter" method.
     *
     * @return The employee's salary.
     */
    public double getSalary() {
        return this.salary;
    }

    /**
     * Public method to set the value of the private 'salary' variable.
     * This is a "setter" method that includes a basic validation check.
     *
     * @param newSalary The new salary to be set.
     */
    public void setSalary(double newSalary) {
        if (newSalary > 0) {
            this.salary = newSalary;
            System.out.println("Salary updated successfully.");
        } else {
            System.out.println("Invalid salary. Salary must be a positive value.");
        }
    }

    /**
     * A method to display the basic details of the employee.
     */
    public void displayEmployeeDetails() {
        System.out.println("Employee Details:");
        System.out.println("Employee ID: " + this.employeeID);
        System.out.println("Department: " + this.department);
        System.out.println("Salary: $" + String.format("%.2f", this.salary));
    }
}

/**
 * A subclass that inherits from the Employee class, representing a manager.
 * This class demonstrates how to access public and protected members from a subclass.
 */
class Manager extends Employee {

    private int teamSize;

    public Manager(int employeeID, String department, double salary, int teamSize) {
        // Call the superclass constructor to initialize inherited members
        super(employeeID, department, salary);
        this.teamSize = teamSize;
    }

    /**
     * A method to display details specific to a manager.
     * This method can directly access the public 'employeeID' and protected 'department'
     * variables from the superclass.
     */
    public void displayManagerDetails() {
        System.out.println("\nManager Details:");
        // Direct access to public member
        System.out.println("Employee ID: " + this.employeeID);
        // Direct access to protected member
        System.out.println("Department (from protected): " + this.department);
        // Cannot directly access private 'salary', must use the public getter method
        System.out.println("Salary: $" + String.format("%.2f", this.getSalary()));
        System.out.println("Team Size: " + this.teamSize + " members");
    }

    /**
     * Main method to demonstrate the functionality of the Employee and Manager classes.
     */
    public static void main(String[] args) {
        System.out.println("--- Demonstrating Access Modifiers ---");

        // 1. Working with a basic Employee object
        Employee emp1 = new Employee(1001, "Marketing", 55000.00);
        System.out.println("\nInitial Employee Details:");
        emp1.displayEmployeeDetails();

        // Accessing and modifying the private salary via public methods
        emp1.setSalary(58000.00);
        System.out.println("Updated Salary: $" + String.format("%.2f", emp1.getSalary()));

        // 2. Working with a Manager object (subclass)
        Manager mgr1 = new Manager(2001, "Development", 120000.00, 10);
        mgr1.displayManagerDetails();
    }
}
