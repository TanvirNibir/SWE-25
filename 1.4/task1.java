import java.util.Scanner;

public class task1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] firstNames = { "Emma", "Liam", "Olivia", "Noah", "Ava", "Ethan", "Sophia", "Mason", "Isabella", "James" };
    String[] lastNames = { "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez",
        "Martinez" };

    System.out.print("How many random names should be generated? ");
    int numberOfNames = scanner.nextInt();

    int counter = 0;
    while (counter < numberOfNames) {
      int randomFirstIndex = (int) (Math.random() * 10);
      int randomLastIndex = (int) (Math.random() * 10);

      String firstName = firstNames[randomFirstIndex];
      String lastName = lastNames[randomLastIndex];
      String fullName = firstName + " " + lastName;

      System.out.println(fullName);
      counter++;
    }

    scanner.close();
  }
}
