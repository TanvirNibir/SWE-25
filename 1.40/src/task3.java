import java.util.Scanner;

public class task3 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the size of the array: ");
    int size = scanner.nextInt();

    int[] array = new int[size];

    System.out.println("Enter the integers into the array:");
    for (int i = 0; i < size; i++) {
      System.out.print("Enter integer " + (i + 1) + ": ");
      array[i] = scanner.nextInt();
    }

    int[] uniqueArray = new int[size];
    int uniqueCount = 0;

    for (int i = 0; i < size; i++) {
      int numberToCheck = array[i];
      boolean found = false;

      for (int j = 0; j < uniqueCount; j++) {
        if (uniqueArray[j] == numberToCheck) {
          found = true;
          break;
        }
      }

      if (found == false) {
        uniqueArray[uniqueCount] = numberToCheck;
        uniqueCount++;
      }
    }

    System.out.print("The array without duplicates:\n");
    for (int i = 0; i < uniqueCount; i++) {
      System.out.print(uniqueArray[i] + " ");
    }

    scanner.close();
  }
}
