// Task 3: Shape hierarchy
public class Shape {
  protected String color;

  public Shape() {
    this.color = "Unknown";
  }

  public Shape(String color) {
    this.color = color;
  }

  public double calculateArea() {
    return 0.0;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}
