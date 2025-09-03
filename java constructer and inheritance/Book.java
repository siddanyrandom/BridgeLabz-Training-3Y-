/**
 * A class to represent a Book.
 * This file contains the Book class definition and a main method
 * to demonstrate its usage.
 */
public class Book {

    // Attributes of the Book class
    private String title;
    private String author;
    private double price;

    /**
     * The default constructor for the Book class.
     * Initializes a new Book object with default values.
     */
    public Book() {
        this.title = "Untitled";
        this.author = "Unknown";
        this.price = 0.0;
    }

    /**
     * The parameterized constructor for the Book class.
     * Initializes a new Book object with the provided values.
     * @param title The title of the book.
     * @param author The author of the book.
     * @param price The price of the book.
     */
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    /**
     * Provides a string representation of the Book object.
     * This is useful for printing the object's details.
     * @return A formatted string with the book's information.
     */
    @Override
    public String toString() {
        return "Book{" +
               "title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", price=" + String.format("%.2f", price) +
               '}';
    }

    /**
     * Main method to demonstrate the functionality of the Book class.
     */
    public static void main(String[] args) {
        // Create a book using the default constructor
        Book defaultBook = new Book();
        System.out.println("Default Book:");
        System.out.println(defaultBook);
        System.out.println("--------------------");

        // Create a book using the parameterized constructor
        Book myBook = new Book("The Lord of the Rings", "J.R.R. Tolkien", 25.50);
        System.out.println("Parameterized Book:");
        System.out.println(myBook);
    }
}
