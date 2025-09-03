public class Course {

    // Instance variables: unique to each Course object
    private String courseName;
    private int duration; // in hours
    private double fee;

    // Class variable: shared among all Course objects
    private static String instituteName = "Tech Learning Institute";

    /**
     * Parameterized constructor for the Course class.
     * Initializes a new course with the provided details.
     * @param courseName The name of the course.
     * @param duration The duration of the course in hours.
     * @param fee The fee for the course.
     */
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    /**
     * An instance method to display the details of a single course.
     */
    public void displayCourseDetails() {
        System.out.println("------------------------------------");
        System.out.println("Institute Name: " + Course.instituteName);
        System.out.println("Course Name: " + this.courseName);
        System.out.println("Duration: " + this.duration + " hours");
        System.out.println("Fee: $" + String.format("%.2f", this.fee));
        System.out.println("------------------------------------");
    }

    /**
     * A static method to update the institute name for all courses.
     * This method can be called without creating an instance of the class.
     * @param newName The new name for the institute.
     */
    public static void updateInstituteName(String newName) {
        Course.instituteName = newName;
        System.out.println("\nSuccessfully updated institute name to: " + newName);
    }

    /**
     * Main method to demonstrate the functionality of the Course class.
     */
    public static void main(String[] args) {
        // Create the first course
        Course course1 = new Course("Java Programming", 60, 499.99);
        System.out.println("--- Initial Course Details ---");
        course1.displayCourseDetails();

        // Create the second course
        Course course2 = new Course("Web Development", 80, 599.99);
        course2.displayCourseDetails();

        // Update the institute name using the static method
        Course.updateInstituteName("Global Coders Academy");

        // Display the course details again to show the updated institute name
        System.out.println("\n--- Course Details After Update ---");
        course1.displayCourseDetails();
        course2.displayCourseDetails();
    }
}
