/**
 * A class to represent a Person.
 * This file demonstrates the use of a copy constructor to
 * clone an object's attributes.
 */
public class Person {

    // Attributes of the Person class
    private String name;
    private int age;

    /**
     * Parameterized constructor to create a new Person object.
     * @param name The name of the person.
     * @param age The age of the person.
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * The copy constructor.
     * Initializes a new Person object by copying the attributes from another
     * existing Person object.
     * @param otherPerson The Person object to be copied.
     */
    public Person(Person otherPerson) {
        // We can access the private attributes of the otherPerson object within the same class.
        // This is a common and efficient way to implement a copy constructor.
        this(otherPerson.name, otherPerson.age);
    }

    /**
     * Provides a string representation of the Person object.
     * @return A formatted string with the person's name and age.
     */
    @Override
    public String toString() {
        return "Person{" +
               "name='" + name + '\'' +
               ", age=" + age +
               '}';
    }

    /**
     * Main method to demonstrate the functionality of the Person class.
     */
    public static void main(String[] args) {
        // Create an original person object
        Person originalPerson = new Person("Alice", 30);
        System.out.println("Original Person:");
        System.out.println(originalPerson);
        System.out.println("--------------------");

        // Create a new person object using the copy constructor
        Person clonedPerson = new Person(originalPerson);
        System.out.println("Cloned Person (created with copy constructor):");
        System.out.println(clonedPerson);
        System.out.println("--------------------");

        // Let's modify the cloned person's attributes to prove it's a separate object.
        clonedPerson.name = "Bob";
        clonedPerson.age = 25;
        System.out.println("Cloned Person after modification:");
        System.out.println(clonedPerson);
        System.out.println("Original Person (unchanged):");
        System.out.println(originalPerson);
    }
}
