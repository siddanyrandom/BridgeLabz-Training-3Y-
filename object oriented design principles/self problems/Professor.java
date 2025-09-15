import java.util.ArrayList;
import java.util.List;

class Professor {
    private String name;
    private List<Course> courses;

    public Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() { return name; }

    public void assignCourse(Course c) {
        if (!courses.contains(c)) {
            courses.add(c);
            c.assignProfessor(this);
            System.out.println("Professor " + name + " is assigned to course " + c.getTitle());
        }
    }

    public void showCourses() {
        System.out.println("Professor " + name + " teaches:");
        for (Course c : courses) {
            System.out.println("  • " + c.getTitle());
        }
        System.out.println();
    }
}

class Student {
    private String name;
    private List<Course> enrolledCourses;

    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() { return name; }

    public void enrollCourse(Course c) {
        if (!enrolledCourses.contains(c)) {
            enrolledCourses.add(c);
            c.addStudent(this);
            System.out.println(name + " enrolled in course " + c.getTitle());
        }
    }

    public void showEnrolledCourses() {
        System.out.println("Student " + name + " is enrolled in:");
        for (Course c : enrolledCourses) {
            System.out.println("  • " + c.getTitle());
        }
        System.out.println();
    }
}

class Course {
    private String title;
    private Professor professor;
    private List<Student> students;

    public Course(String title) {
        this.title = title;
        this.students = new ArrayList<>();
    }

    public String getTitle() { return title; }

    public void assignProfessor(Professor p) {
        this.professor = p;
    }

    public void addStudent(Student s) {
        if (!students.contains(s)) {
            students.add(s);
        }
    }

    public void showDetails() {
        System.out.println("Course: " + title);
        System.out.println("Professor: " + (professor != null ? professor.getName() : "Not assigned"));
        System.out.println("Enrolled Students:");
        for (Student s : students) {
            System.out.println("  • " + s.getName());
        }
        System.out.println();
    }
}

class University {
    private String name;
    private List<Student> students;
    private List<Professor> professors;
    private List<Course> courses;

    public University(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student s) { students.add(s); }
    public void addProfessor(Professor p) { professors.add(p); }
    public void addCourse(Course c) { courses.add(c); }

    public void showUniversityInfo() {
        System.out.println("University: " + name);
        System.out.println("Students:");
        for (Student s : students) System.out.println("  • " + s.getName());
        System.out.println("Professors:");
        for (Professor p : professors) System.out.println("  • " + p.getName());
        System.out.println("Courses:");
        for (Course c : courses) System.out.println("  • " + c.getTitle());
        System.out.println();
    }
}

public class UniversityManagementDemo {
    public static void main(String[] args) {
        University uni = new University("National Institute of Technology");

        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");
        Student s3 = new Student("Charlie");

        Professor p1 = new Professor("Dr. Smith");
        Professor p2 = new Professor("Dr. Johnson");

        Course c1 = new Course("Computer Science");
        Course c2 = new Course("Mathematics");
        Course c3 = new Course("Physics");

        uni.addStudent(s1);
        uni.addStudent(s2);
        uni.addStudent(s3);
        uni.addProfessor(p1);
        uni.addProfessor(p2);
        uni.addCourse(c1);
        uni.addCourse(c2);
        uni.addCourse(c3);

        p1.assignCourse(c1);
        p2.assignCourse(c2);
        p2.assignCourse(c3);

        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
        s2.enrollCourse(c2);
        s3.enrollCourse(c1);
        s3.enrollCourse(c3);

        uni.showUniversityInfo();

        p1.showCourses();
        p2.showCourses();
        s1.showEnrolledCourses();
        s2.showEnrolledCourses();
        s3.showEnrolledCourses();

        c1.showDetails();
        c2.showDetails();
        c3.showDetails();
    }
}
