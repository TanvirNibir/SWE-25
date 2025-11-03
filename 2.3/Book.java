import java.util.ArrayList;

// Task 1
public class Book {
  // Task 1
  private String title;
  private String author;
  private int publicationYear;

  // Task 4
  private double rating;
  private ArrayList<String> reviews;

  // Task 1
  public Book(String title, String author, int publicationYear) {
    this.title = title;
    this.author = author;
    this.publicationYear = publicationYear;
    // Task 4
    this.rating = 0.0;
    this.reviews = new ArrayList<>();
  }

  // Task 1
  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getPublicationYear() {
    return publicationYear;
  }

  // Task 4
  public double getRating() {
    return rating;
  }

  public ArrayList<String> getReviews() {
    return new ArrayList<>(reviews);
  }

  public int getReviewCount() {
    return reviews.size();
  }

  // Task 4
  public void setRating(double rating) {
    this.rating = rating;
  }

  // Task 4
  public void addReview(String review) {
    if (review != null && !review.trim().isEmpty()) {
      reviews.add(review.trim());
    }
  }

  @Override
  public String toString() {
    return "Title: \"" + title + "\", Author: \"" + author + "\", Year: " + publicationYear;
  }
}
