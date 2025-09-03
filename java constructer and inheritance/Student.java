public class Student {

    // Public variable: Accessible from anywhere.
    public int rollNumber;

    // Protected variable: Accessible within the same class, subclasses, and the same package.
    protected String name;

    // Private variable: Only accessible within this class.
    private double CGPA;

    /**
     * Parameterized constructor for the Student class.
     *
     * @param rollNumber The student's roll number.
     * @param name       The student's name.
     * @param CGPA       The student's CGPA.
     */
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    /**
     * Public method to get the value of the private CGPA variable.
     * This is a "getter" method.
     *
     * @return The student's CGPA.
     */
    public double getCGPA() {
        return this.CGPA;
    }

    /**
     * Public method to set the value of the private CGPA variable.
     * This is a "setter" method. It includes a basic validation check.
     *
     * @param newCGPA The new CGPA to be set.
     */
    public void setCGPA(double newCGPA) {
        if (newCGPA >= 0.0 && newCGPA <= 4.0) {
            this.CGPA = newCGPA;
            System.out.println("CGPA updated successfully.");
        } else {
            System.out.println("Invalid CGPA. Please enter a value between 0.0 and 4.0.");
        }
    }

    /**
     * A method to display the details of the student.
     */
    public void displayStudentDetails() {
        System.out.println("Student Details:");
        System.out.println("Roll Number: " + this.rollNumber);
        System.out.println("Name: " + this.name);
        System.out.println("CGPA: " + String.format("%.2f", this.CGPA));
    }
}

/**
 * A subclass that inherits from the Student class to demonstrate the
 * use of protected members.
 */
class PostgraduateStudent extends Student {

    private String researchTopic;

    public PostgraduateStudent(int rollNumber, String name, double CGPA, String researchTopic) {
        // Call the superclass constructor to initialize inherited members
        super(rollNumber, name, CGPA);
        this.researchTopic = researchTopic;
    }

    /**
     * A method to display details specific to a postgraduate student.
     * This method can directly access the protected 'name' variable
     * from the superclass.
     */
    public void displayPostgraduateDetails() {
        System.out.println("\nPostgraduate Student Details:");
        System.out.println("Roll Number: " + rollNumber);
        // Direct access to protected member
        System.out.println("Name (from protected): " + name);
        System.out.println("CGPA: " + getCGPA()); // Cannot directly access private CGPA
        System.out.println("Research Topic: " + this.researchTopic);
    }

    public static void main(String[] args) {
        System.out.println("--- Demonstrating Access Modifiers ---");

        // 1. Working with a basic Student object
        Student student1 = new Student(101, "Alice", 3.85);
        System.out.println("\nInitial Student 1 details:");
        student1.displayStudentDetails();

        // Direct access to public variable
        System.out.println("\nDirectly accessing public rollNumber: " + student1.rollNumber);

        // Accessing and modifying the private CGPA via public methods
        System.out.println("Initial CGPA: " + student1.getCGPA());
        student1.setCGPA(3.92);
        System.out.println("Updated CGPA: " + student1.getCGPA());

        // 2. Working with a PostgraduateStudent object (subclass)
        PostgraduateStudent pgStudent = new PostgraduateStudent(201, "Bob", 3.75, "Machine Learning");
        pgStudent.displayPostgraduateDetails();
    }
}
