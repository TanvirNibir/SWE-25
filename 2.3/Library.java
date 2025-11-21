import java.util.ArrayList;

// Task 1
public class Library {
  // Task 1
  private ArrayList<Book> books = new ArrayList<>();

  // Task 6
  private ArrayList<User> users = new ArrayList<>();

  // Task 1
  public void addBook(Book book) {
    if (book != null) {
      books.add(book);
    }
  }

  // Task 1
  public void displayBooks() {
    System.out.println("Library Catalog:");
    if (books.isEmpty()) {
      System.out.println("No books in the library.");
      return;
    }
    for (int i = 0; i < books.size(); i++) {
      Book book = books.get(i);
      System.out.println((i + 1) + ". " + book.toString());
    }
  }

  // Task 1
  public void findBooksByAuthor(String author) {
    if (author == null || author.trim().isEmpty()) {
      System.out.println("Error: Author name cannot be empty.");
      return;
    }
    author = author.trim();
    System.out.println("Books by Author \"" + author + "\":");
    boolean found = false;
    for (Book book : books) {
      if (author.equalsIgnoreCase(book.getAuthor())) {
        System.out.println("Title: \"" + book.getTitle() + "\", Year: " + book.getPublicationYear());
        found = true;
      }
    }
    if (!found) {
      System.out.println("No books found by this author.");
    }
  }

  // Task 2
  public void borrowBook(String title) {
    if (title == null || title.trim().isEmpty()) {
      System.out.println("Error: Book title cannot be empty.");
      return;
    }
    title = title.trim();
    Book bookToBorrow = null;
    for (Book book : books) {
      if (title.equalsIgnoreCase(book.getTitle())) {
        bookToBorrow = book;
        break;
      }
    }
    if (bookToBorrow != null) {
      books.remove(bookToBorrow);
      System.out.println("Book \"" + title + "\" has been borrowed.");
    } else {
      System.out.println("Book \"" + title + "\" is not available in the library.");
    }
  }

  // Task 2
  public void returnBook(Book book) {
    if (book == null) {
      System.out.println("Error: Cannot return a null book.");
      return;
    }
    for (Book existingBook : books) {
      if (existingBook.getTitle().equalsIgnoreCase(book.getTitle())) {
        System.out.println("Book \"" + book.getTitle() + "\" is already in the library.");
        return;
      }
    }
    books.add(book);
    System.out.println("Book \"" + book.getTitle() + "\" has been returned to the library.");
  }

  // Task 3
  public boolean isBookAvailable(String title) {
    if (title == null || title.trim().isEmpty()) {
      return false;
    }
    title = title.trim();
    for (Book book : books) {
      if (title.equalsIgnoreCase(book.getTitle())) {
        return true;
      }
    }
    return false;
  }

  // Task 5
  public double getAverageBookRating() {
    if (books.isEmpty()) {
      return 0.0;
    }
    double totalRating = 0.0;
    int booksWithRatings = 0;
    for (Book book : books) {
      if (book.getRating() > 0) {
        totalRating += book.getRating();
        booksWithRatings++;
      }
    }
    if (booksWithRatings == 0) {
      return 0.0;
    }
    return totalRating / booksWithRatings;
  }

  // Task 5
  public Book getMostReviewedBook() {
    if (books.isEmpty()) {
      return null;
    }
    Book mostReviewed = null;
    int maxReviews = -1;
    for (Book book : books) {
      int reviewCount = book.getReviewCount();
      if (reviewCount > maxReviews) {
        maxReviews = reviewCount;
        mostReviewed = book;
      }
    }
    return mostReviewed;
  }

  // Task 6
  public void addUser(User user) {
    if (user != null) {
      users.add(user);
    }
  }

  public User getUserByName(String name) {
    if (name == null || name.trim().isEmpty()) {
      return null;
    }
    name = name.trim();
    for (User user : users) {
      if (name.equalsIgnoreCase(user.getName())) {
        return user;
      }
    }
    return null;
  }

  public ArrayList<User> getUsers() {
    return new ArrayList<>(users);
  }

  public ArrayList<Book> getBooks() {
    return new ArrayList<>(books);
  }
}
