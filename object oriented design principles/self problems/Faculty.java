import java.util.ArrayList;
import java.util.List;

class Faculty {
    private String name;
    private String specialization;

    public Faculty(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() { return name; }
    public String getSpecialization() { return specialization; }

    @Override
    public String toString() {
        return name + " (" + specialization + ")";
    }
}

class Department {
    private String name;
    private List<Faculty> faculties;

    public Department(String name) {
        this.name = name;
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty f) {
        faculties.add(f);
    }

    public void showDetails() {
        System.out.println("Department: " + name);
        if (faculties.isEmpty()) {
            System.out.println("  • No faculty assigned");
        } else {
            for (Faculty f : faculties) {
                System.out.println("  • " + f);
            }
        }
        System.out.println();
    }
}

class University {
    private String name;
    private List<Department> departments;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public Department addDepartment(String deptName) {
        Department d = new Department(deptName);
        departments.add(d);
        return d;
    }

    public void showStructure() {
        System.out.println("University: " + name);
        for (Department d : departments) {
            d.showDetails();
        }
    }

    public void closeUniversity() {
        departments.clear();
        System.out.println("University " + name + " is closed. All departments are removed.");
    }
}

public class UniversityCompositionAggregationDemo {
    public static void main(String[] args) {
        Faculty f1 = new Faculty("Alice", "Computer Science");
        Faculty f2 = new Faculty("Bob", "Mathematics");
        Faculty f3 = new Faculty("Carol", "Physics");

        University uni = new University("Global Tech University");

        Department cs = uni.addDepartment("Computer Science");
        Department math = uni.addDepartment("Mathematics");

        cs.addFaculty(f1);
        math.addFaculty(f2);
        math.addFaculty(f3);

        System.out.println("=== University Structure ===");
        uni.showStructure();

        System.out.println("=== Independent Faculty Member ===");
        Faculty independent = new Faculty("David", "Economics");
        System.out.println(independent);

        System.out.println("\nClosing University...");
        uni.closeUniversity();

        System.out.println("\nFaculty members still exist independently:");
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(independent);
    }
}
