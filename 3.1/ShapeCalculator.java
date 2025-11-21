// Task 3: Shape hierarchy | Task 4: Shape properties
public class ShapeCalculator {
  public static void main(String[] args) {
    System.out.println("Shape Calculator\n");

    Shape[] shapes = new Shape[] {
        new Circle(5.0, "Red"),
        new Rectangle(4.0, 6.0, "Blue"),
        new Triangle(3.0, 8.0, "Green")
    };

    for (Shape shape : shapes) {
      if (shape instanceof Circle) {
        Circle circle = (Circle) shape;
        System.out.println("Area of Circle with radius " + circle.getRadius() +
            " (Color: " + circle.getColor() + "): " + circle.calculateArea());
      } else if (shape instanceof Rectangle) {
        Rectangle rectangle = (Rectangle) shape;
        System.out.println("Area of Rectangle with width " + rectangle.getWidth() +
            " and height " + rectangle.getHeight() + " (Color: " + rectangle.getColor() + "): " +
            rectangle.calculateArea());
      } else if (shape instanceof Triangle) {
        Triangle triangle = (Triangle) shape;
        System.out.println("Area of Triangle with base " + triangle.getBase() +
            " and height " + triangle.getHeight() + " (Color: " + triangle.getColor() + "): " +
            triangle.calculateArea());
      }
    }
  }
}
