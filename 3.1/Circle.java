public class Circle extends Shape {
  private double radius;

  public Circle(double radius) {
    super();
    this.radius = radius;
  }

  public Circle(double radius, String color) {
    super(color);
    this.radius = radius;
  }

  @Override
  public double calculateArea() {
    return Math.PI * radius * radius;
  }

  public double getRadius() {
    return radius;
  }

  @Override
  public String toString() {
    return "Circle with radius " + radius + " (Color: " + color + ")";
  }
}
