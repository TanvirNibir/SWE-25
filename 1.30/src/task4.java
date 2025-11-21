import java.util.Scanner;

public class task4 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    boolean perfectScore = false;

    while (perfectScore == false) {
      int score = 0;
      System.out.println("Welcome to the Multiplication Table Exam!");
      System.out.println("You will be given 10 multiplication problems.\n");

      for (int i = 1; i <= 10; i++) {
        int number1 = (int) (Math.random() * 10) + 1;
        int number2 = (int) (Math.random() * 10) + 1;
        int correctAnswer = number1 * number2;

        System.out.print("Problem " + i + ": " + number1 + " * " + number2 + " = ");
        int userAnswer = scanner.nextInt();

        if (userAnswer == correctAnswer) {
          System.out.println("Correct! ");
          score = score + 1;
        } else {
          System.out.println("Incorrect. The correct answer is " + correctAnswer);
        }
      }

      System.out.println("\nYour score: " + score + "/10");

      if (score == 10) {
        System.out.println("Congratulations! You have mastered the multiplication tables!");
        perfectScore = true;
      } else {
        System.out.println("You need to practice more. Let's try again!\n");
      }
    }

    scanner.close();
  }
}
