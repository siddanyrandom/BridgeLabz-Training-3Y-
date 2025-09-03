public class Book {

    // Attributes of the Book class
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    /**
     * Parameterized constructor to create a new Book object.
     * @param title The title of the book.
     * @param author The author of the book.
     * @param price The price of the book.
     */
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        // A new book is always available by default.
        this.isAvailable = true;
    }

    /**
     * Gets the title of the book.
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the author of the book.
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gets the price of the book.
     * @return The price of the book.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Checks if the book is currently available.
     * @return true if the book is available, false otherwise.
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Attempts to borrow the book.
     * If the book is available, it changes its status to unavailable.
     * @return true if the book was successfully borrowed, false otherwise.
     */
    public boolean borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("The book \"" + this.title + "\" has been successfully borrowed.");
            return true;
        } else {
            System.out.println("Sorry, the book \"" + this.title + "\" is currently unavailable.");
            return false;
        }
    }

    /**
     * Returns the book, making it available again.
     */
    public void returnBook() {
        this.isAvailable = true;
        System.out.println("The book \"" + this.title + "\" has been successfully returned.");
    }

    /**
     * Provides a string representation of the Book object.
     * @return A formatted string with the book's details.
     */
    @Override
    public String toString() {
        String availabilityStatus = isAvailable ? "Available" : "Not Available";
        return "Book{" +
               "title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", price=$" + String.format("%.2f", price) +
               ", availability='" + availabilityStatus + '\'' +
               '}';
    }

    /**
     * Main method to demonstrate the functionality of the Book class.
     */
    public static void main(String[] args) {
        // Create a new book object
        Book book1 = new Book("The Lord of the Rings", "J.R.R. Tolkien", 25.50);
        System.out.println("Initial Book Status:");
        System.out.println(book1);
        System.out.println("--------------------");

        // Attempt to borrow the book
        book1.borrowBook();
        System.out.println("\nBook Status after borrowing:");
        System.out.println(book1);
        System.out.println("--------------------");

        // Attempt to borrow the same book again (should fail)
        System.out.println("\nAttempting to borrow the same book again:");
        book1.borrowBook();
        System.out.println("--------------------");
        
        // Return the book
        System.out.println("\nReturning the book:");
        book1.returnBook();
        System.out.println("\nBook Status after returning:");
        System.out.println(book1);
    }
}
