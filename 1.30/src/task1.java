import java.util.Scanner;

public class task1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter coefficient a: ");
    double a = scanner.nextDouble();

    System.out.print("Enter coefficient b: ");
    double b = scanner.nextDouble();

    System.out.print("Enter coefficient c: ");
    double c = scanner.nextDouble();

    double discriminant = b * b - 4 * a * c;

    if (discriminant < 0) {
      System.out.println("No real roots");
    } else if (discriminant == 0) {
      double root = -b / (2 * a);
      System.out.println("Root: " + root);
    } else {
      double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
      double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
      System.out.println("Root 1: " + root1);
      System.out.println("Root 2: " + root2);
    }

    scanner.close();
  }
}
