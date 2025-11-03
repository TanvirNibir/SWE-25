import java.util.ArrayList;

public class Book {
  private String title;
  private String author;
  private int publicationYear;
  private double rating;
  private ArrayList<String> reviews;

  public Book(String title, String author, int publicationYear) {
    this.title = title;
    this.author = author;
    this.publicationYear = publicationYear;
    this.rating = 0.0;
    this.reviews = new ArrayList<>();
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getPublicationYear() {
    return publicationYear;
  }

  public double getRating() {
    return rating;
  }

  public ArrayList<String> getReviews() {
    return new ArrayList<>(reviews);
  }

  public int getReviewCount() {
    return reviews.size();
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

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
