import java.util.ArrayList;
import java.util.List;

class Course {
    private String name;
    private List<Student> enrolledStudents;

    public Course(String name) {
        this.name = name;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getName() { return name; }

    public void addStudent(Student s) {
        if (!enrolledStudents.contains(s)) {
            enrolledStudents.add(s);
        }
    }

    public void showEnrolledStudents() {
        System.out.println("Course: " + name);
        for (Student s : enrolledStudents) {
            System.out.println("  • " + s.getName());
        }
        System.out.println();
    }
}

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() { return name; }

    public void enroll(Course c) {
        if (!courses.contains(c)) {
            courses.add(c);
            c.addStudent(this);
        }
    }

    public void showCourses() {
        System.out.println("Student: " + name + " is enrolled in:");
        for (Course c : courses) {
            System.out.println("  • " + c.getName());
        }
        System.out.println();
    }
}

class School {
    private String name;
    private List<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        if (!students.contains(s)) {
            students.add(s);
        }
    }

    public void showStudents() {
        System.out.println("School: " + name + " has the following students:");
        for (Student s : students) {
            System.out.println("  • " + s.getName());
        }
        System.out.println();
    }
}

public class AssociationAggregationDemo {
    public static void main(String[] args) {
        School school = new School("Green Valley High");

        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");
        Student s3 = new Student("Charlie");

        school.addStudent(s1);
        school.addStudent(s2);
        school.addStudent(s3);

        Course math = new Course("Mathematics");
        Course physics = new Course("Physics");
        Course chemistry = new Course("Chemistry");

        s1.enroll(math);
        s1.enroll(physics);

        s2.enroll(physics);
        s2.enroll(chemistry);

        s3.enroll(math);
        s3.enroll(chemistry);

        school.showStudents();

        s1.showCourses();
        s2.showCourses();
        s3.showCourses();

        math.showEnrolledStudents();
        physics.showEnrolledStudents();
        chemistry.showEnrolledStudents();
    }
}
