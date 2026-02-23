import java.time.LocalDate;

public class Book {

    private String name;
    private String authorName;
    private double price;
    private String publisherName;
    private String genre;
    private String ISBN;
    private LocalDate dateOfPublishing;

    // Default Constructor
    public Book() {
        name = "Unknown";
        authorName = "Unknown";
        price = 0.0;
        publisherName = "unspecified";
        genre = "uncategorised";
        ISBN = "000000";
        dateOfPublishing = LocalDate.parse("2020-01-01");
    }

    // Constructor with Genre + Price validation
    public Book(String n, String a, double p, String g)
            throws InvalidPriceException, InvalidGenreException {

        name = n;
        authorName = a;

        if (g == null ||
                (!g.equalsIgnoreCase("Fiction") &&
                 !g.equalsIgnoreCase("Non-Fiction") &&
                 !g.equalsIgnoreCase("Mystery") &&
                 !g.equalsIgnoreCase("Fantasy"))) {
            throw new InvalidGenreException("Invalid genre");
        }

        genre = g;

        if (p < 0) {
            throw new InvalidPriceException("Price cannot be negative.");
        }

        price = p;
        publisherName = "unspecified";
        ISBN = "000000";
        dateOfPublishing = LocalDate.now();
    }

    // Constructor with ISBN + Price validation
    public Book(String n, String a, double p, String isbn)
            throws InvalidPriceException {

        name = n;
        authorName = a;

        if (p < 0) {
            throw new InvalidPriceException("Price cannot be negative.");
        }

        price = p;
        ISBN = isbn;
        genre = "uncategorised";
        publisherName = "unspecified";
        dateOfPublishing = LocalDate.now();
    }

    // Copy Constructor
    public Book(Book b) {
        name = b.name;
        authorName = b.authorName;
        price = b.price;
        publisherName = b.publisherName;
        genre = b.genre;
        ISBN = b.ISBN;
        dateOfPublishing = b.dateOfPublishing;
    }

    // Getter Methods
    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public double getPrice() {
        return price;
    }

    public String getGenre() {
        return genre;
    }
}
import java.util.ArrayList;

public class ArrayListOfBooks {

    public static void main(String[] args) {

        // Create ArrayList of Book objects
        ArrayList<Book> bookList = new ArrayList<>();

        // Book 1
        try {
            Book b1 = new Book("The Alchemist", "Paulo Coelho", 399, "Fiction");
            bookList.add(b1);
        } catch (InvalidPriceException | InvalidGenreException e) {
            System.out.println(e.getMessage());
        }

        // Book 2
        try {
            Book b2 = new Book("Sherlock Holmes", "Arthur Conan Doyle", 450, "Mystery");
            bookList.add(b2);
        } catch (InvalidPriceException | InvalidGenreException e) {
            System.out.println(e.getMessage());
        }

        // Book 3 (Negative price example)
        try {
            Book b3 = new Book("Clean Code", "Robert Martin", -800, "Non-Fiction");
            bookList.add(b3);
        } catch (InvalidPriceException | InvalidGenreException e) {
            System.out.println(e.getMessage());
        }

        // Book 4
        try {
            Book b4 = new Book("Harry Potter", "J.K. Rowling", 550, "Fantasy");
            bookList.add(b4);
        } catch (InvalidPriceException | InvalidGenreException e) {
            System.out.println(e.getMessage());
        }

        // Display all books
        System.out.println("\nAll Books:");
        for (Book b : bookList) {
            System.out.println("Name: " + b.getName()
                    + ", Author: " + b.getAuthorName()
                    + ", Genre: " + b.getGenre()
                    + ", Price: " + b.getPrice());
        }

        // Calculate average price
        double total = 0;
        for (Book b : bookList) {
            total += b.getPrice();
        }

        if (!bookList.isEmpty()) {
            double average = total / bookList.size();
            System.out.println("\nAverage Price: " + average);
        }

        // Print only Fiction books
        System.out.println("\nFiction Books:");
        bookList.forEach(book -> {
            if (book.getGenre().equalsIgnoreCase("Fiction")) {
                System.out.println("Name: " + book.getName()
                        + ", Author: " + book.getAuthorName()
                        + ", Price: " + book.getPrice());
            }
        });
    }
}
// User-defined exception for invalid genre
public class InvalidGenreException extends Exception {

    public InvalidGenreException(String message) {
        super(message);
    }
}
// User-defined exception for invalid price
public class InvalidPriceException extends Exception {

    public InvalidPriceException(String message) {
        super(message);
    }
}