import java.util.Scanner;

public class FahrenheitToCelsius {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter temperature in Fahrenheit: ");
    double fahrenheit = scanner.nextDouble();

    double celsius = (fahrenheit - 32) * 5.0 / 9.0;
    System.out.printf("%.1f degrees Fahrenheit is %.1f degrees Celsius%n", fahrenheit, celsius);

    scanner.close();
  }
}
