import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() { return name; }
    public String getRole() { return role; }

    @Override
    public String toString() {
        return name + " (" + role + ")";
    }
}

class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String empName, String role) {
        employees.add(new Employee(empName, role));
    }

    public void showEmployees() {
        System.out.println("Department: " + name);
        for (Employee e : employees) {
            System.out.println("  • " + e);
        }
        System.out.println();
    }
}

class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public Department addDepartment(String deptName) {
        Department d = new Department(deptName);
        departments.add(d);
        return d;
    }

    public void showStructure() {
        System.out.println("Company: " + name);
        for (Department d : departments) {
            d.showEmployees();
        }
    }

    public void closeCompany() {
        departments.clear();
        System.out.println("Company " + name + " is closed. All departments and employees are removed.");
    }
}

public class CompositionDemo {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");

        Department dev = company.addDepartment("Development");
        dev.addEmployee("Alice", "Developer");
        dev.addEmployee("Bob", "Senior Developer");

        Department hr = company.addDepartment("Human Resources");
        hr.addEmployee("Carol", "HR Manager");

        company.showStructure();

        company.closeCompany();
    }
}
