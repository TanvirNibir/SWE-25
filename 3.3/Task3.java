import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        LibraryTask3 library = new LibraryTask3();

        BookTask3 book1 = new BookTask3("1984", "George Orwell", "12345");
        BookTask3 book2 = new BookTask3("Suomi-2", "Harper Lee", "67890");

        LibraryMemberTask3 member1 = new LibraryMemberTask3("Alice", 1);
        LibraryMemberTask3 member2 = new LibraryMemberTask3("Bob", 2);

        library.addBook(book1);
        library.addBook(book2);
        library.addMember(member1);
        library.addMember(member2);

        library.borrowBook(member1, book1);
        library.reserveBook(member2, book2);
        library.displayReservedBooks(member2);
        library.cancelReservation(member2, book2);
        library.displayReservedBooks(member2);
        library.returnBook(member1, book1);
        library.borrowBook(member2, book1);
    }
}

class BookTask3 {
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed;
    private boolean isReserved;

    public BookTask3(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;
        this.isReserved = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        BookTask3 book = (BookTask3) obj;
        return isbn != null ? isbn.equals(book.isbn) : book.isbn == null;
    }

    @Override
    public int hashCode() {
        return isbn != null ? isbn.hashCode() : 0;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + isbn + ")";
    }
}

class LibraryMemberTask3 {
    private String name;
    private int memberId;
    private List<BookTask3> borrowedBooks;
    private List<BookTask3> reservedBooks;

    public LibraryMemberTask3(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
        this.reservedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<BookTask3> getBorrowedBooks() {
        return borrowedBooks;
    }

    public List<BookTask3> getReservedBooks() {
        return reservedBooks;
    }

    public void borrowBook(BookTask3 book) {
        borrowedBooks.add(book);
    }

    public void returnBook(BookTask3 book) {
        borrowedBooks.remove(book);
    }

    public void addReservedBook(BookTask3 book) {
        reservedBooks.add(book);
    }

    public void removeReservedBook(BookTask3 book) {
        reservedBooks.remove(book);
    }

    public boolean hasReservedBook(BookTask3 book) {
        return reservedBooks.contains(book);
    }
}

class LibraryTask3 {
    private List<BookTask3> books;
    private List<LibraryMemberTask3> members;

    public LibraryTask3() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(BookTask3 book) {
        books.add(book);
        System.out.println(book.getTitle() + " added to the library.");
    }

    public void addMember(LibraryMemberTask3 member) {
        members.add(member);
        System.out.println(member.getName() + " joined the library.");
    }

    public void borrowBook(LibraryMemberTask3 member, BookTask3 book) {
        if (books.contains(book) && !book.isBorrowed() && !book.isReserved()) {
            book.setBorrowed(true);
            member.borrowBook(book);
            System.out.println(member.getName() + " borrowed " + book.getTitle());
        } else {
            System.out.println("Book not available: " + book.getTitle());
        }
    }

    public void returnBook(LibraryMemberTask3 member, BookTask3 book) {
        if (member.getBorrowedBooks().contains(book)) {
            book.setBorrowed(false);
            member.returnBook(book);
            System.out.println(member.getName() + " returned " + book.getTitle());
        } else {
            System.out.println(member.getName() + " does not have this book.");
        }
    }

    public void reserveBook(LibraryMemberTask3 member, BookTask3 book) {
        if (books.contains(book) && !book.isReserved() && !book.isBorrowed()) {
            book.setReserved(true);
            member.addReservedBook(book);
            System.out.println(member.getName() + " reserved " + book.getTitle());
        } else {
            System.out.println("Book is already borrowed or reserved: " + book.getTitle());
        }
    }

    public void cancelReservation(LibraryMemberTask3 member, BookTask3 book) {
        if (book.isReserved() && member.hasReservedBook(book)) {
            book.setReserved(false);
            member.removeReservedBook(book);
            System.out.println(member.getName() + " canceled reservation for " + book.getTitle());
        } else {
            System.out.println("Reservation cannot be canceled for " + book.getTitle());
        }
    }

    public void displayReservedBooks(LibraryMemberTask3 member) {
        System.out.println("Reserved books for " + member.getName() + ":");
        if (member.getReservedBooks().isEmpty()) {
            System.out.println("No reserved books.");
        } else {
            for (BookTask3 book : member.getReservedBooks()) {
                System.out.println(book.getTitle());
            }
        }
    }
}
