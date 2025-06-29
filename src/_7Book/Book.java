package _7Book;
import java.util.*;

public class Book {
    String title, author, publisher;
    double price;

    Book(String title, String author, String publisher, double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                '}';
    }

    static void sortBooksByPrice(Map<Integer, Book> bookMap) {
        List<Book> books = new ArrayList<>(bookMap.values());
        books.sort(Comparator.comparingDouble(b -> b.price));
        System.out.println("Books sorted by price:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, Book> bookMap = new HashMap<>();
        bookMap.put(1, new Book("Programming Java", "Joshua Bloch", "Pub", 1500));
        bookMap.put(2, new Book("Programming C", "Robert C. Martin", "Pub", 1700));
        bookMap.put(3, new Book("Programming Python", "Allen B. Downey", "Pub", 950));
        sortBooksByPrice(bookMap);

        System.out.print("\nEnter the author name to search: ");
        String searchAuthor = sc.nextLine();

        System.out.println("Books by " + searchAuthor + ":");
        for (Book book : bookMap.values()) {
            if (book.author.equalsIgnoreCase(searchAuthor)) {
                System.out.println(book);
            }
        }

        System.out.print("\nEnter the price threshold: ");
        double priceThreshold = sc.nextDouble();

        System.out.println("Books with price >= " + priceThreshold + ":");
        for (Book book : bookMap.values()) {
            if (book.price >= priceThreshold) {
                System.out.println(book);
            }
        }

        sc.close();
    }
}
