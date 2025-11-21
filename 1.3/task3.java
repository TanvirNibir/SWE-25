import java.util.Scanner;

public class task3 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter start: ");
    int start = scanner.nextInt();

    System.out.print("Enter end: ");
    int end = scanner.nextInt();

    System.out.println("Prime numbers between " + start + " and " + end + ":");

    for (int num = start; num <= end; num++) {
      boolean isPrime = true;

      if (num < 2) {
        isPrime = false;
      } else {
        for (int i = 2; i < num; i++) {
          if (num % i == 0) {
            isPrime = false;
            break;
          }
        }
      }

      if (isPrime) {
        System.out.print(num + " ");
      }
    }

    System.out.println();

    scanner.close();
  }
}
