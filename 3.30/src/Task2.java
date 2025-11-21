import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        LibraryTask2 library = new LibraryTask2();

        BookTask2 book1 = new BookTask2("1984", "George Orwell", "12345");
        BookTask2 book2 = new BookTask2("Suomi-2", "Harper Lee", "67890");

        LibraryMemberTask2 member1 = new LibraryMemberTask2("Alice", 1);
        LibraryMemberTask2 member2 = new LibraryMemberTask2("Bob", 2);

        library.addBook(book1);
        library.addBook(book2);
        library.addMember(member1);
        library.addMember(member2);

        library.borrowBook(member1, book1);
        library.borrowBook(member2, book2);
        library.returnBook(member1, book1);
        library.borrowBook(member2, book1);
    }
}

class BookTask2 {
    private String title;
    private String author;
    private String isbn;

    public BookTask2(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        BookTask2 book = (BookTask2) obj;
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

class LibraryMemberTask2 {
    private String name;
    private int memberId;
    private List<BookTask2> borrowedBooks;

    public LibraryMemberTask2(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public List<BookTask2> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(BookTask2 book) {
        borrowedBooks.add(book);
    }

    public void returnBook(BookTask2 book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Member: " + name + " (ID: " + memberId + ")";
    }
}

class LibraryTask2 {
    private List<BookTask2> books;
    private List<LibraryMemberTask2> members;

    public LibraryTask2() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(BookTask2 book) {
        books.add(book);
        System.out.println(book.getTitle() + " added to the library.");
    }

    public void addMember(LibraryMemberTask2 member) {
        members.add(member);
        System.out.println(member.getName() + " joined the library.");
    }

    public void borrowBook(LibraryMemberTask2 member, BookTask2 book) {
        if (books.contains(book) && !member.getBorrowedBooks().contains(book)) {
            member.borrowBook(book);
            System.out.println(member.getName() + " borrowed " + book.getTitle());
        } else {
            System.out.println("Book not available: " + book.getTitle());
        }
    }

    public void returnBook(LibraryMemberTask2 member, BookTask2 book) {
        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            System.out.println(member.getName() + " returned " + book.getTitle());
        } else {
            System.out.println(member.getName() + " does not have this book.");
        }
    }
}
