public class LibraryMain {
  public static void main(String[] args) {
    System.out.println("=== Task 1: Basic Library and Book Operations ===\n");

    Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
    Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
    Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

    Library library = new Library();

    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);

    library.displayBooks();
    System.out.println();

    library.findBooksByAuthor("Jane Doe");

    System.out.println("\n=== Task 2: Book Borrowing System ===\n");

    library.borrowBook("Data Structures and Algorithms");
    System.out.println();

    library.displayBooks();
    System.out.println();

    library.returnBook(book2);
    System.out.println();

    library.displayBooks();

    System.out.println("\n=== Task 3: Book Availability Check ===\n");

    String titleToCheck = "Introduction to Java Programming";
    boolean available = library.isBookAvailable(titleToCheck);
    System.out.println("Is \"" + titleToCheck + "\" available? " + available);

    titleToCheck = "Nonexistent Book";
    available = library.isBookAvailable(titleToCheck);
    System.out.println("Is \"" + titleToCheck + "\" available? " + available);

    System.out.println("\n=== Task 4: Book Ratings and Reviews ===\n");

    book1.setRating(4.5);
    book2.setRating(4.8);
    book3.setRating(4.2);

    book1.addReview("Great introduction to Java programming!");
    book1.addReview("Very helpful for beginners.");
    book2.addReview("Excellent coverage of algorithms.");
    book2.addReview("Well-structured content.");
    book2.addReview("Perfect for interview preparation.");
    book3.addReview("Beautiful storytelling.");

    System.out.println("Book 1 - Rating: " + book1.getRating() + ", Reviews: " + book1.getReviewCount());
    System.out.println("Book 2 - Rating: " + book2.getRating() + ", Reviews: " + book2.getReviewCount());
    System.out.println("Book 3 - Rating: " + book3.getRating() + ", Reviews: " + book3.getReviewCount());

    System.out.println("\n=== Task 5: Library Statistics ===\n");

    double avgRating = library.getAverageBookRating();
    System.out.printf("Average Book Rating: %.2f\n", avgRating);

    Book mostReviewed = library.getMostReviewedBook();
    if (mostReviewed != null) {
      System.out.println("Most Reviewed Book: " + mostReviewed.getTitle() +
          " (" + mostReviewed.getReviewCount() + " reviews)");
    }

    System.out.println("\n=== Task 6: Library Users ===\n");

    User user1 = new User("Alice", 25);
    User user2 = new User("Bob", 30);

    library.addUser(user1);
    library.addUser(user2);

    System.out.println("Alice borrowing books...");
    Book borrowedBook1 = new Book("Introduction to Java Programming", "John Smith", 2020);
    Book borrowedBook2 = new Book("The Art of Fiction", "Alice Johnson", 2019);

    library.borrowBook("Introduction to Java Programming");
    user1.borrowBook(borrowedBook1);

    library.borrowBook("The Art of Fiction");
    user1.borrowBook(borrowedBook2);

    System.out.println();

    user1.displayBorrowedBooks();
    System.out.println();

    System.out.println("Bob borrowing a book...");
    Book borrowedBook3 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
    library.borrowBook("Data Structures and Algorithms");
    user2.borrowBook(borrowedBook3);
    System.out.println();

    user2.displayBorrowedBooks();

    System.out.println("\n=== Final Library Status ===\n");
    library.displayBooks();
  }
}
