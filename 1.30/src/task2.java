import java.util.Scanner;

public class task2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a binary number: ");
    String binary = scanner.next();

    int decimal = 0;

    int power = 0;

    for (int i = binary.length() - 1; i >= 0; i--) {
      char bit = binary.charAt(i);

      if (bit == '1') {
        decimal = decimal + (int) Math.pow(2, power);
      }

      if (bit != '0' && bit != '1') {
        System.out.println("Invalid binary number! Only 0s and 1s allowed.");
        scanner.close();
        return;
      }

      power++;
    }

    System.out.println("Decimal equivalent: " + decimal);

    scanner.close();
  }
}
