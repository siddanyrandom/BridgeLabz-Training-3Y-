public class Book {

    // Public variable: Accessible from anywhere.
    public String ISBN;

    // Protected variable: Accessible within the same class, subclasses, and the same package.
    protected String title;

    // Private variable: Only accessible within this class.
    private String author;

    /**
     * Parameterized constructor for the Book class.
     *
     * @param ISBN   The book's International Standard Book Number.
     * @param title  The title of the book.
     * @param author The name of the book's author.
     */
    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    /**
     * Public method to get the value of the private 'author' variable.
     * This is a "getter" method.
     *
     * @return The name of the book's author.
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Public method to set the value of the private 'author' variable.
     * This is a "setter" method.
     *
     * @param newAuthor The new author name to be set.
     */
    public void setAuthor(String newAuthor) {
        this.author = newAuthor;
        System.out.println("Author for book '" + this.title + "' updated to: " + newAuthor);
    }
}

/**
 * A subclass that inherits from the Book class, representing an e-book.
 * This class demonstrates the access to public and protected members from a subclass.
 */
class EBook extends Book {

    private int fileSizeMB;

    public EBook(String ISBN, String title, String author, int fileSizeMB) {
        // Call the superclass constructor to initialize inherited members
        super(ISBN, title, author);
        this.fileSizeMB = fileSizeMB;
    }

    /**
     * A method to display details specific to an e-book.
     * This method can directly access the public 'ISBN' and protected 'title'
     * variables from the superclass.
     */
    public void displayEBookDetails() {
        System.out.println("\nE-Book Details:");
        // Direct access to public member
        System.out.println("ISBN: " + this.ISBN);
        // Direct access to protected member
        System.out.println("Title (from protected): " + this.title);
        // Cannot directly access private 'author', must use the public getter method
        System.out.println("Author: " + this.getAuthor());
        System.out.println("File Size: " + this.fileSizeMB + " MB");
    }

    /**
     * Main method to demonstrate the functionality of the Book and EBook classes.
     */
    public static void main(String[] args) {
        System.out.println("--- Demonstrating Access Modifiers ---");

        // 1. Working with a basic Book object
        Book book1 = new Book("978-0321765723", "The Lord of the Rings", "J.R.R. Tolkien");
        System.out.println("\nInitial Book Details:");
        System.out.println("ISBN: " + book1.ISBN); // Direct access to public variable
        System.out.println("Title: " + book1.title); // Direct access to protected variable
        System.out.println("Author: " + book1.getAuthor()); // Accessing private variable via a public method

        // Modifying the private author variable via the public setter method
        book1.setAuthor("Tolkien, J.R.R.");
        System.out.println("Updated Author: " + book1.getAuthor());

        // 2. Working with an EBook object (subclass)
        EBook ebook1 = new EBook("978-0743273565", "The Great Gatsby", "F. Scott Fitzgerald", 3);
        ebook1.displayEBookDetails();
        
        // Let's try to access the private author directly from a different class
        // The following line would cause a compilation error:
        // System.out.println("Author: " + ebook1.author);
        
        // Instead, we use the public getter method
        System.out.println("\nAccessing author via public method from outside the class: " + ebook1.getAuthor());
    }
}
