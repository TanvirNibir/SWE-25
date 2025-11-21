import java.util.Scanner;

public class task2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the size of the array: ");
    int size = scanner.nextInt();

    int[] array = new int[size];

    System.out.println("Enter the integers into the array:");
    int i = 0;
    while (i < size) {
      System.out.print("Enter integer " + (i + 1) + ": ");
      array[i] = scanner.nextInt();
      i++;
    }

    int maxSum = array[0];
    int bestStart = 0;
    int bestEnd = 0;

    for (int start = 0; start < size; start++) {
      int sum = 0;
      for (int end = start; end < size; end++) {
        sum = sum + array[end];
        if (sum > maxSum) {
          maxSum = sum;
          bestStart = start;
          bestEnd = end;
        }
      }
    }

    System.out.println("Maximum sum: " + maxSum);
    System.out.println("Integers: " + (bestStart + 1) + "-" + (bestEnd + 1));

    scanner.close();
  }
}
