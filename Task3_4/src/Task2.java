import java.io.*;

public class Task2 {
    public static void main(String[] args) {
        final int N = 60;
        long[] fib = new long[N];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i < N; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("fibonacci.csv"))) {
            for (int i = 0; i < N; i++) {
                writer.write(Long.toString(fib[i])); // Only the Fibonacci number
                writer.newLine();
            }
            System.out.println("Fibonacci sequence written to fibonacci.csv");
        } catch (IOException e) {
            System.err.println("Error writing CSV: " + e.getMessage());
        }
    }
}