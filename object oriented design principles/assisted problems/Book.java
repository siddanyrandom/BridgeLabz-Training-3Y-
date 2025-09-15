import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title  = title;
        this.author = author;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author;
    }
}

class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void showBooks() {
        System.out.println("Books in " + name + ":");
        for (Book b : books) {
            System.out.println("  • " + b);
        }
        System.out.println();
    }
}

public class AggregationDemo {
    public static void main(String[] args) {
        Book b1 = new Book("The Alchemist", "Paulo Coelho");
        Book b2 = new Book("Clean Code", "Robert C. Martin");
        Book b3 = new Book("Effective Java", "Joshua Bloch");

        Library cityLibrary = new Library("City Library");
        Library universityLibrary = new Library("University Library");

        cityLibrary.addBook(b1);
        cityLibrary.addBook(b2);

        universityLibrary.addBook(b2);
        universityLibrary.addBook(b3);

        cityLibrary.showBooks();
        universityLibrary.showBooks();
    }
}
