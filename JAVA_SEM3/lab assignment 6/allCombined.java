// 1. Custom Exception
class InvalidBookException extends Exception {
    public InvalidBookException(String message) {
        super(message);
    }

    public InvalidBookException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String toString() {
        Throwable cause = getCause();
        return "InvalidBookException: " + getMessage() + 
               (cause != null ? " caused by " + cause : "");
    }
}

// 2. Book class
class Book {
    private String title;
    private int pages;

    public Book(String title, int pages) throws InvalidBookException {
        if (pages <= 0) {
            throw new InvalidBookException("Page count must be greater than zero");
        }
        this.title = title;
        this.pages = pages;
    }

    public String getTitle() { return title; }
    public int getPages() { return pages; }
}

// 3. Library class
class Library {
    public void addBook(Book b) throws InvalidBookException {
        if (b == null) {
            IllegalArgumentException cause = new IllegalArgumentException("Null book provided");
            throw new InvalidBookException("Invalid book entry", cause);
        }
        System.out.println("Book \"" + b.getTitle() + "\" with " + b.getPages() + " pages added.");
    }
}

// 4. Main class
public class LibraryTest {
    public static void main(String[] args) {
        Library lib = new Library();

        try {
            Book b1 = new Book("Java Guide", 300);
            lib.addBook(b1);

            Book b2 = new Book("Empty Book", 0); // InvalidBookException
            lib.addBook(b2);

            Book b3 = null; // Null reference
            lib.addBook(b3);

        } catch (InvalidBookException e) {
            System.out.println("getMessage(): " + e.getMessage());
            System.out.println("toString(): " + e);
        } finally {
            System.out.println("Library process complete");
        }
    }
}
