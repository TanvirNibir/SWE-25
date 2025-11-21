import java.util.Scanner;

public class MedievalUnitsConverter {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    final double LUOTI_TO_GRAMS = 13.28;
    final int NAULA_TO_LUOTI = 32;
    final int LEIVISKA_TO_NAULA = 20;

    System.out.print("Weight (g): ");
    double weightInGrams = scanner.nextDouble();

    double totalLuoti = weightInGrams / LUOTI_TO_GRAMS;

    int leiviska = (int) (totalLuoti / (LEIVISKA_TO_NAULA * NAULA_TO_LUOTI));
    double remainingAfterLeiviska = totalLuoti - (leiviska * LEIVISKA_TO_NAULA * NAULA_TO_LUOTI);

    int naula = (int) (remainingAfterLeiviska / NAULA_TO_LUOTI);
    double remainingLuoti = remainingAfterLeiviska - (naula * NAULA_TO_LUOTI);
    System.out.printf("%.0f grams is %d leiviskä, %d naula, and %.2f luoti.%n",
        weightInGrams, leiviska, naula, remainingLuoti);

    scanner.close();
  }
}
