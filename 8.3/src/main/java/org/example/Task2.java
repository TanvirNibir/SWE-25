package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Task 2: Collection operations with lambdas (no Stream API).
 */
public class Task2 {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 5, 8, 20, 15, 3, 12));

        System.out.println("=== Original numbers ===");
        printNumbers(numbers);

        // 1) Filter out even numbers using removeIf and a lambda
        numbers.removeIf(n -> n % 2 == 0);

        System.out.println("\n=== After removing even numbers ===");
        printNumbers(numbers);

        // 2) Double the remaining (odd) numbers using replaceAll and a lambda
        numbers.replaceAll(n -> n * 2);

        System.out.println("\n=== After doubling odd numbers ===");
        printNumbers(numbers);

        // 3) Sum the numbers using forEach and a lambda.
        //    We use a one-element array to hold the mutable sum reference.
        final int[] sumHolder = new int[1];
        numbers.forEach(n -> sumHolder[0] += n);
        int sum = sumHolder[0];

        System.out.println("\nSum of all numbers: " + sum);
    }

    private static void printNumbers(List<Integer> numbers) {
        numbers.forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}


