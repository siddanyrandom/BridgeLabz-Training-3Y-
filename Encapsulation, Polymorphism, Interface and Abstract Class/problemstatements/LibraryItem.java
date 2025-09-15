import java.util.ArrayList;
import java.util.List;

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() { return itemId; }
    public void setItemId(String itemId) { this.itemId = itemId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    private boolean isAvailable = true;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() { return 21; }

    public void reserveItem(String borrowerName) {
        if (isAvailable) {
            System.out.println("Book reserved for " + borrowerName);
            isAvailable = false;
        } else {
            System.out.println("Book not available for reservation");
        }
    }

    public boolean checkAvailability() { return isAvailable; }
}

class Magazine extends LibraryItem implements Reservable {
    private boolean isAvailable = true;

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() { return 14; }

    public void reserveItem(String borrowerName) {
        if (isAvailable) {
            System.out.println("Magazine reserved for " + borrowerName);
            isAvailable = false;
        } else {
            System.out.println("Magazine not available for reservation");
        }
    }

    public boolean checkAvailability() { return isAvailable; }
}

class DVD extends LibraryItem implements Reservable {
    private boolean isAvailable = true;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() { return 7; }

    public void reserveItem(String borrowerName) {
        if (isAvailable) {
            System.out.println("DVD reserved for " + borrowerName);
            isAvailable = false;
        } else {
            System.out.println("DVD not available for reservation");
        }
    }

    public boolean checkAvailability() { return isAvailable; }
}

public class LibraryManagementDemo {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        Book book = new Book("B101", "Java Programming", "Author A");
        Magazine mag = new Magazine("M202", "Science Monthly", "Author B");
        DVD dvd = new DVD("D303", "Inception", "Director C");

        items.add(book);
        items.add(mag);
        items.add(dvd);

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            if (item instanceof Reservable r) {
                System.out.println("Available: " + r.checkAvailability());
                r.reserveItem("Alice");
                System.out.println("Available after reservation: " + r.checkAvailability());
            }
            System.out.println("------------------------");
        }
    }
}
