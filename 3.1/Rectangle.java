public class Rectangle extends Shape {
  private double width;
  private double height;

  public Rectangle(double width, double height) {
    super();
    this.width = width;
    this.height = height;
  }

  public Rectangle(double width, double height, String color) {
    super(color);
    this.width = width;
    this.height = height;
  }

  @Override
  public double calculateArea() {
    return width * height;
  }

  public double getWidth() {
    return width;
  }

  public double getHeight() {
    return height;
  }

  @Override
  public String toString() {
    return "Rectangle with width " + width + " and height " + height + " (Color: " + color + ")";
  }
}
