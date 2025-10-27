
public class task2 {
    public static void main(String[] args) {
        System.out.println("    *");
        System.out.println("   ***");
        System.out.println("  *****");
        System.out.println(" *******");

        int rows = 4;
        for (int i = 1; i <= rows; i++) {
            
            for (int j = 0; j < rows - i; j++) {
                System.out.print(" ");
            }
            
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println(); // Move to next line
        }

    }
}