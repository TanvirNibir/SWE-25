import java.util.ArrayList;

// Task 6
public class User {
  // Task 6
  private String name;
  private int age;
  private ArrayList<Book> borrowedBooks;

  // Task 6
  public User(String name, int age) {
    this.name = name;
    this.age = age;
    this.borrowedBooks = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public ArrayList<Book> getBorrowedBooks() {
    return new ArrayList<>(borrowedBooks);
  }

  public void borrowBook(Book book) {
    if (book != null) {
      borrowedBooks.add(book);
    }
  }

  public void returnBook(Book book) {
    if (book != null) {
      borrowedBooks.remove(book);
    }
  }

  public boolean hasBorrowed(Book book) {
    if (book == null) {
      return false;
    }
    for (Book borrowed : borrowedBooks) {
      if (borrowed.getTitle().equalsIgnoreCase(book.getTitle())) {
        return true;
      }
    }
    return false;
  }

  public void displayBorrowedBooks() {
    if (borrowedBooks.isEmpty()) {
      System.out.println(name + " has no borrowed books.");
      return;
    }
    System.out.println(name + "'s Borrowed Books:");
    for (int i = 0; i < borrowedBooks.size(); i++) {
      System.out.println((i + 1) + ". " + borrowedBooks.get(i).toString());
    }
  }
}
